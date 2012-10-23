package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;

public interface AtivoRepository {
	
	Ativo procura (Integer id);
	List<Ativo> listaTudo();
	Ativo buscaPeloCodigo( String codigo );
	
	@Transactional
	void salva (Ativo ativo);
	
	@Transactional
	void remove (Ativo ativo);
	
	@Transactional
	void comitar();
}
