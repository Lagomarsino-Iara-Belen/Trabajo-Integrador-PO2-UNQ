package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;

public class Buque implements Observador, Visitable {
	String nombre;
	List <Container> containers;
	List <Container> containersOperados;
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
		containersOperados.add(container);
	}
	
	public void removeContainer(Container container) {
		containers.remove(container);
		containersOperados.remove(container);
	}
	
	public List<Container> getContainers() {
		return this.containers;
	}
	
	public List<Container> getContainersOperados() {
		return this.containersOperados;
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
	public void aceptarReporte(Reporte reporte) {
		reporte.visitar(this);
	}

	public String getNombre() {
		return nombre;
	}
}
