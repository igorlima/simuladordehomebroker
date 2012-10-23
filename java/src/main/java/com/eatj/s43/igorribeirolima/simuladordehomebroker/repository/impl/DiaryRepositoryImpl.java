package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Diary;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.DiaryPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.DiaryRepository;

@Repository
public class DiaryRepositoryImpl implements DiaryRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Diary procura(DiaryPK id) {
		String jpql = "select diary from " + Diary.class.getName() + " as diary WHERE diary.data = :data AND diary.ativo.id = :idAtivo";
		Query query = entityManager.createQuery(jpql);
		query.setParameter( "idAtivo", id.getAtivo().getId() );
		query.setParameter( "data", id.getData() );
		query.setMaxResults(1);
		
		try{
			return (Diary) query.getSingleResult();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Diary> busca( Ativo ativo, Date dtInicio, Date dtFim ) {
		String jpql = "select diary from " + Diary.class.getName() + " as diary WHERE diary.ativo != null ";
		
		if( ativo != null && ativo.getId() != null ) jpql += " AND diary.ativo.id = :idAtivo ";
		if( dtInicio != null ) jpql += " AND diary.data >= :dtInicio ";
		if( dtFim != null ) jpql += " AND diary.data <= :dtFim ";
		
		jpql += " ORDER BY diary.data, diary.ativo.id ";
		
		Query query = entityManager.createQuery(jpql);
		if( ativo != null && ativo.getId() != null ) query.setParameter( "idAtivo", ativo.getId() );
		if( dtInicio != null ) query.setParameter( "dtInicio", dtInicio );
		if( dtFim != null ) query.setParameter( "dtFim", dtFim );
		query.setMaxResults( 4000 );

		try{
			return query.getResultList();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}
	
}
