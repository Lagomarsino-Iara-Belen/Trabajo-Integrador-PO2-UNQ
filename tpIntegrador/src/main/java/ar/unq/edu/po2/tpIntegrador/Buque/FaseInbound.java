package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class FaseInbound extends FaseDeBuque {

	public FaseInbound(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(int distancia, Viaje viaje) {
		if (distancia == 0) {
			buque.setFase(new FaseArrived(buque));
			viaje.getParadaActual().enviarMailALosClientesDe(buque, buque.getContainers());
			viaje.getParadaActual().avisarAClientes(buque);
		}
	}

}
