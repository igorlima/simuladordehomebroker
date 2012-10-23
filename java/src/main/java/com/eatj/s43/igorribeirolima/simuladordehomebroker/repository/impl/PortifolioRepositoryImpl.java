package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Portifolio;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.PortifolioPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Usuario;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.PortifolioRepository;

@Repository
public class PortifolioRepositoryImpl implements PortifolioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Portifolio busca_por_id( PortifolioPK pk ) {
		return entityManager.find( Portifolio.class, pk );
	}

	@SuppressWarnings("unchecked")
	public List<Portifolio> busca_portifolio_do_usuario( Usuario usuario ){
		String jpql = "Select portifolio FROM " + Portifolio.class.getName() + " as portifolio WHERE portifolio.usuario.id = :id_do_usuario ";
		Query query = entityManager.createQuery( jpql );
		query.setParameter( "id_do_usuario" , usuario.getId() );
		
		try{
			return query.getResultList();
		}catch ( NoResultException noResultException ) {
			return null;
		}
	}
	
	public void salva(Portifolio portifolio ){
		entityManager.merge( portifolio );
	}
	
	public void remove(Portifolio portifolio ){
		entityManager.remove( entityManager.getReference( Portifolio.class, new PortifolioPK( portifolio.getAtivo(), portifolio.getUsuario() ) ) );
	}
	
	public void comitar(){
		entityManager.flush();
	}
	
	
}
