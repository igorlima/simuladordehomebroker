package com.eatj.s43.igorribeirolima.simuladordehomebroker.util.advfn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.eatj.s43.igorribeirolima.simuladordehomebroker.enums.Regex;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Ativo;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.model.Intraday;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.transferobject.CotacaoAdvfnTO;
import com.eatj.s43.igorribeirolima.simuladordehomebroker.util.Controle_de_Thread;

public class Util {

	public static void imprimirMap(Map<String, String> map) {
		System.out.println();
		for (String key : map.keySet()) {
			System.out.print(key + ": ");
			System.out.print(map.get(key));
			System.out.println();
		}
		System.out.println();
	}

	public static void imprimirMap2(Map<String, List<String>> map) {
		System.out.println();
		for (String key : map.keySet()) {
			System.out.print(key + ": ");
			System.out.print(map.get(key));
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		
		List<String> list = new ArrayList<String>();
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS3" );
		list.add( "ITUB4" );
		list.add( "PRBC4" );
		list = new ArrayList<String>();
		list.add( "SANB4" );
		list.add( "BPNM4" );
		list.add( "IENG3" );
		list.add( "BEES4" );
		list.add( "BBAS4" );
		
		DadosADVFN.atualizar_cotacoes_em_DadosADVFN( list );
		System.out.println( "The End. " + DadosADVFN.cotacoes.size() );
		System.out.println( "The End. " + DadosADVFN.loginMobile.countObservers() );
//		
//		DadosADVFN.getCotacao_do_ADVFN( list );
//		System.out.println( "The End. " + DadosADVFN.cotacoes.size() );
//		System.out.println( "The End. " + DadosADVFN.loginMobile.countObservers() );
//		
//		DadosADVFN.getCotacao_do_ADVFN( list );
//		System.out.println( "The End. " + DadosADVFN.cotacoes.size() );
//		System.out.println( "The End. " + DadosADVFN.loginMobile.countObservers() );
		
		
		
		
		//imprimirMap( DadosADVFN.cotacoes );

		// String str = RequisicaoHTTP.getDados_historico_do_ADVFN( "WHRL4",
		// true );
		// converterStringToDadosHistoricos(str);

		// EntityManager em =
		// Persistence.createEntityManagerFactory("simuladordehomebrokerPU").createEntityManager();
		// Query query = em.createQuery( "SELECT ativo from " +
		// Ativo.class.getName() +" ativo" );
		// query.getResultList();

		// Query query = em.createQuery( "from " + Ativo.class.getName()
		// +" a where a.codigo like :codigo" );
		// query.setParameter("codigo", "%WHRL4%" );
		// query.setMaxResults(1);
		// Ativo ativo = (Ativo) query.getSingleResult();
		// List<Intraday> list = Util.getDadosIntraday( ativo );
		//
		// em.getTransaction().begin();
		// for( Intraday intraday : list )
		// em.persist( intraday );
		// em.getTransaction().commit();
		// em.close();
		//
		// System.out.println( 0f );

	}

	public static boolean isDate(String strDate) {

		if (Pattern.matches(Regex.DATE.get(), strDate))
			return true;
		else
			return false;

	}

	public static Date converterStringToDate(String strDate) {

		if (isDate(strDate)) {
			DateFormat formatter;

			if (Pattern.matches(Regex.DATE_HORA.get(), strDate))
				formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			else
				formatter = new SimpleDateFormat("dd/MM/yyyy");

			try {
				return (Date) formatter.parse(strDate);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}

		return null;
	}

	public static Intraday converterStringToDadoHistorico(
			String strDadoHistorico, Ativo ativo) {
		Intraday cotacao = converterStringToDadoHistorico(strDadoHistorico);
		if (cotacao != null)
			cotacao.setAtivo(ativo);
		return cotacao;
	}

	public static Intraday converterStringToDadoHistorico(
			String strDadoHistorico) {
		Intraday cotacaoIntraday = null;

		if (Pattern.matches(Regex.DADO_HISTORICO.get(), strDadoHistorico)) {
			cotacaoIntraday = new Intraday();

			String[] dados = strDadoHistorico.split(",");

			cotacaoIntraday.setData_hora(converterStringToDate(dados[0]));
			cotacaoIntraday.setAbertura(parseFloat(dados[1]));
			cotacaoIntraday.setMaximo(parseFloat(dados[2]));
			cotacaoIntraday.setMinimo(parseFloat(dados[3]));
			cotacaoIntraday.setFechamento(parseFloat(dados[4]));
			cotacaoIntraday.setVolume(parseLong(dados[5]));

		}

		return cotacaoIntraday;
	}

	public static List<Intraday> converterStringToDadosHistoricos(
			String strDadosHistoricos, Ativo ativo) {
		List<Intraday> cotacoes = null;

		String[] dados = strDadosHistoricos.split("\n");

		for (String dadoHistorico : dados) {
			Intraday cotacao = converterStringToDadoHistorico(dadoHistorico,
					ativo);
			if (cotacao != null) {
				if (cotacoes == null)
					cotacoes = new ArrayList<Intraday>();
				cotacoes.add(cotacao);
			}
		}

		return cotacoes;
	}

	public static List<Intraday> converterStringToDadosHistoricos(
			String strDadosHistoricos) {
		List<Intraday> cotacoes = null;

		String[] dados = strDadosHistoricos.split("\n");

		for (String dadoHistorico : dados) {
			Intraday cotacao = converterStringToDadoHistorico(dadoHistorico);
			if (cotacao != null) {
				if (cotacoes == null)
					cotacoes = new ArrayList<Intraday>();
				cotacoes.add(cotacao);
			}
		}

		return cotacoes;
	}

	public static Float parseFloat(String strNumber) {
		try {
			Float f = Float.parseFloat(strNumber);
			if (f.equals(0f))
				return null;
			else
				return f;
		} catch (Exception e) {
			return null;
		}
	}

	public static Long parseLong(String strNumber) {
		try {
			Long l = Long.parseLong(strNumber);
			if (l.equals(0L))
				return null;
			else
				return l;
		} catch (Exception e) {
			return null;
		}
	}

	public static String toString(List<Ativo> ativos) {
		String retorno = "";
		for (Ativo ativo : ativos)
			retorno += ativo.getCodigo() + " ";

		return retorno;
	}

	public static void remove(List<Intraday> colecao, List<Intraday> list) {
		if (colecao == null || colecao.isEmpty() || list == null
				|| list.isEmpty())
			return;

		for (Intraday intraday : list)
			colecao.remove(intraday);

	}

	public static boolean contains(List<Intraday> list, Intraday intraday) {
		if (list == null)
			return false;
		for (Intraday aux : list) {
			if (aux.equals(intraday))
				return true;
		}
		return false;
	}

	public static Long getDateMinimo(List<Intraday> colecao) {
		Long min = null;

		for (Intraday intraday : colecao) {
			if (min == null)
				min = intraday.getData_hora().getTime();

			min = Math.min(min, intraday.getData_hora().getTime());
		}

		return min;
	}

	public static Long getDateMaximo(List<Intraday> colecao) {
		Long max = null;

		for (Intraday intraday : colecao) {
			if (max == null)
				max = intraday.getData_hora().getTime();

			max = Math.max(max, intraday.getData_hora().getTime());
		}

		return max;
	}

	public static List<Ativo> getAtivos(List<Intraday> colecao) {
		List<Ativo> ativos = new ArrayList<Ativo>();

		for (Intraday intraday : colecao)
			if (!ativos.contains(intraday.getAtivo()))
				ativos.add(intraday.getAtivo());

		return ativos;
	}

	public static String getHoraAtual() {
		return converterDateToString(new Date());
	}

	public static String converterDateToString(Date dt) {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dt);
	}
	

	public static CotacaoAdvfnTO converterStringToCotacaoADVFN( String strCotacaoADVFN ) {
		CotacaoAdvfnTO cotacaoADVFN = null;
		
		String str1 = "<tr align='right'";
		String str2 = "'>";
		String str3 = "</";

		try{
			cotacaoADVFN = new CotacaoAdvfnTO();

			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str1 ) + str1.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setULT( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setVAR( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setVAB( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str1 ) + str1.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setHora( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			try{
				cotacaoADVFN.setVOL( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )).replace( ".", "") ).longValue() );
			}catch( NullPointerException nullPointerException ){
				cotacaoADVFN.setVOL( null );
			}
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str1 ) + str1.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setFEC( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setABE( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str1 ) + str1.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setOFC( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setOFV( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setMax( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setMin( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str1 ) + str1.length() );
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setNEG( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )).replace( ",","") ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setNEG_MAX( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
			strCotacaoADVFN = strCotacaoADVFN.substring( strCotacaoADVFN.indexOf( str2 ) + str2.length() );
			cotacaoADVFN.setNEG_MIN( parseFloat( strCotacaoADVFN.substring( 0, strCotacaoADVFN.indexOf( str3 )) ) );
			
		}catch( Exception e ){
			return null;
		}

		return cotacaoADVFN;
	}
	
	public static void sleep(){
		try {
			Thread.sleep( Controle_de_Thread.tempo_de_sono_da_thread );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
