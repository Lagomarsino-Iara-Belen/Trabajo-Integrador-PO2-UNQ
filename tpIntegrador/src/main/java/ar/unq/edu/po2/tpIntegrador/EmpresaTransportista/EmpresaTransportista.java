package ar.unq.edu.po2.tpIntegrador.EmpresaTransportista;

import java.util.List;

public class EmpresaTransportista {
	private String nombre;
	private List<Chofer> choferes;
	private List<Camion> camiones;
	
	public EmpresaTransportista(String nombre, List<Chofer> choferes, List<Camion> camiones) {
		this.nombre = nombre;
		this.choferes = choferes;
		this.camiones = camiones;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public List<Chofer> getChoferes() {
		return choferes;
	}
	
	public List<Camion> getCamiones() {
		return camiones;
	}
	
	public void addChofer(Chofer chofer) {
		this.choferes.add(chofer);
	}
	
	public void removeChofer(Chofer chofer) {
		this.choferes.remove(chofer);
	}
	
	public void addCamion(Camion camion) {
		this.camiones.add(camion);
	}
	
	public void removeChofer(Camion camion) {
		this.camiones.remove(camion);
	}
	
	public boolean chequearCamionYChofer(Camion camion, Chofer chofer) {
		return this.camiones.contains(camion) && this.choferes.contains(chofer);
	}
}
