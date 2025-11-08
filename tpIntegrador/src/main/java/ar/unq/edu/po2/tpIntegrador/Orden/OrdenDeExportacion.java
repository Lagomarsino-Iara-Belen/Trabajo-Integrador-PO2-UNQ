package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;
import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.Visitable;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class OrdenDeExportacion extends Orden implements Visitable {
	private Cliente shipper;
	
	public OrdenDeExportacion(LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Container container, Buque buque, Turno turno, Cliente shipper) {
		super(fechaSalida, fechaLlegada, container, buque, turno);
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

	@Override
	public String aceptarReporte(Reporte reporte) {
		return reporte.visitar(this);
		
	}

	@Override
	public void avisarCliente(Terminal terminal) {
		this.shipper.enviarExportacionA(terminal, this.getTurno());
	}
}
