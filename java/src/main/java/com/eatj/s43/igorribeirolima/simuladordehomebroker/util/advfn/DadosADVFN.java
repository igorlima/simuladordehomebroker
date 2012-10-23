package com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.transferobject.CotacaoAdvfnTO;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Controle_de_Thread;

public class DadosADVFN {
	
	public static final LoginADVFN login = new LoginADVFN();
	public static final LoginADVFN_Mobile loginMobile = new LoginADVFN_Mobile();
	public static final Map<String,CotacaoAdvfnTO> cotacoes = new HashMap<String,CotacaoAdvfnTO>(); 
	
	public synchronized static void atualizar_intraday( List<Ativo> ativos ){
		System.out.println( "*" + Util.getHoraAtual() + ": atualizando intradays em DadosADVFN..." );
		final Controle_de_Thread controle_de_thread = new Controle_de_Thread( 5L );
		
		for( Ativo ativo : ativos ){
			IntradayADVFN intraday = new IntradayADVFN( ativo, controle_de_thread );
			
			intraday.addObserver( DadosADVFN.login );
			DadosADVFN.login.addObserver( intraday );
			controle_de_thread.incremento( intraday );
			
			if( !controle_de_thread.limiteMaximo() ){
				new Thread( intraday ).start();
			}else{
				while( controle_de_thread.limiteMaximo() ) Util.sleep();
				
				new Thread( intraday ).start();
			}
		}
		
		while( !controle_de_thread.getQteThread().equals( 0L ) ) { Util.sleep(); }
		System.out.println( "*" + Util.getHoraAtual() + ": atualização intradays em DadosADVFN foi FINALIZADA!!!" );
	}
	
	public synchronized static void atualizar_cotacoes_em_DadosADVFN( List<String> codigos_dos_ativos ){
		System.out.println( Util.getHoraAtual() + " -> getting cotacoes " + codigos_dos_ativos.toString() + " " );
		final Controle_de_Thread controle_de_Thread = new Controle_de_Thread( 25L );
		
		for( String codigo_do_ativo : codigos_dos_ativos ){
			CotacaoADVFN cotacao = new CotacaoADVFN(codigo_do_ativo, controle_de_Thread);
			cotacao.addObserver( loginMobile );
			loginMobile.addObserver( cotacao );
			controle_de_Thread.incremento( cotacao );
			
			if( !controle_de_Thread.limiteMaximo() ){
				new Thread( cotacao ).start();
			}else{
				while( controle_de_Thread.limiteMaximo() )
					Util.sleep();
				
				new Thread( cotacao ).start();
			}
		}
		
		while( !controle_de_Thread.getQteThread().equals( 0L ) ) {
			Util.sleep();
		}
		
		System.out.println( Util.getHoraAtual() + " -> cotacoes atualizadas " + codigos_dos_ativos.toString() + " " );
	}
	
}
