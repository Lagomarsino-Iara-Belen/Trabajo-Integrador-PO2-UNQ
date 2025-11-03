package ar.unq.edu.po2.tpIntegrador.Orden;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public abstract class Orden {
	
	protected Viaje viaje;
	protected Container container;
	private List<Servicio> servicios;
	private Camion camion;
	private Chofer chofer;
	
	public Orden (Viaje viaje, Container container, List<Servicio> servicios, Camion camion, Chofer chofer) {
		this.viaje = viaje;
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.servicios = servicios;
	}
	
	public List<Servicio> getServicios(){
		return this.servicios;
	}
	
	public Viaje getViaje() {
		return this.viaje;
	}
	
	public abstract void operarse(Buque buque);

	public Camion getCamion() {
		return camion;
	}

	public Chofer getChofer() {
		return chofer;
	}
}
