package ar.unq.edu.po2.tpIntegrador.Orden;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public abstract class Orden {
	
	protected Container container;
	private List<Servicio> servicios;
	private Camion camion;
	private Chofer chofer;
	private Buque buque;
	
	public Orden (Container container, List<Servicio> servicios, Camion camion, Chofer chofer, Buque buque) {
		this.container = container;
		this.camion = camion;
		this.chofer = chofer;
		this.servicios = servicios;
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

	public Object getBuque() {
		return buque;
	}
}
