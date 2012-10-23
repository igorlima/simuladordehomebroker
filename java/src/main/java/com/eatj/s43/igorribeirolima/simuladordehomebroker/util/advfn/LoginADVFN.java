package com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Login;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.RequisicaoHTTP;

public class LoginADVFN extends Observable implements Login{
	
	private static final CookieStore cookieStore = new BasicCookieStore();
	private static final HttpContext localContext = new BasicHttpContext();
	private Boolean logado = false;
	private Boolean logging = false;
	private static final Map< String, String > dadosAcesso = new HashMap<String, String>();
	
	static{
		localContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
		
		try {
			dadosAcesso.put( "btn", "login_sub" );
			dadosAcesso.put( "login_pid", "mon" );
			dadosAcesso.put( "login_pw", Configuracao_de_ADVFN.getString("DadosDeAcesso.password") );
			dadosAcesso.put( "login_query", "" );
			dadosAcesso.put( "login_sub", "Login" );
			dadosAcesso.put( "login_un", Configuracao_de_ADVFN.getString("DadosDeAcesso.user") );
			dadosAcesso.put( "pid", "login" );
			dadosAcesso.put( "qkbtn", "" );
			dadosAcesso.put( "qksymbol", "" );
			
		} catch (Exception e) {
			System.out.println( e.getMessage() );
		}
	}
	
	public void update( Observable obj, Object logado ){
		
		if( logado instanceof Boolean && !getLogging() ){
			setLogado( (Boolean)logado );
		}
		
		setChanged();
		notifyObservers( false ); //parar as requisicoes
		efetuarLogin();
	}
	
	private synchronized void efetuarLogin(){
		if( !getLogado() && !getLogging() ){
			if( login() ){
				setChanged();
				notifyObservers( true );
			}else{
				setChanged();
				notifyObservers( null );
			}
		}
	}
	
	private synchronized Boolean login(){
		if( getLogado() ) return getLogado();
		
		setLogging( true );
		setLogado( false );
		
		System.out.println( "Efetuando login ADVFN by " + Configuracao_de_ADVFN.getString("DadosDeAcesso.user") + " ..." ); //$NON-NLS-1$
		
		HttpResponse response = null;
		try {
			response = RequisicaoHTTP.requisicaoPOST( this, Configuracao_de_ADVFN.getString("DadosDeAcesso.pageLogin"), LoginADVFN.dadosAcesso );
		} catch (Exception e) {
			System.out.print( "Não foi possível logar em ADVFN. Motivo: " + e.getMessage() + "." );
			setLogado( false );
		}
		
		StatusLine statusLine = null;
		if( response != null ) statusLine = response.getStatusLine();
		if( statusLine != null && statusLine.getStatusCode() == 302 && statusLine.getReasonPhrase().indexOf( "Found" ) != -1 ){
			System.out.println( "Logado em ADVFN!" );
			setLogado( true );
		}else{
			System.out.println( "Não foi possível efetuar o login!" );
			setLogado( false );
		}
		
		Util.sleep();
		setLogging( false );
		return getLogado();
	}
	
	public boolean isLogado( String strHtml ){
		if( strHtml.contains( Configuracao_de_ADVFN.getString("DadosDeAcesso.isNotLogado") ) )
			return false;
		else
			return true;
	}
	
	public HttpContext getHttpContext() {
		return localContext;
	}
	
	private Boolean getLogado() {
		return logado;
	}
	
	private void setLogado( Boolean logado ) {
		this.logado = logado;
	}

	private Boolean getLogging() {
		return logging;
	}
	
	private void setLogging( Boolean logging ) {
		this.logging = logging;
	}
}
