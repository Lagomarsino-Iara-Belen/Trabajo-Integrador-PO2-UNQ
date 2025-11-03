package ar.unq.edu.po2.tpIntegrador.Buque;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class FaseOutbound extends FaseDeBuque {

	public FaseOutbound(Buque buque) {
		super(buque);
	}

	@Override
	public void actualizar(int distancia, Viaje viaje) {
		// TODO Auto-generated method stub
		if (distancia < 50) {
			buque.setEstado(new FaseInbound(buque));
		}
	}
}
