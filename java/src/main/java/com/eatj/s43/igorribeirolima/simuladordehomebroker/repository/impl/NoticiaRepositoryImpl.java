package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Noticia;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.NoticiaRepository;

@Repository
public class NoticiaRepositoryImpl implements NoticiaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Noticia busca_por_id(Long id) {
		return entityManager.find( Noticia.class, id );
	}

	@SuppressWarnings("unchecked")
	public List<Noticia> busca( Ativo ativo, Date dataInicio, Date dataFim ){
		String jpql = "Select noticia FROM " + Noticia.class.getName() + " as noticia WHERE noticia.id != null ";
		
		if( ativo != null ) jpql += " AND noticia.ativo.id = :id_do_ativo ";
		if( dataInicio != null ) jpql += " AND noticia.data >= :dt_inicio ";
		if( dataFim != null ) jpql += " AND noticia.data <= :dt_fim ";
		Query query = entityManager.createQuery( jpql );
		
		if( ativo != null ) query.setParameter( "id_do_ativo" , ativo.getId() );
		if( dataInicio != null ) query.setParameter( "dt_inicio" , dataInicio );
		if( dataFim != null ) query.setParameter( "dt_fim" , dataFim );
		
		try{
			return query.getResultList();
		}catch ( NoResultException noResultException ) {
			return null;
		}
	}
	
	public void salva(Noticia noticia ){
		entityManager.merge( noticia );
	}
	
	public void salva( List<Noticia> noticias ){
		for( Noticia noticia : noticias )
			entityManager.merge( noticia );
	}
	
	public void comitar(){
		entityManager.flush();
	}
	
	
}
