package com.eatj.s43.igorribeirolima.simuladordehomebroker.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Noticia;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.service.NoticiaService;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired(required = true)
	private NoticiaService service;
	
	@RequestMapping(value = "/busca/codigoAtivo/{codigoAtivo}/dataInicio/{dataInicio}/dataFim/{dataFim}", method = RequestMethod.GET)
	public List<Noticia> busca( String codigoAtivo, Date dataInicio, Date dataFim ) {
		return this.service.busca(codigoAtivo, dataInicio, dataFim);
	}
	
	@RequestMapping(value = "/atualizacaoDasNoticias", method = RequestMethod.GET)
	public void atualizacaoDasNoticasDaBovespa() {
		service.atualizacaoDasNoticasDaBovespa( 7626L );
	}
	
}
