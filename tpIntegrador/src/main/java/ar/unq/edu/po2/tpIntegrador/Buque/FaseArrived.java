package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class FaseArrived extends FaseDeBuque {

	public FaseArrived(Buque buque) {
		super(buque);
	}
	
	private void notificarTerminal(Viaje viaje, Buque buque) {
		Terminal terminal = viaje.getParadaActual();
		terminal.cambiarElEstadoDe(new FaseWorking(buque), buque);
		terminal.verOperacionesDe(buque);
	}

	@Override
	public void actualizar(int distancia, Viaje viaje) {
		notificarTerminal(viaje, buque);
	}	
}

