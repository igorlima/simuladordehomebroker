package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Usuario;

public interface UsuarioRepository{

	Usuario busca_por_id ( Long id );
	List<Usuario> listar_todos();
	
	@Transactional
	void salva(Usuario usuario);
	
	@Transactional
	void remove(Usuario usuario);
	
	@Transactional
	void comitar();
}
