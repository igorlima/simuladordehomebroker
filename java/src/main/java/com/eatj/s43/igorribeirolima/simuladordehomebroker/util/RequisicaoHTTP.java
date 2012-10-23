package com.eatj.s43.igorribeirolima.simuladordehomebroker.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

public class RequisicaoHTTP {
	/*
	public static String requisicaoGET( String strUrl ) throws IllegalStateException, IOException{
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet( strUrl );
		
		// Execute the request
		HttpResponse httpResponse = httpClient.execute(httpget);
		
		// Examine the response status
		//StatusLine statusLine = httpResponse.getStatusLine();
		
		HttpEntity entity = httpResponse.getEntity();
		String conteudoUrl = null;
		
		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(instream));
				// do something useful with the response
				String line = null;
				conteudoUrl = "";
				while ((line = reader.readLine()) != null) {
					conteudoUrl += line + "\n";
				}
				
			} catch (IOException ex) {
				
				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				ex.printStackTrace();
				
			} catch (RuntimeException ex) {
				
				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httpget.abort();
				ex.printStackTrace();
				
			} finally {
				
				// Closing the input stream will trigger connection release
				instream.close();
				
			}
		}
		
		return conteudoUrl;
	}
	
	public static String requisicaoPOST( String strUrl, Map<String, String> values ) throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost( strUrl );
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		for(  String key : values.keySet() )
			nvps.add(new BasicNameValuePair( key, values.get(key) ) );
		
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		// Execute the request
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		// Examine the response status
		//StatusLine statusLine = httpResponse.getStatusLine();
		
		HttpEntity entity = httpResponse.getEntity();
		String conteudoUrl = null;
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(instream));
				// do something useful with the response
				String line = null;
				conteudoUrl = "";
				while ((line = reader.readLine()) != null) {
					conteudoUrl += line + "\n";
				}
				System.out.println(conteudoUrl);
				
			} catch (IOException ex) {
				
				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				throw ex;
				
			} catch (RuntimeException ex) {
				
				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httpPost.abort();
				throw ex;
				
			} finally {
				
				// Closing the input stream will trigger connection release
				instream.close();
				
			}
		}
		
		return conteudoUrl;
		
	}
	*/
	
	public static String requisicaoGET( Login login, String strUrl ) throws IllegalStateException, IOException{
		return requisicaoGET(login, strUrl, false );
	}
	
	public static String requisicaoGET( Login login, String strUrl, boolean requisacaoDeCelular ) throws IllegalStateException, IOException{
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet( strUrl );
		
		if( requisacaoDeCelular ){
			httpget.setHeader( "x-wap-profile", "\"http://wap.samsungmobile.com/uaprof/GT-S8500B.xml\"" );
			httpget.setHeader( "user-agent", "Mozilla/5.0 (SAMSUNG; SAMSUNG-GT-S8500B/1.0; U; Bada/1.0; pt-br) AppleWebKit/533.1 (KHTML, like Gecko) Dolfin/2.0 Mobile WVGA SMM-MMS/1.2.0 OPN-B" );
		}
		
		// Execute the request
		HttpResponse response = httpClient.execute(httpget, login.getHttpContext() );
		
		// Examine the response status
		StatusLine statusLine = response.getStatusLine();
		statusLine.getStatusCode();
		
		HttpEntity entity = response.getEntity();
		String conteudoUrl = null;
		
		// If the response does not enclose an entity, there is no need
		// to worry about connection release
		if (entity != null) {
			InputStream instream = entity.getContent();
			try {
				
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(instream));
				// do something useful with the response
				String line = null;
				conteudoUrl = "";
				while ((line = reader.readLine()) != null) {
					conteudoUrl += line + "\n";
				}
				
			} catch (IOException ex) {
				
				// In case of an IOException the connection will be released
				// back to the connection manager automatically
				ex.printStackTrace();
				
			} catch (RuntimeException ex) {
				
				// In case of an unexpected exception you may want to abort
				// the HTTP request in order to shut down the underlying
				// connection and release it back to the connection manager.
				httpget.abort();
				ex.printStackTrace();
				
			} finally {
				
				// Closing the input stream will trigger connection release
				instream.close();
				
			}
		}
		
		return conteudoUrl;
	}
	
	public static HttpResponse requisicaoPOST( Login login, String strUrl, Map<String, String> values ) throws ClientProtocolException, IOException {
		return requisicaoPOST(login, strUrl, values, false );
	}
	
	public static HttpResponse requisicaoPOST( Login login, String strUrl, Map<String, String> values, boolean requisicaoDeCelular ) throws ClientProtocolException, IOException {
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost( strUrl );
		
		if( requisicaoDeCelular ){
			httpPost.setHeader( "x-wap-profile", "\"http://wap.samsungmobile.com/uaprof/GT-S8500B.xml\"" );
			httpPost.setHeader( "user-agent", "Mozilla/5.0 (SAMSUNG; SAMSUNG-GT-S8500B/1.0; U; Bada/1.0; pt-br) AppleWebKit/533.1 (KHTML, like Gecko) Dolfin/2.0 Mobile WVGA SMM-MMS/1.2.0 OPN-B" );
		}
		
		
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		for(  String key : values.keySet() )
			nvps.add(new BasicNameValuePair( key, values.get(key) ) );
			
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		// Execute the request
        return httpClient.execute( httpPost, login.getHttpContext() );
		
	}
	
}
