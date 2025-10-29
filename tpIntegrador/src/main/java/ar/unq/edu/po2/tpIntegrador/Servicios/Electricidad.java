package ar.unq.edu.po2.tpIntegrador.Servicios;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;

public class Electricidad implements Servicio {
	
	private Double precio;
	private int horasDeConsumo;
	
	public Electricidad(Double precio) {
		this.precio = precio; 
	}

	public Double getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}
	
	public int getHorasDeConsumo(){
		return horasDeConsumo;
	}

	@Override
	public Double precioDelServicio(Container container) {
		return this.getPrecio() * this.getHorasDeConsumo();
	}
}
