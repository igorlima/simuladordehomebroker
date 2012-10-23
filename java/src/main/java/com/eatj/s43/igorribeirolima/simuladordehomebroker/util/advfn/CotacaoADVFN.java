package com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn;

import java.util.Observable;
import java.util.Observer;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Controle_de_Thread;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.RequisicaoHTTP;

public class CotacaoADVFN extends Observable implements Observer, Runnable {
	private String codigo_do_ativo;
	private String strHtml;
	private Controle_de_Thread controle_de_thread;
	private boolean isCotacaoColetada = false;
	
	public CotacaoADVFN( String codigo_do_ativo, Controle_de_Thread controle_de_thread ) {
		this.codigo_do_ativo = codigo_do_ativo;
		this.controle_de_thread = controle_de_thread;
	}
	
	public CotacaoADVFN( CotacaoADVFN cotacaoAdvfn ) {
		this.codigo_do_ativo = cotacaoAdvfn.getCodigo_do_ativo();
		this.controle_de_thread = cotacaoAdvfn.getControle_de_thread();
	}
	
	public void update( Observable loginADVFN_Mobile, Object continuarRequisicao ){
		clearChanged();
		
		if( continuarRequisicao == null || !(continuarRequisicao instanceof Boolean)  ){
			new Thread( this ).interrupt();
			this.deleteObserver( DadosADVFN.loginMobile );
			DadosADVFN.loginMobile.deleteObserver( this );
			this.getControle_de_thread().decremento( this );
		}
		
		if( (Boolean)continuarRequisicao ){
			new Thread( this ).start();
		}else{
			if( isCotacaoColetada() ){
				this.deleteObserver( DadosADVFN.loginMobile );
				DadosADVFN.loginMobile.deleteObserver( this );
			}
			new Thread( this ).interrupt();
		}
	}
	
	public void run() {
		try {
			if( getCotacao_do_ADVFN() ){
				//Se não estiver logado	
				if( !DadosADVFN.loginMobile.isLogado( strHtml ) ){
					setChanged();
					notifyObservers( false );
				}else{
					this.isCotacaoColetada = true;
					DadosADVFN.cotacoes.put( codigo_do_ativo, Util.converterStringToCotacaoADVFN(strHtml) );
					
					this.deleteObserver( DadosADVFN.loginMobile );
					DadosADVFN.loginMobile.deleteObserver( this );
					controle_de_thread.decremento( this );
				}
			}else{
				this.deleteObserver( DadosADVFN.loginMobile );
				DadosADVFN.loginMobile.deleteObserver( this );
				controle_de_thread.decremento( this );
			}
			
			
		} catch (Exception e) {
			this.deleteObserver( DadosADVFN.loginMobile );
			DadosADVFN.loginMobile.deleteObserver( this );
			controle_de_thread.decremento( this );
			System.out.println( "Não foi possível atualizar a cotacao do ativo " + codigo_do_ativo + ". Motivo: " + e.getMessage() + "." );
		}
	}
	
	private boolean getCotacao_do_ADVFN(){
		this.strHtml = "";
		String strUrl = Configuracao_de_ADVFN.getString("Mobile.urlquote") + codigo_do_ativo.toLowerCase();
		
		try {
			this.strHtml = RequisicaoHTTP.requisicaoGET( DadosADVFN.loginMobile, strUrl, true );
			return true;
		} catch (Exception e) {
			System.out.println( "Não foi possível obter a cotação do ativo " + codigo_do_ativo + ". Motivo " + e.getMessage() + "." );
		}
		
		return false;
	}

	public boolean isCotacaoColetada() {
		return isCotacaoColetada;
	}
	
	public Controle_de_Thread getControle_de_thread() {
		return controle_de_thread;
	}

	public String getCodigo_do_ativo() {
		return codigo_do_ativo;
	}

}
