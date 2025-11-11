package ar.unq.edu.po2.tpIntegrador.Clientes;

import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public class Factura {
	Orden ordenDesgloce;
	double precioDelViaje;
	
	public Factura(Orden ordenDesgloce, double precioDelViaje) {
		this.ordenDesgloce = ordenDesgloce;
		this.precioDelViaje = precioDelViaje;
	}
	
	public double montoTotal() {
		return this.ordenDesgloce.getServicios().stream()
				.mapToDouble(servicio -> servicio.precioDelServicio(this.ordenDesgloce.getContainer()))
				.sum() + this.precioDelViaje;
	}

	public Orden getOrden() {
		return this.ordenDesgloce;
	}
}
