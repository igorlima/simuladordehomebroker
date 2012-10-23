package com.eatj.s43.igorribeirolima.simuladordehomebroker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table( name="noticia" )
public class Noticia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_do_ativo", referencedColumnName = "id")
	private Ativo ativo;
	
	private Date data;
	private String manchete;
	private String conteudo;
	private String link;
	
	public Noticia() {
		// TODO Auto-generated constructor stub
	}
	
	public Noticia( Long id ) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getManchete() {
		return manchete;
	}

	public void setManchete(String manchete) {
		this.manchete = manchete;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public boolean equals(Object obj) {
		if( data == null || manchete == null ) return false;
		
		if( obj instanceof Noticia && data.getTime() == ((Noticia)obj).getData().getTime() && manchete.equals( ((Noticia)obj).getManchete() ) ){
			if( ativo == null && ((Noticia)obj).getAtivo() == null )
				return true;
			
			if( ativo != null && ativo.equals( ((Noticia)obj).getAtivo() ) )
				return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if( id == null )
			return Noticia.class.getName().hashCode();
		else
			return Noticia.class.getName().hashCode() * ( id.hashCode() );
	}
}
