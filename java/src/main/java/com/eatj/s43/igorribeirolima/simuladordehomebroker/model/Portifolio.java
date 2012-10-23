package com.eatj.s43.igorribeirolima.simuladordehomebroker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "portifolio")
@IdClass( PortifolioPK.class )
public class Portifolio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_do_ativo", referencedColumnName = "id")
	private Ativo ativo;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_do_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	public Portifolio() {
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if( ativo == null || usuario == null )
			return false;
		
		if( obj instanceof Portifolio && ativo.equals( ((Portifolio)obj).getAtivo() ) && usuario.equals( ((Portifolio)obj).getUsuario() ) )
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if( ativo == null || usuario == null )
			return Portifolio.class.getName().hashCode();
		else
			return Portifolio.class.getName().hashCode() * ( ativo.hashCode() + usuario.hashCode() );
	}
}
