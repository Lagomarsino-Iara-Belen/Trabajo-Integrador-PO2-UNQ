package ar.unq.edu.po2.tpIntegrador.Servicios;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;

public class Electricidad implements Servicio {
	
	private Double precio;
	private int horasDeConsumo;
	
	public Electricidad(Double precio, int horasDeConsumo) {
		this.precio = precio;
		this.horasDeConsumo = horasDeConsumo;
	}

	public Double getPrecio() {
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
