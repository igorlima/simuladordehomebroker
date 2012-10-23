package com.eatj.s43.igorribeirolima.simuladordehomebroker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table( name="usuario" )
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column( unique=true )
	private String login;
	private String senha;
	private String nome;
	private String email;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario( Long id ) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if( id == null ) return false;
		
		if( obj instanceof Usuario && id.equals( ((Usuario) obj).getId() ) )
			return true;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		if( id == null )
			return Usuario.class.getName().hashCode();
		else
			return Usuario.class.getName().hashCode() * ( id.hashCode() );
	}
}
