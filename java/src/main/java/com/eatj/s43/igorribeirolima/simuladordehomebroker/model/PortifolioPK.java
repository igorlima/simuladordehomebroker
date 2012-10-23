package com.eatj.s43.igorribeirolima.simuladordehomebroker.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PortifolioPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private Ativo ativo;

	public PortifolioPK(){
	}
	
	public PortifolioPK( Ativo ativo, Usuario usuario){
		this.ativo = ativo;
		this.usuario = usuario;
	}
	
	public PortifolioPK( Integer idAtivo, Usuario usuario){
		this.ativo = new Ativo( idAtivo );
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	@Override
	public boolean equals(Object obj) {
		if( ativo == null || usuario == null ) return false;
		
		if( obj instanceof PortifolioPK && ativo.equals( ((PortifolioPK) obj).getAtivo() ) && usuario.equals( ((PortifolioPK) obj).getUsuario() ) )
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if( ativo == null || usuario == null )
			return PortifolioPK.class.getName().hashCode();
		else
			return PortifolioPK.class.getName().hashCode() * ( ativo.hashCode() + usuario.hashCode() );
	}
}
