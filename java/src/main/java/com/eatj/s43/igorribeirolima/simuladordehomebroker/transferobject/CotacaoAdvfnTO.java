package com.eatj.s43.igorribeirolima.simuladordehomebroker.transferobject;

import java.io.Serializable;

public class CotacaoAdvfnTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Float ULT;
	private Float VAR;
	private Float VAB;
	private String hora;
	private Long VOL;
	private Float FEC;
	private Float ABE;
	private Float OFC;
	private Float OFV;
	private Float Max;
	private Float Min;
	private Float NEG;
	private Float NEG_MAX;
	private Float NEG_MIN;
	
	public CotacaoAdvfnTO() {
	}

	public Float getULT() {
		return ULT;
	}

	public void setULT(Float uLT) {
		ULT = uLT;
	}

	public Float getVAR() {
		return VAR;
	}

	public void setVAR(Float vAR) {
		VAR = vAR;
	}

	public Float getVAB() {
		return VAB;
	}

	public void setVAB(Float vAB) {
		VAB = vAB;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Long getVOL() {
		return VOL;
	}

	public void setVOL(Long vOL) {
		VOL = vOL;
	}

	public Float getFEC() {
		return FEC;
	}

	public void setFEC(Float fEC) {
		FEC = fEC;
	}

	public Float getABE() {
		return ABE;
	}

	public void setABE(Float aBE) {
		ABE = aBE;
	}

	public Float getOFC() {
		return OFC;
	}

	public void setOFC(Float oFC) {
		OFC = oFC;
	}

	public Float getOFV() {
		return OFV;
	}

	public void setOFV(Float oFV) {
		OFV = oFV;
	}

	public Float getMax() {
		return Max;
	}

	public void setMax(Float max) {
		Max = max;
	}

	public Float getMin() {
		return Min;
	}

	public void setMin(Float min) {
		Min = min;
	}

	public Float getNEG() {
		return NEG;
	}

	public void setNEG(Float nEG) {
		NEG = nEG;
	}

	public Float getNEG_MAX() {
		return NEG_MAX;
	}

	public void setNEG_MAX(Float nEG_MAX) {
		NEG_MAX = nEG_MAX;
	}

	public Float getNEG_MIN() {
		return NEG_MIN;
	}

	public void setNEG_MIN(Float nEG_MIN) {
		NEG_MIN = nEG_MIN;
	}
	
	
}
