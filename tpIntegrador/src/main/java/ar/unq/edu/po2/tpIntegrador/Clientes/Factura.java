package ar.unq.edu.po2.tpIntegrador.Clientes;

import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public class Factura {
	Orden ordenDesgloce;
	
	public Factura(Orden ordenDesgloce) {
		this.ordenDesgloce = ordenDesgloce;
	}
	
	public double montoTotal() {
		return ordenDesgloce.getServicios().stream()
				.mapToDouble(servicio -> servicio.precioDelServicio(ordenDesgloce.getContainer()))
				.sum();
	}
}
