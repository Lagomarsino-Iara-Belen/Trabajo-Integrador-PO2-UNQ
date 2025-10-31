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
		//Preguntar porque la necesito T.T . Se que es para pasar a la otra terminal, pero la terminal pasada por parametro tiene que ser la terminal actual
		if(circuito.haySiguienteParada(terminal)) {
			paradaActual = circuito.proximaParadaDe(terminal);
		}
	}


}
