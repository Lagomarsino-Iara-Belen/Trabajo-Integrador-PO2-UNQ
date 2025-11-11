package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public abstract class Orden {
	
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private Container container;
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private Buque buque;
	private Turno turno;
	
	public Orden (LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Container container, Buque buque, Turno turno) {
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.container = container;
		this.buque = buque;
		this.turno = turno;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	public abstract void operarse(Buque buque);

	public Buque getBuque() {
		return buque;
	}
	
	public Container getContainer() {
		return container;
	}
	
	public Turno getTurno() {
		return this.turno;
	}
	
	public LocalDateTime getFechaSalida() {
		return this.fechaSalida;
	}
	
	public LocalDateTime getFechaLlegada() {
		return this.fechaLlegada;
	}
	
	public void asignarServicio(Servicio servicio) {
		this.servicios.add(servicio);
	}
	
	public void sacarServicio(Servicio servicio) {
		this.servicios.remove(servicio);
	}

	public abstract String aceptarReporte(Reporte reporte);

	public abstract Cliente getCliente();

	public abstract void avisarCliente(Terminal terminal);

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public abstract void hacerFacturaPara(Cliente cliente, Terminal terminal);
}
