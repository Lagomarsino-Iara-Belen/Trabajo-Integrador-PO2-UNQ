package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public abstract class Orden {
	
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private Container container;
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private Camion camion;
	private Chofer chofer;
	private Buque buque;
	
	public Orden (LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Container container, Chofer chofer, Camion camion, Buque buque) {
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.buque = buque;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	public abstract void operarse(Buque buque);
	
	public abstract Cliente getCliente();

	public Camion getCamion() {
		return camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public Buque getBuque() {
		return buque;
	}
	
	public Container getContainer() {
		return container;
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
		this.servicios.add(servicio);
	}

	public abstract void aceptarReporte(Reporte reporte);
}
