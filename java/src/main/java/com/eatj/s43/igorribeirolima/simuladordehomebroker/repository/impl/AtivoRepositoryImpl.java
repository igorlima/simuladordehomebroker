package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.AtivoRepository;

@Repository
public class AtivoRepositoryImpl implements AtivoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salva( Ativo ativo ){
	    entityManager.merge( ativo );
	}
	
	public void remove( Ativo ativo ){
	    entityManager.remove( ativo );
	}
	
	public Ativo procura (Integer id) {
		String jpql = "select ativo from Ativo as ativo WHERE ativo.id = :id ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter( "id", id );
		query.setMaxResults(1);
		
		try{
			return (Ativo) query.getSingleResult();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Ativo> listaTudo() {
		String jpql = "select ativo from Ativo as ativo ORDER BY ativo.codigo";
		Query query = entityManager.createQuery(jpql);

		try{
			return query.getResultList();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}

	public Ativo buscaPeloCodigo( String codigo ){
		String jpql = "from " + Ativo.class.getName() +" a where a.codigo like :codigo";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("codigo", "%" + codigo + "%" );
		query.setMaxResults(1);
		
		try{
			return (Ativo) query.getSingleResult();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}
	
	public void comitar(){
		entityManager.flush();
	}
}
