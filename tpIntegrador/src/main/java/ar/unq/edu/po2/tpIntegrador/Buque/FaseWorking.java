package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public class FaseWorking extends FaseDeBuque {
		
	public FaseWorking(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(int distancia, Viaje viaje) {
		notificarTerminal(viaje, buque);
	}

	private void notificarTerminal(Viaje viaje, Buque buque) {
		viaje.getParadaActual().cambiarElEstadoDe((new FaseDeparting(buque)), buque);
	}

	@Override
	public void operar(List<Orden> ordenes) {
		ordenes.stream().forEach(orden -> orden.operarse(this.getBuque()));
		
	}
}
