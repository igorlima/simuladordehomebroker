package com.eatj.s43.igorribeirolima.simuladordehomebroker.util;

public class Imagem {
	private final int tamWidth = 135;
	private final int tamHeight = 140;
	
	//Endereco URL da imagem da cotacao intraday do ativo
	private final String urlImagemCotacaoIntradayAtivo = "http://custom.infomoney.com.br/netObjects/.stockchart?width="+tamWidth+"&height="+tamHeight+"&casasdec=2&Delay=15&config=InfoMoneyCotacoes&codigo=";
	
	//Endereco URL da imagem da cotacao diaria do ativo
	private final String urlImagemCotacaoDiariaAtivo = "http://custom.infomoney.com.br/netObjects/.stockchart?width="+tamWidth+"&height="+tamHeight+"&tipocot=1&casasdec=2&Delay=15&config=InfoMoneyCotacoes&codigo=";
	
	//Endereco URL da imagem da cotacao intraday do Indice BOVESPA
	private final String urlImagemCotacaoIntradayBovespa = "http://web.infomoney.com.br/cgi-bin/getimage.dll?imagem=bovespa_i.png";
	
	//Endereco URL da imagem da cotacao diaria do Indice BOVESPA
	private final String urlImagemCotacaoDiariaBovespa = "http://web.infomoney.com.br/cgi-bin/getimage.dll?imagem=bovespa_d.png"; 
	
	//Endereco URL da imagem da cotacao diaria do Dolar
	private final String urlImagemCotacaoDiariaDolar = "http://web.infomoney.com.br/cgi-bin/getimage.dll?imagem=dolar_d.png";
	
	//Endereco URL da imagem da cotacao intraday do Dolar
	private final String urlImagemCotacaoIntradayDolar = "http://web.infomoney.com.br/cgi-bin/getimage.dll?imagem=dolar_i.png";

	
	public Imagem(){
		
	}
	
	
	public int getTamWidth() {
		return tamWidth;
	}

	public int getTamHeight() {
		return tamHeight;
	}

	public String getUrlImagemCotacaoIntradayAtivo() {
		return urlImagemCotacaoIntradayAtivo;
	}

	public String getUrlImagemCotacaoDiariaAtivo() {
		return urlImagemCotacaoDiariaAtivo;
	}

	public String getUrlImagemCotacaoIntradayBovespa() {
		return urlImagemCotacaoIntradayBovespa;
	}

	public String getUrlImagemCotacaoDiariaBovespa() {
		return urlImagemCotacaoDiariaBovespa;
	}

	public String getUrlImagemCotacaoDiariaDolar() {
		return urlImagemCotacaoDiariaDolar;
	}

	public String getUrlImagemCotacaoIntradayDolar() {
		return urlImagemCotacaoIntradayDolar;
	}
	
}
