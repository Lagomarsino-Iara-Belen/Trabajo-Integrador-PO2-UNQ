package ar.unq.edu.po2.tpIntegrador.Naviera;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Tramo {
	private Double precio;
	private int semanasARecorrer;
	private Terminal terminalInicio;
	private Terminal terminalFin;
	
	public Tramo(int semanas, Double precio, Terminal terminalInicio, Terminal terminalFin) {
		this.semanasARecorrer = semanas;
		this.precio = precio;
		this.terminalInicio = terminalInicio;
		this.terminalFin = terminalFin;
	}
	
	public int getSemanas() {
		return semanasARecorrer;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public Terminal getPuertoOrigen() {
		return terminalInicio;
	}
	
	public Terminal getPuertoDestino() {
		return terminalFin;
	}

}
