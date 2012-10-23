package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Intraday;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.IntradayPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.IntradayRepository;

@Service
public class IntradayService{
	
	@Autowired
	private AtivoService ativoService;
	
	@Autowired
	private IntradayRepository intradayRepository;
	
	public Intraday procura ( IntradayPK id ){
		return intradayRepository.procura(id);
	}
	
	public List<Intraday> busca( String codigoAtivo, Date dtInicio, Date dtFim ){
		return intradayRepository.busca( ativoService.buscaPeloCodigo(codigoAtivo), dtInicio, dtFim);
	}
	
	public void salva(Intraday cotacao){
		intradayRepository.salva(cotacao);
		intradayRepository.comitar();
	}
	
	public void salva( List<Intraday> cotacoes ) throws Exception{
		intradayRepository.salva(cotacoes);
		intradayRepository.comitar();
	}
	
}