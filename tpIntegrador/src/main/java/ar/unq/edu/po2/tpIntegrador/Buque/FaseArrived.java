package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class FaseArrived extends FaseDeBuque {

	public FaseArrived(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(Buque buque, int distancia, Viaje viaje) {

			notificarTerminal(viaje, buque);
	}

	private void notificarTerminal(Viaje viaje, Buque buque) {
		viaje.getParadaActual().cambiarElEstadoDe(new FaseWorking(buque), buque);
	}
	
}

