package ar.unq.edu.po2.tpIntegrador.Naviera;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;

public class Naviera {
	private List<Viaje> viajes;
	private List<Buque> buques;
	private List<Circuito> circuitos;

	public Naviera(List<Viaje> viajes, List<Buque> buques, List<Circuito> circuitos) {
		this.viajes= viajes;
		this.buques = buques;
		this.circuitos = circuitos;
	}

	public List<Viaje> getViajeARealizar() {
		return this.viajes;
	}

	public List<Buque> getBuques() {
		return this.buques;
	}

	public List<Circuito> getCurcuitos() {
		return this.circuitos;
	}
	
	public void addCircuito(Circuito c) {
		this.circuitos.add(c);
	}
	
	public void addBuque(Buque b) {
		this.buques.add(b);
	}
	
	public void asignarViaje(Buque b, Viaje v) {
		this.buques.stream().filter(buque -> buque.equals(b)).findFirst().ifPresent(buque -> buque.setViaje(v));
	}
	
	public void removeCircuito(Circuito c) {
		this.circuitos.remove(c);
	}
	
	public void removeBuque(Buque b) {
		this.buques.remove(b);
	}
}
