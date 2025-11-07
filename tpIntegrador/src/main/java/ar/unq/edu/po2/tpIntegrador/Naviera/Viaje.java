package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	public ArrayList<LocalDate> cronograma() {
	    ArrayList<Tramo> tramos = circuito.getTodosLosTramos();

	    ArrayList<LocalDate> cronograma = tramos.stream().collect(
	            () -> new ArrayList<>(List.of(fechaDeInicio)),
	            (lista, tramo) -> {
	                LocalDate ultima = lista.get(lista.size() - 1);
	                lista.add(ultima.plusWeeks(tramo.getSemanas()));
	            },
	            (a, b) -> a.addAll(b)
	        );

	    return cronograma;
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
		Terminal paradaAIterar = circuito.getPuertoInicio();
		int nro = 0;
		while(paradaAver != paradaAIterar && circuito.haySiguienteParada(paradaAIterar)) {
			nro = nro + 1;
			paradaAIterar = circuito.proximaParadaDe(paradaAIterar);
		}
		return cronograma().get(nro);
	}


}
