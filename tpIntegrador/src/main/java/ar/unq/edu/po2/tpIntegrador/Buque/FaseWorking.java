package ar.unq.edu.po2.tpIntegrador.Buque;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

public class FaseWorking implements FaseDeBuque {
	
	Buque miBuque;
	
	public FaseWorking() {
		// CAMBIAR! y cambiar en todas las otras fases!
	}
	
	@Override
	public void actualizar(Buque buque, int distancia, Viaje viaje) {
		notificarTerminal(viaje, buque);
	}

	private void notificarTerminal(Viaje viaje, Buque buque) {
		viaje.getParadaActual().cambiarElEstadoDe((new FaseDeparting()), buque);
	}

	@Override
	public void operar(List<Orden> ordenes) {
		ordenes.stream().forEach(orden -> orden.operarse(miBuque));
	}
}
