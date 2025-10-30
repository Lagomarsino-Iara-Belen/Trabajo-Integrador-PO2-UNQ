package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.time.LocalDate;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Viaje {
	
	private LocalDate fechaDeInicio;
	private Terminal paradaActual;
	
	public Viaje(LocalDate fechaDeInicio, Terminal paradaActual) {
		this.fechaDeInicio = fechaDeInicio;
		this.paradaActual = paradaActual;
	}

	public Terminal getParadaActual() {
		// TODO Auto-generated method stub
		return this.paradaActual;
	}
	
	public LocalDate getFechaDeInicio() {
		return this.fechaDeInicio;
	}
	//TODO: Completar viajes
}
