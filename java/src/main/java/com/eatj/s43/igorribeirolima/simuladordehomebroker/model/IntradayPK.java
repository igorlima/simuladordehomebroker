package com.eatj.s43.igorribeirolima.simuladordehomebroker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class IntradayPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Date data_hora;
	private Ativo ativo;

	public IntradayPK(){
	}
	
	public IntradayPK( Ativo ativo, Date data_hora){
		this.ativo = ativo;
		this.data_hora = data_hora;
	}
	
	public IntradayPK( Integer idAtivo, Date data_hora){
		this.ativo = new Ativo( idAtivo );
		this.data_hora = data_hora;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}
	
	@Override
	public boolean equals(Object o) {
		if( ativo == null || data_hora == null ) return false;
		
        if ((o instanceof IntradayPK) && 
                ativo.equals( ((IntradayPK)o).getAtivo() ) &&
                data_hora.getTime() == ((IntradayPK) o).getData_hora().getTime() )
        	return true;
        
        return false;
    }

    @Override
    public int hashCode() {
    	if( ativo == null || data_hora == null )
    		return IntradayPK.class.getName().hashCode();
    	else
    		return IntradayPK.class.getName().hashCode() * ( ativo.hashCode() + data_hora.hashCode() );
    }
}
