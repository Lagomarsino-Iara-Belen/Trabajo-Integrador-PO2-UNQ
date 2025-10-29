package ar.unq.edu.po2.tpIntegrador.Servicios;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;

public class Pesado implements Servicio {
	
	private Double precio; 
	
	public Pesado(Double precio) {
		this.precio = precio; 
	}

	public Double getPrecio() {
		return precio;
	}

	@Override
	public Double precioDelServicio(Container container) {
		return this.getPrecio();
	}
	
	

}
