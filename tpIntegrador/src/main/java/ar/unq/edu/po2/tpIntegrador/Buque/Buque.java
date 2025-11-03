package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public class Buque implements Observador {
	String nombre;
	List <Container> containers;
	FaseDeBuque estado;
	Viaje viajeARealizar;
	
	public Buque(String nombre) {
		this.nombre = nombre;
		this.estado = new FaseOutbound(this);
		containers = new ArrayList<Container>();
	}
	
	protected void setEstado(FaseDeBuque estado) {
		this.estado = estado;
	}
	
	public void addContainer(Container container) {
		containers.add(container);
	}
	
	public void removeContainer(Container container) {
		containers.remove(container);
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}
	
	public void setViaje(Viaje viajeARealizar) {
		this.viajeARealizar = viajeARealizar;
	}
	
	public Viaje getViaje() {
		return viajeARealizar;
	}
	
	@Override
	public void actualizar(int distancia) {
		estado.actualizar(distancia, this.getViaje());
	}

	public void cambiarEstado(FaseDeBuque fase) {
		this.setEstado(fase);
	}
	
	public void operar(List<Orden> ordenes) {
		this.estado.operar(ordenes);
	}
}
