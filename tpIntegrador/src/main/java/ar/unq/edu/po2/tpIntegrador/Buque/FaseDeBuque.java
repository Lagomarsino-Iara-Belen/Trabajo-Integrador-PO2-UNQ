package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public abstract class FaseDeBuque {
	
	protected Buque buque;
	
	public FaseDeBuque(Buque buque) {
		this.buque = buque;
	}

	public abstract void actualizar(int distancia, Viaje viaje);
	public void operar(List<Orden> ordenes) {}
	
	public Buque getBuque() {
		return this.buque;
	}
}
