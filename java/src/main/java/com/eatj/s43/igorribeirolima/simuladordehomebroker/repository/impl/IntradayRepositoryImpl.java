package com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Intraday;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.IntradayPK;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.IntradayRepository;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.Util;

@Repository
public class IntradayRepositoryImpl implements IntradayRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	public Intraday procura(IntradayPK id) {
		String jpql = "select intraday from " + Intraday.class.getName() + " as intraday WHERE intraday.data_hora = :data_hora AND intraday.ativo.id = :idAtivo";
		Query query = entityManager.createQuery(jpql);
		query.setParameter( "idAtivo", id.getAtivo().getId() );
		query.setParameter( "data_hora", id.getData_hora() );
		query.setMaxResults(1);
		
		try{
			return (Intraday) query.getSingleResult();
		}catch( NoResultException noResultException ) {
			return null;
		}
	}

	public void salva(Intraday intraday ){
		if( intraday.getAtivo() != null && intraday.getAtivo().getId() != null && intraday.getData_hora() != null ){
			try{
				entityManager.merge( intraday );
			}catch( Exception e ){
				System.out.println( e.getMessage() + ". " 
								+ intraday.getAtivo().getCodigo()
								+ " (id: "
								+ intraday.getAtivo().getId()
								+ "), data_hora: "
								+ Util.converterDateToString(intraday
										.getData_hora()) );
			}
		}
	}
	
	public void salva( List<Intraday> cotacoes ) throws Exception{
		if( cotacoes == null ) throw new Exception( "Lista de cotacoes igual a NULL." );
		
		Long dtMin = Util.getDateMinimo( cotacoes );
		Long dtMax = Util.getDateMaximo( cotacoes );
		List<Ativo> ativos = Util.getAtivos( cotacoes );
		
		for( Ativo ativo : ativos ) Util.remove( cotacoes, busca(ativo, new Date(dtMin), new Date(dtMax) ) );
		
		System.out.print( "Salvando " + cotacoes.size() + " intraday's: " + Util.toString(ativos) + ". " );
		for( Intraday intraday : cotacoes ){
			salva( intraday );
		}
		System.out.println( "Intraday's de " + Util.toString(ativos) + " salvo(s) com sucesso." );
		
	}

	@SuppressWarnings("unchecked")
	public List<Intraday> busca( Ativo ativo, Date dtInicio, Date dtFim ) {
		String jpql = "select intraday from " + Intraday.class.getName() + " as intraday WHERE intraday.ativo != null ";
		
		if( ativo != null && ativo.getId() != null ) jpql += " AND intraday.ativo.id = :idAtivo ";
		if( dtInicio != null ) jpql += " AND intraday.data_hora >= :dtInicio ";
		if( dtFim != null ) jpql += " AND intraday.data_hora <= :dtFim ";
		
		jpql += " ORDER BY intraday.data_hora, intraday.ativo.id ";
		
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
	
	public void comitar(){
		entityManager.flush();
	}
	
	
}
