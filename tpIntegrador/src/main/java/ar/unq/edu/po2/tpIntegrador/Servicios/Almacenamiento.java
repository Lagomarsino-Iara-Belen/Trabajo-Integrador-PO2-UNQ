package ar.unq.edu.po2.tpIntegrador.Servicios;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;

public class Almacenamiento implements Servicio{

	private Double precio;
	private int diasExcedidos;
	
	public Almacenamiento(Double precio, int diasExcedidos) {
		this.precio = precio; 
		this.diasExcedidos = diasExcedidos;
	}

	public Double getPrecio() {
		return precio;
	}
	
	public int getDiasExcedidos() {
		return diasExcedidos;
	}

	@Override
	public Double precioDelServicio(Container container) {
		return this.getPrecio() * this.getDiasExcedidos();
	}
	
}
