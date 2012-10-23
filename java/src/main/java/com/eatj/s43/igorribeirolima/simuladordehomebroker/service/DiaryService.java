package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Diary;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.DiaryPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.DiaryRepository;

@Service
public class DiaryService{
	
	@Autowired
	private AtivoService ativoService;
	
	@Autowired
	private DiaryRepository diaryRepository;
	
	public Diary procura ( DiaryPK id ){
		return diaryRepository.procura(id);
	}
	
	public List<Diary> busca( String codigoAtivo, Date dtInicio, Date dtFim ){
		return diaryRepository.busca( ativoService.buscaPeloCodigo(codigoAtivo), dtInicio, dtFim);
	}
	
}