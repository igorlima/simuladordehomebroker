package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository;

import java.util.Date;
import java.util.List;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Diary;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.DiaryPK;

public interface DiaryRepository{

	Diary procura ( DiaryPK id );
	List<Diary> busca( Ativo ativo, Date dtInicio, Date dtFim );
	
}
