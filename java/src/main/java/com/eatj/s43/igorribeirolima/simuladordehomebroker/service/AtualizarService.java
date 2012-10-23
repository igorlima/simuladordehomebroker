package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.DadosADVFN;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.Util;

@Service
public class AtualizarService{
	
	@Autowired
	private AtivoService ativoService;
	
	public void atualizarAtivos(){
		FiltroAtivos filtrosAtivos = new FiltroAtivos();
		filtrosAtivos.atualizarAtivos();
		
		
		List<Ativo> ativos = filtrosAtivos.getAtivos();
		for( Ativo ativo : ativos )
			salvarAtivo(ativo);
		
	}
	
	public void salvarAtivo( Ativo ativo ){
		
		//verificar se existe ativo com o mesmo codigo 
		Ativo ativoAux = ativoService.buscaPeloCodigo( ativo.getCodigo() );
		if( ativoAux != null ) ativo.setId( ativoAux.getId() );
		
		ativoService.salva(ativo);
		
		System.out.println("Dados do ativo " + ativo.getCodigo()
				+ " atualizado.");
	}
	
	//http://www.quartz-scheduler.org/docs/tutorials/crontrigger.html
	//aceiona à meia-noite de segunda a sexta
	@Scheduled(cron="0 0 18 * * SUN-SAT")
	public synchronized void atualizarCotacoesIntraday(){
		System.out.println( ">>" + Util.getHoraAtual() + ": executando atualização da cotações de intraday..." );
		
		DadosADVFN.atualizar_intraday( ativoService.listaTudo() );
		
		System.out.println( ">>" + Util.getHoraAtual() + ": atualização da cotações de intraday FINALIZADA!!!" );
		
	}
	
	@Scheduled(cron="0 0 6 * * SUN-SAT")
	public synchronized void atualizarCotacoesADVFN(){
		List<Ativo> ativos = ativoService.listaTudo();
		List<String> codigos_dos_ativos = new ArrayList<String>();
		
		for( Ativo ativo : ativos ) codigos_dos_ativos.add( ativo.getCodigo() );
			
		DadosADVFN.atualizar_cotacoes_em_DadosADVFN(codigos_dos_ativos);
	}
	
}