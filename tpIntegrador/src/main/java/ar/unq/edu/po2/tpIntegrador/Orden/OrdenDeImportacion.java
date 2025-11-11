package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;
import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.Visitable;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Clientes.Factura;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class OrdenDeImportacion extends Orden implements Visitable {
	
	private Cliente consignee;
	
	public OrdenDeImportacion(LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Container container, Buque buque, Turno turno, Cliente consignee) {
		super(fechaSalida, fechaLlegada, container, buque, turno);
		this.consignee = consignee;
	}

	@Override
	public void operarse(Buque buque) {
		buque.addContainer(this.getContainer());
	}

	@Override
	public String aceptarReporte(Reporte reporte) {
		return reporte.visitar(this);
		
	}

	@Override
	public Cliente getCliente() {
		return this.consignee;
	}

	@Override
	public void avisarCliente(Terminal terminal) {
		this.consignee.enviarImportacionA(terminal, this.getTurno());
	}

	@Override
	public void hacerFacturaPara(Cliente cliente, Terminal terminal) {
		cliente.guardarFactura(new Factura(this, this.precioDelViaje(terminal)));
	}

	private double precioDelViaje(Terminal terminal) {
		return getBuque().getViaje().getCircuito().precioDelViajeHasta(terminal);
	}
}
