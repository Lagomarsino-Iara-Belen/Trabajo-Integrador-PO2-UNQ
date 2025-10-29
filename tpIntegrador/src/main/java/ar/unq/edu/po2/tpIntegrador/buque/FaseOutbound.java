package ar.unq.edu.po2.tpIntegrador.buque;

import ar.unq.edu.po2.tpIntegrador.Viaje.Viaje;

public class FaseOutbound implements FaseDeBuque {

	@Override
	public void actualizar(Buque buque, int distancia, Viaje viaje) {
		// TODO Auto-generated method stub
		if (distancia < 50) {
			buque.setEstado(new FaseInbound());
		}
	}
}
