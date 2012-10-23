package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Noticia;

public interface NoticiaRepository{

	Noticia busca_por_id ( Long id );
	List<Noticia> busca( Ativo ativo, Date dataInicio, Date dataFim );
	
	@Transactional
	void salva(Noticia noticia);
	
	@Transactional
	void salva(List<Noticia> noticias);
	
	@Transactional
	void comitar();
}
