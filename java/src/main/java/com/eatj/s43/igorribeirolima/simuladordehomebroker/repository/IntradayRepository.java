package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Intraday;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.IntradayPK;

public interface IntradayRepository{

	Intraday procura ( IntradayPK id );
	List<Intraday> busca( Ativo ativo, Date dtInicio, Date dtFim );
	
	@Transactional
	void salva(Intraday cotacao);
	
	@Transactional
	void salva( List<Intraday> cotacoes ) throws Exception;
	
	@Transactional
	void comitar();
}
