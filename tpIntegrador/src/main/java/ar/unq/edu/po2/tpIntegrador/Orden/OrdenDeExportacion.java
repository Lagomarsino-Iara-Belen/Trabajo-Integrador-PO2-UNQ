package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;
import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;

public class OrdenDeExportacion extends Orden {
	private Cliente shipper;
	
	public OrdenDeExportacion(LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Container container, Chofer chofer,
			Camion camion, Buque buque, Cliente shipper) {
		super(fechaSalida, fechaLlegada, container, chofer, camion, buque);
		this.shipper = shipper;
	}
	
	@Override
	public void operarse(Buque buque) {
		buque.removeContainer(this.getContainer());
	}

	@Override
	public Cliente getCliente() {
		return shipper;
	}
}
