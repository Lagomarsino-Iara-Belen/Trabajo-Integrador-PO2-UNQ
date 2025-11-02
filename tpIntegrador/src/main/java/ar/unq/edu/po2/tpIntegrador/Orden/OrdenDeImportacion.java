package ar.unq.edu.po2.tpIntegrador.Orden;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class OrdenDeImportacion extends Orden {
	
	public OrdenDeImportacion(Viaje viaje, Container container) {
		super(viaje, container);
	}

	@Override
	public void operarse(Buque buque) {
		buque.addContainer(this.container);
	}
}
