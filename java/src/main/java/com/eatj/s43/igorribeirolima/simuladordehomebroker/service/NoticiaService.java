package com.eatj.s43.igorribeirolima.simuladordehomebroker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Noticia;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.repository.NoticiaRepository;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn.Util;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.jornalfolha.NoticiasFolha;

@Service
public class NoticiaService {

	@Autowired
	private NoticiaRepository repository;
	
	@Autowired
	private AtivoService ativoService;
	
	public Noticia busca_por_id ( Long id ){
		return this.repository.busca_por_id(id);
	}
	
	public List<Noticia> busca( String codigoAtivo, Date dataInicio, Date dataFim ){
		if( codigoAtivo != null ){
			Ativo ativo = ativoService.buscaPeloCodigo( codigoAtivo );
			
			if( ativo != null )
				return this.repository.busca(ativo, dataInicio, dataFim);
			else
				return null;
		}else{
			
			return this.repository.busca(null, dataInicio, dataFim);
			
		}
		
	}
	
	public void salva(Noticia noticia){
		this.repository.salva(noticia);
	}
	
	public void salva( List<Noticia> noticias ) {
		this.repository.salva(noticias);
	}
	
	@Scheduled(cron="0 0 6 * * SUN-SAT")
	public void atualizacaoDiariaDasNoticasDaBovespa(){
		atualizacaoDasNoticasDaBovespa( 501L );
	}
	
	public synchronized void atualizacaoDasNoticasDaBovespa( Long indiceDaNoticia ) {
		if( indiceDaNoticia == null || indiceDaNoticia < 25 ) return;
		System.out.println( Util.converterDateToString( new Date() ) + ": iniciando atualização das notícias..." );
		
		for( int i=indiceDaNoticia.intValue(); i>0; i-=25){ //6876 ou 7626
			List<Noticia> noticias = NoticiasFolha.getNoticias( "bovespa", new Long(i) );
			verificar_se_existe_as_noticias_no_bd(noticias);
			if( noticias != null && !noticias.isEmpty() )
				repository.salva(noticias);
			System.out.println( "Notícias do indice " + i + " atualizada(s). " + noticias.size() + " salva(s)." );
		}
		
		System.out.println( Util.converterDateToString( new Date() ) + ": fim da atualização das notícias" );
		
	}
	
	private void verificar_se_existe_as_noticias_no_bd( List<Noticia> noticias ){
		if( noticias == null || noticias.isEmpty() ) return;
		
		Long dtMin = null;
		for( Noticia noticia : noticias ){
			if( dtMin == null ) dtMin = noticia.getData().getTime();
			else dtMin = Math.min( dtMin, noticia.getData().getTime() );
		}
		
		Long dtMax = null;
		for( Noticia noticia : noticias ){
			if( dtMax == null ) dtMax = noticia.getData().getTime();
			else dtMax = Math.max( dtMax, noticia.getData().getTime() );
		}
		
		List<Noticia> noticias_gravadas_no_bd = repository.busca(null, new Date(dtMin), new Date(dtMax) );
		if( noticias_gravadas_no_bd.isEmpty() ) return;
		
		for( Noticia noticia : noticias_gravadas_no_bd )
			noticias.remove( noticia );
	}
	
}
