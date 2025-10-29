package ar.unq.edu.po2.tpIntegrador.buque;

import ar.unq.edu.po2.tpIntegrador.Viaje.Viaje;

public class FaseWorking implements FaseDeBuque {

	@Override
	public void actualizar(Buque buque, int distancia, Viaje viaje) {
		notificarTerminal(viaje, buque);
	}

	private void notificarTerminal(Viaje viaje, Buque buque) {
		viaje.paradaActual().cambiarElEstadoDe((new FaseDeparting()), buque);
	}


}
