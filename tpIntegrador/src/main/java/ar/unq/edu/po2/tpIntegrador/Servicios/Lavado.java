package ar.unq.edu.po2.tpIntegrador.Servicios;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;

public class Lavado implements Servicio {

	private Double precio; 
	
	public Lavado(Double precio) {
		this.precio = precio; 
	}

	public Double getPrecio() {
		return precio;
	}

	@Override
	public Double precioDelServicio(Container container) {
		if(container.getMetroCubico() > 70) {
			return this.getPrecio() * 2;
		}
		return this.getPrecio();
	}
}
