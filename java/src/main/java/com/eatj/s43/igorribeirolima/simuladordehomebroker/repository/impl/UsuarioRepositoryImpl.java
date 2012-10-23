package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Usuario;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Usuario busca_por_id(Long id) {
		return entityManager.find( Usuario.class, id );
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar_todos(){
		String jpql = "Select usuario FROM " + Usuario.class.getName() + " as usuario ";
		Query query = entityManager.createQuery( jpql );
		
		try{
			return query.getResultList();
		}catch ( NoResultException noResultException ) {
			return null;
		}
	}
	
	public void salva(Usuario usuario ){
		entityManager.merge( usuario );
	}
	
	public void remove(Usuario usuario ){
		entityManager.remove( entityManager.getReference( Usuario.class, usuario.getId() ) );
		
//		if( usuario == null || usuario.getId() == null )
//			return;
//		
//		String jpql = "DELETE FROM  " + Usuario.class.getSimpleName() + " as usuario WHERE usuario.id = :id " ;
//		Query query = entityManager.createQuery( jpql );
//		query.setParameter( "id", usuario.getId() );
//		
//		try{
//			query.executeUpdate();
//		}catch( Exception exception ){
//			exception.printStackTrace();
//		}
	}
	
	public void comitar(){
		entityManager.flush();
	}
	
	
}
