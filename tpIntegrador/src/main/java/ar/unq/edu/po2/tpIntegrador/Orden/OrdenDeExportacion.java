package ar.unq.edu.po2.tpIntegrador.Orden;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public class OrdenDeExportacion extends Orden {

	

	public OrdenDeExportacion(Viaje viaje, Container container, List<Servicio> servicios, Camion camion, Chofer chofer) {
		super(viaje, container, servicios, camion, chofer);
	}

	@Override
	public void operarse(Buque buque) {
		buque.removeContainer(this.container);
	}
}
