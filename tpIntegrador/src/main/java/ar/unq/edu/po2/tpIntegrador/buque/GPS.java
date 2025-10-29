package ar.unq.edu.po2.tpIntegrador.buque;

import java.util.ArrayList;
import java.util.List;

public class GPS {
	List<Observador> observadores;
	int ubicacion;
	
	public GPS() {
		ubicacion = 0;
		observadores = new ArrayList<>();
	}
	
	public void addObserver(Observador observador) {
		observadores.add(observador);
	}
	
	public void removeObserver(Observador observador) {
		observadores.remove(observador);
	}
	
	public int getUbicacion() {
		return ubicacion;
	}
	
	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public void avisarCambio() {
		observadores.stream().forEach(t -> t.actualizar(getUbicacion()));
	}
}
