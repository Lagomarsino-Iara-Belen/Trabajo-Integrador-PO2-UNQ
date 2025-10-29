package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.ArrayList;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class Buque implements Observador {
	String nombre;
	ArrayList <Container> containers;
	FaseDeBuque estado;
	Viaje viajeARealizar;
	
	public Buque(String nombre) {
		this.nombre = nombre;
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
	
	public void setViaje(Viaje viajeARealizar) {
		this.viajeARealizar = viajeARealizar;
	}
	
	public Viaje getViaje() {
		return viajeARealizar;
	}
	
	@Override
	public void actualizar(int distancia) {
		estado.actualizar(this, distancia, this.getViaje());
	}
}
