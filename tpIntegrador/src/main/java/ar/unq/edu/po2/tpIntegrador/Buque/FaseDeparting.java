package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class FaseDeparting extends FaseDeBuque {
	
	public FaseDeparting(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(int distancia, Viaje viaje) {
		if(distancia > 1) {
			buque.setFase(new FaseOutbound(buque));
			notificarTerminal(viaje);
		}
	}

	private void notificarTerminal(Viaje viaje) {
		viaje.getParadaActual().enviarMailALosClientesDe(buque, buque.getContainers());
		viaje.getParadaActual().enviarFacturacion(buque, buque.getContainers());
	}
}
