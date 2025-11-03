package ar.unq.edu.po2.tpIntegrador.Orden;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public class OrdenDeImportacion extends Orden {
	
	private Cliente consignee;
	
	public OrdenDeImportacion(Container container, List<Servicio> servicios, Camion camion, Chofer chofer, Buque buque, Cliente consignee) {
		super(container, servicios, camion, chofer, buque);
		this.consignee = consignee;
	}

	@Override
	public void operarse(Buque buque) {
		buque.addContainer(this.container);
	}

	@Override
	public Cliente getCliente() {
		return this.consignee;
	}
}
