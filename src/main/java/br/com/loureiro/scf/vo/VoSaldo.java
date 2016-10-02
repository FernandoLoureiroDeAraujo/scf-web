package br.com.loureiro.scf.vo;

import java.time.LocalDate;

public class VoSaldo {
	
	private LocalDate data1;
	private LocalDate data2;
	private Integer mesReferencia;
	
	public VoSaldo() {}
	
	public VoSaldo(LocalDate data1, LocalDate data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
	}

	public LocalDate getData1() {
		return data1;
	}
	public LocalDate getData2() {
		return data2;
	}
	public void setData1(LocalDate data1) {
		this.data1 = data1;
	}
	public void setData2(LocalDate data2) {
		this.data2 = data2;
	}
	public Integer getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(Integer mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	
	
}