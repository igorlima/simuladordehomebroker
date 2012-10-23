package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.AtivoRepository;

@Service
public class AtivoService{
	
	@Autowired
	private AtivoRepository ativoRepository;
	
	public Ativo procura (Integer id){
		return ativoRepository.procura(id);
	}
	
	public List<Ativo> listaTudo(){
		return ativoRepository.listaTudo();
	}
	
	public Ativo buscaPeloCodigo( String codigo ){
		return ativoRepository.buscaPeloCodigo(codigo);
	}
	
	public void salva( List<Ativo> ativos ){
		for( Ativo ativo : ativos )
			ativoRepository.salva(ativo);
		
		ativoRepository.comitar();
	}
	
	public void salva (Ativo ativo){
		ativoRepository.salva(ativo);
		ativoRepository.comitar();
	}
	
	public void remove (Ativo ativo){
		ativoRepository.remove(ativo);
		ativoRepository.comitar();
	}
}