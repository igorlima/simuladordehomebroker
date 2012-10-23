package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Constantes;

public class FiltroAtivos {
	private RestTemplate restTemplate = new RestTemplate();
	private List<Ativo> ativos = new ArrayList<Ativo>();
	private String strConteudoURL;
	
	public FiltroAtivos(){
		try {
			strConteudoURL = this.restTemplate.getForObject( Constantes.urlInfoAtivo, String.class );
			//strConteudoURL = RequisicaoHTTP.requisicaoGET( Constantes.urlInfoAtivo );
		} catch( Exception e ){
			strConteudoURL = "";
			e.printStackTrace();
		}
	}
	
	public void atualizarAtivos(){
		//Extrai ultimos noticias
		String strProventosAux = "";
		String conteudoAux = "";
		
		strProventosAux = this.strConteudoURL.substring(1);
		while( strProventosAux.indexOf( "class=\"Select\">" ) != -1  ){
			Ativo novoAtivo = new Ativo();
			//codigo ativo
			strProventosAux = strProventosAux.substring( strProventosAux.indexOf( "class=\"Select\">" ) + 1 );
			strProventosAux =  strProventosAux.substring( strProventosAux.indexOf( ">" ) + 1 );
			conteudoAux = strProventosAux.substring( 0, strProventosAux.indexOf( "<" ) );
			novoAtivo.setCodigo( conteudoAux );
			
			//nome ativo
			strProventosAux = strProventosAux.substring( strProventosAux.indexOf( "class=\"Select\">" ) + 1 );
			strProventosAux =  strProventosAux.substring( strProventosAux.indexOf( ">" ) + 1 );
			conteudoAux = strProventosAux.substring( 0, strProventosAux.indexOf( "<" ) );
			novoAtivo.setNome_pregao( conteudoAux  );
			
			//empresa ativo
			strProventosAux = strProventosAux.substring( strProventosAux.indexOf( "class=\"Select\">" ) + 1 );
			strProventosAux =  strProventosAux.substring( strProventosAux.indexOf( ">" ) + 1 );
			conteudoAux = strProventosAux.substring( 0, strProventosAux.indexOf( "<" ) );
			novoAtivo.setNome_companhia( conteudoAux );
			
			ativos.add( novoAtivo );
			
			System.out.println( "Ativo: " + novoAtivo.getCodigo() + "..." );
		}
		
	}

	public List<Ativo> getAtivos() {
		return ativos;
	}

	public void setAtivos(List<Ativo> ativos) {
		this.ativos = ativos;
	}

}
