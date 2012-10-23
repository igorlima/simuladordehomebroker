package com.eatj.s43.igorribeirolima.simuladordehomebroker.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Configuracao_de_Consulta;

@Controller
@RequestMapping("/ajuda/**")
public class AjudaController {

	@RequestMapping( value="/ajuda", method=RequestMethod.GET)
	public ArrayList<String[]> helpSimples(){
		ArrayList<String[]> helpList;
		
		helpList = new ArrayList<String[]>();
		
		helpList.add( new String[]{ "help" } );
		helpList.add( new String[]{ "Path.GET: /ajuda/accessCode/{accessCode}", "Description: ajuda" } );
		
		return helpList;
				
	}
	
	@RequestMapping( value="/ajuda/accessCode/{accessCode}", method=RequestMethod.GET)
	public ArrayList<String[]> help( @PathVariable String accessCode){
		ArrayList<String[]> helpList;
		if( accessCode == null ){
			helpList = new ArrayList<String[]>();
			helpList.add( new String[]{ "Exception", "accessCode requerida" } );
		}else if( accessCode.equals( Configuracao_de_Consulta.getString("Help.accessCode") ) ){
			helpList = new ArrayList<String[]>();
			
			
			helpList.add( new String[]{ "help" } );
			
			helpList.add( new String[]{ "Path.GET: /ativos/accessCode/{accessCode}", "Description: pega todos os ativos (consulta feita na web)." } );
			helpList.add( new String[]{ "Path.GET: /ativos", "Description: pega todos os ativos (consulta feita no BD)." } );
			helpList.add( new String[]{ "Path.GET: /cotacao/ativo/{codigoAtivo}", "Description: pega a cotação ADVFN do ativo." } );
			helpList.add( new String[]{ "Path.GET: /cotacao/atualizacao", "Atualiza as cotações ADVFN de todos os ativos." } );
			helpList.add( new String[]{ "Path.GET: /diary/ativo/{codigoAtivo}/dataInicio/{dtInicio}/dataFim/{dtFim}", "Description: Pesquisa diary" } );
			helpList.add( new String[]{ "Path.GET: /hora", "Description: ver horas do servidor." } );
			helpList.add( new String[]{ "Path.GET: /intraday/ativo/{codigoAtivo}/dataInicio/{dtInicio}/dataFim/{dtFim}", "Description: Pesquisa intraday" } );
			helpList.add( new String[]{ "Path.GET: /noticia/busca/codigoAtivo/{codigoAtivo}/dataInicio/{dataInicio}/dataFim/{dataFim}", "Description: visualizar notícias." } );
			helpList.add( new String[]{ "Path.GET: /noticia/atualizacaoDasNoticias", "Description: atualizar notícias." } );
			helpList.add( new String[]{ "Path.GET: /requestHeader", "Description: ver o cabeçalho de requisição." } );
			helpList.add( new String[]{ "Path.GET: /teste/accessCode/{accessCode}", "Description: atualiza as cotacoes antes da hora programada." } );
			
			return helpList;
				
		}else{
			helpList = new ArrayList<String[]>();
			helpList.add( new String[]{ "Exception", "accessCode Invalida" } );
		}
		
		
		return helpList;
	}
	
}
