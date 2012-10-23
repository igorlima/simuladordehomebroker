package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Portifolio;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.PortifolioPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Usuario;

public interface PortifolioRepository{

	Portifolio busca_por_id ( PortifolioPK pk );
	List<Portifolio> busca_portifolio_do_usuario( Usuario usuario );
	
	@Transactional
	void salva(Portifolio portifolio);
	
	@Transactional
	void remove(Portifolio portifolio);
	
	@Transactional
	void comitar();
}
