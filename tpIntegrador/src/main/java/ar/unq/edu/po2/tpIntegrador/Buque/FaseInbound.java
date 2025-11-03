package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class FaseInbound extends FaseDeBuque {

	public FaseInbound(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(Buque buque, int distancia, Viaje viaje) {
		// TODO Auto-generated method stub
		if (distancia == 0) {
			buque.setEstado(new FaseArrived(buque));
			viaje.getParadaActual().enviarMailALosConsignees();
		}
	}

}
