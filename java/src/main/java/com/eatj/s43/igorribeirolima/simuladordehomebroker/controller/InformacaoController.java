package com.eatj.s43.igorribeirolima.simuladordehomebroker.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Diary;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Intraday;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.AtivoService;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.AtualizarService;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.DiaryService;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.FiltroAtivos;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.IntradayService;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.transferobject.CotacaoAdvfnTO;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Configuracao_de_Consulta;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.DadosADVFN;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.Util;

@Controller
@RequestMapping("/**")
public class InformacaoController {
	
	@Autowired( required = true )
	private AtivoService ativoService;
	
	@Autowired( required = true )
	private IntradayService intradayService;
	
	@Autowired( required = true )
	private DiaryService diaryService;
	
	@Autowired( required = true )
	private AtualizarService atualizarService;
	
	@RequestMapping( value="/ativos/accessCode/{accessCode}", method=RequestMethod.GET)
	public List<Ativo> getAtivos( @PathVariable String accessCode ){
		if( accessCode != null && accessCode.equals( Configuracao_de_Consulta.getString("Help.accessCode") ) ){
			FiltroAtivos filtroAtivos = new FiltroAtivos();
			filtroAtivos.atualizarAtivos();
			return filtroAtivos.getAtivos();
		}
		
		return null;
	}
	
	@RequestMapping( value="/ativos", method=RequestMethod.GET)
	public List<Ativo> getAtivos(){
		return ativoService.listaTudo();
	}
	
	@RequestMapping( value="/intraday/ativo/{codigoAtivo}/dataInicio/{dtInicio}/dataFim/{dtFim}", method=RequestMethod.GET)
	public List<Intraday> buscaIntraday( @PathVariable String codigoAtivo, @PathVariable String dtInicio, @PathVariable String dtFim ){
		return intradayService.busca( codigoAtivo, Util.converterStringToDate(dtInicio.replace( '-', '/')), Util.converterStringToDate(dtFim.replace( '-', '/')) );
	}
	
	@RequestMapping( value="/diary/ativo/{codigoAtivo}/dataInicio/{dtInicio}/dataFim/{dtFim}", method=RequestMethod.GET)
	public List<Diary> buscaDiary( @PathVariable String codigoAtivo, @PathVariable String dtInicio, @PathVariable String dtFim ){
		return diaryService.busca( codigoAtivo, Util.converterStringToDate(dtInicio.replace( '-', '/')), Util.converterStringToDate(dtFim.replace( '-', '/')) );
	}
	
	@RequestMapping( value="/intradays/codigoAtivo/{codigoAtivo}", method=RequestMethod.POST)
	public List<String> salvarIntradays( @PathVariable String codigoAtivo, @RequestBody String str_intradays ){
		List<String> l = new ArrayList<String>();
		try{
			if( str_intradays != null && codigoAtivo != null ){
				
				Ativo ativo = ativoService.buscaPeloCodigo( codigoAtivo );
				List<Intraday> intradays = Util.converterStringToDadosHistoricos( str_intradays, ativo );
				
				if( intradays != null && !intradays.isEmpty() ) intradayService.salva( intradays );
				
			}
			l.add( "OK!" );
		}catch(Exception e){
			l.add( e.getMessage() );
		}
		return l;
	}
	
	@RequestMapping( value="/cotacao/ativo/{codigoAtivo}", method=RequestMethod.GET)
	public CotacaoAdvfnTO buscaIntraday( @PathVariable String codigoAtivo ){
		if( DadosADVFN.cotacoes.containsKey( codigoAtivo ) )
			return DadosADVFN.cotacoes.get( codigoAtivo );
		
		return null;
	}
	
	@RequestMapping( value="/cotacao/atualizacao", method=RequestMethod.GET)
	public void atualizarCotacoes(){
		atualizarService.atualizarCotacoesADVFN();
	}
	
	@RequestMapping( value="/teste/accessCode/{accessCode}", method=RequestMethod.GET)
	public void teste( @PathVariable String accessCode ){
		if( accessCode != null && accessCode.equals( Configuracao_de_Consulta.getString("Help.accessCode") ) ){
			atualizarService.atualizarCotacoesIntraday();
		}
		return;
	}
	
	@RequestMapping( value="/hora", method=RequestMethod.GET)
	public List<String> horaServidor(){
		List<String> l = new ArrayList<String>();
		l.add( Util.getHoraAtual() );
		return l;
	}
	
	@RequestMapping( value="/requestHeader", method=RequestMethod.GET)
	public Map<String, String> tipoRequisicao( HttpServletRequest request ){
		Map<String,String> retorno = new HashMap<String, String>();
		
		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration = request.getHeaderNames();
		
		while( enumeration.hasMoreElements() ){
			String headerName = enumeration.nextElement();
			retorno.put( headerName , request.getHeader( headerName ) );
		}
		
		Util.imprimirMap( retorno );
		
		return retorno;
	}
}