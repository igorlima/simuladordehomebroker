package com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.springframework.web.client.RestTemplate;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Controle_de_Thread;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.RequisicaoHTTP;

public class IntradayADVFN extends Observable implements Observer, Runnable {
	
	private Ativo ativo;
	private String strHtml;
	private Controle_de_Thread controle_de_thread;
	private boolean isCotacaoColetada = false;
	private RestTemplate restTemplate = new RestTemplate();
	
	public IntradayADVFN( Ativo ativo, Controle_de_Thread controle_de_thread ) {
		this.ativo = ativo;
		this.controle_de_thread = controle_de_thread;
		System.out.println( ativo.getCodigo() + "... " );
	}
	
	public IntradayADVFN( IntradayADVFN cotacaoAdvfn ) {
		this( cotacaoAdvfn.getAtivo(), cotacaoAdvfn.getControle_de_thread() );
	}
	
	public void update( Observable loginADVFN, Object continuarRequisicao ){
		clearChanged();
		
		if( continuarRequisicao == null || !(continuarRequisicao instanceof Boolean)  ){
			new Thread( this ).interrupt();
			this.deleteObserver( DadosADVFN.login );
			DadosADVFN.login.deleteObserver( this );
			this.getControle_de_thread().decremento( this );
		}
		
		if( (Boolean)continuarRequisicao ){
			new Thread( this ).start();
		}else{
			if( isCotacaoColetada() ){
				this.deleteObserver( DadosADVFN.login );
				DadosADVFN.login.deleteObserver( this );
			}
			new Thread( this ).interrupt();
		}
	}
	
	public void run() {
		try {
			if( getIntraday_do_ADVFN() ){
				//Se não estiver logado	
				if( !DadosADVFN.login.isLogado( strHtml ) ){
					setChanged();
					notifyObservers( false );
				}else{
					this.isCotacaoColetada = true;
					
					if( strHtml != null && strHtml.length() > 0 )
						this.restTemplate.postForObject(  Configuracao_de_ADVFN.getString( "Service.salvarIntraday" ) + ativo.getCodigo(), strHtml, List.class );
					
					this.deleteObserver( DadosADVFN.login );
					DadosADVFN.login.deleteObserver( this );
					controle_de_thread.decremento( this );
				}
			}else{
				this.deleteObserver( DadosADVFN.login );
				DadosADVFN.login.deleteObserver( this );
				controle_de_thread.decremento( this );
			}
			
			
		} catch (Exception e) {
			this.deleteObserver( DadosADVFN.login );
			DadosADVFN.login.deleteObserver( this );
			controle_de_thread.decremento( this );
			System.out.println( "Não foi possível atualizar a cotacao do ativo " + ativo.getCodigo() + ". Motivo: " + e.getMessage() + "." );
		}
	}
	
	private boolean getIntraday_do_ADVFN(){
		this.strHtml = "";
		
		String strUrl = Configuracao_de_ADVFN.getString("DadosDeAcesso.urlintraday") + ativo.getCodigo();
			
		try {
			this.strHtml = RequisicaoHTTP.requisicaoGET( DadosADVFN.login, strUrl );
			return true;
		} catch (Exception e) {
			System.out.println( "Não foi possível obter a cotação do ativo " + ativo.getCodigo() + ". Motivo " + e.getMessage() + "." );
		}
		
		return false;
	}

	public boolean isCotacaoColetada() {
		return isCotacaoColetada;
	}
	
	public Controle_de_Thread getControle_de_thread() {
		return controle_de_thread;
	}

	public Ativo getAtivo() {
		return this.ativo;
	}

}
