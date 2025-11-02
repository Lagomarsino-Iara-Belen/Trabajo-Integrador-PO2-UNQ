package ar.unq.edu.po2.tpIntegrador.Orden;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class OrdenDeExportacion extends Orden {

	public OrdenDeExportacion(Viaje viaje, Container container) {
		super(viaje, container);
	}

	@Override
	public void operarse(Buque buque) {
		buque.removeContainer(this.container);
	}
}
