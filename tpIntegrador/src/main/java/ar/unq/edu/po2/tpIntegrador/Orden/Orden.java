package ar.unq.edu.po2.tpIntegrador.Orden;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public abstract class Orden {
	
	protected Viaje viaje;
	protected Container container;
	
	public Orden (Viaje viaje, Container container) {
		this.viaje = viaje;
		this.container = container;
	}
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public abstract void operarse(Buque buque);
}
