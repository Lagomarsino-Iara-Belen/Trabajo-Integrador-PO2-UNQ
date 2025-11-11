package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.time.LocalDate;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Viaje {
	
	private LocalDate fechaDeInicio;
	private Terminal paradaActual;
	private Circuito circuito;
	
	public Viaje(LocalDate fechaDeInicio, Circuito circuito) {
		this.fechaDeInicio = fechaDeInicio;
		this.circuito = circuito;
		this.paradaActual = circuito.getPuertoInicio();
	}

	public Terminal getParadaActual() {
		return this.paradaActual;
	}
	
	public LocalDate getFechaDeInicio() {
		return this.fechaDeInicio;
	}
	
	public Circuito getCircuito() {
		return this.circuito;
	}
	
	public List<LocalDate> cronograma() {
	    return circuito.cronogramaSaliendo(this.fechaDeInicio);
	}

	public void proximaParada(Terminal terminal) {  
		if(circuito.haySiguienteParada(terminal)) {
			paradaActual = circuito.proximaParadaDe(terminal);
		}
	}

	/**
	 * Dada una terminal que se debe encontrar en mi lista de Circuito, me devuelve la fecha correspondiente al cronograma 
	 * @param paradaAver Terminal pasada por parametro
	 * @return La fecha correspondiente al cronograma de la terminal dada por parametro
	 */
	public LocalDate fechaDeParada(Terminal paradaAver) {
		Terminal paradaAIterar = this.getParadaActual();
		int nro = 0;
		while(paradaAver != paradaAIterar && circuito.haySiguienteParada(paradaAIterar)) {
			nro = nro + 1;
			paradaAIterar = circuito.proximaParadaDe(paradaAIterar);
		}
		return cronograma().get(nro);
	}

	public boolean pasaPor(Terminal parada) {
		Terminal paradaAIterar = this.getParadaActual();
		while(parada != paradaAIterar && circuito.haySiguienteParada(paradaAIterar)) {
			paradaAIterar = circuito.proximaParadaDe(paradaAIterar);
		}
		return parada == paradaAIterar;
	}
	
	public double precioDelViajeDe(Terminal terminal) {
		Terminal paradaAIterar = this.getParadaActual();
		double result = 0;
		while(terminal != paradaAIterar && circuito.haySiguienteParada(paradaAIterar)) {
			result += circuito.tramoActualDe(terminal).getPrecio();
			paradaAIterar = circuito.proximaParadaDe(paradaAIterar);
		}
		return result;
	}
	
	public int cantidadDeParadasDe(Terminal terminal) {
		Terminal paradaAIterar = this.getParadaActual();
		int result = 0;
		while(terminal != paradaAIterar && circuito.haySiguienteParada(paradaAIterar)) {
			result += 1;
			paradaAIterar = circuito.proximaParadaDe(paradaAIterar);
		}
		return result;
	}
}
