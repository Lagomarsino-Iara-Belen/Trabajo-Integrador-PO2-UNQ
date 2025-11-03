package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public abstract class FaseDeBuque {
	
	private Buque miBuque;
	
	public FaseDeBuque(Buque buque) {
		this.miBuque = buque;
	}

	public abstract void actualizar(Buque buque, int distancia, Viaje viaje);
	public void operar(List<Orden> ordenes) {}
	
	public Buque getBuque() {
		return this.miBuque;
	}
}
