package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.util.ArrayList;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Circuito {
	private ArrayList<Tramo> tramos;
	
	public Circuito(ArrayList<Tramo> listaTramos) {
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

	public ArrayList<Tramo> getTodosLosTramos() {
		return tramos;
	}
}
