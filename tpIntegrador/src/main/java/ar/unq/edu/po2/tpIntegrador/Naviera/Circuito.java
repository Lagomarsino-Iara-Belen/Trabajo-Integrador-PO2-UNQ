package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Circuito {
	private List<Tramo> tramos;
	
	public Circuito(List<Tramo> listaTramos) {
		this.tramos = listaTramos;
	}
	
	/**
	 * Me devuelve el primer puerto del circuito
	 * @return Terminal
	 */
	public Terminal getPuertoInicio() {
		return this.tramos.getFirst().getPuertoOrigen();	
		}
	
	/**
	 * Me devuelve el ultimo puerto del circuito
	 * @return Terminal
	 */
	public Terminal getPuertoFinal() {
		return this.tramos.getLast().getPuertoDestino();
	}
	
	public boolean haySiguienteParada(Terminal terminal) {
		return this.tramos.stream().anyMatch(tramo -> tramo.getPuertoOrigen().equals(terminal));
	}

	public Terminal proximaParadaDe(Terminal terminal) {
		return this.tramos.stream().filter(tramo -> tramo.getPuertoOrigen().equals(terminal))
				.map(Tramo :: getPuertoDestino).findFirst().orElse(null);
	}
	
	public Tramo tramoActualDe(Terminal terminal) {
		return this.tramos.stream().filter(tramo -> tramo.getPuertoOrigen().equals(terminal)).findFirst().orElse(null);
	}

	public List<Tramo> getTodosLosTramos() {
		return tramos;
	}

	public double precioHasta(Terminal terminal) {
		Terminal paradaAIterar = getPuertoInicio();
		double result = 0;
		while(terminal != paradaAIterar && haySiguienteParada(paradaAIterar)) {
			result += tramoActualDe(paradaAIterar).getPrecio();
			paradaAIterar = proximaParadaDe(paradaAIterar);
		}
		return result;
	}
	
	public List<LocalDate> cronogramaSaliendo(LocalDate fecha) {
	    List<Tramo> tramos = getTodosLosTramos();

	    ArrayList<LocalDate> cronograma = tramos.parallelStream().collect(
	            () -> new ArrayList<>(List.of(fecha)),
	            (lista, tramo) -> {
	                LocalDate ultima = lista.get(lista.size() - 1);
	                lista.add(ultima.plusWeeks(tramo.getSemanas()));
	            },
	            (a, b) -> a.addAll(b)
	        );

	    return cronograma;
	}
}
