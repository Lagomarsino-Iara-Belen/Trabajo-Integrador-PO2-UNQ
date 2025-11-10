package ar.unq.edu.po2.tpIntegrador.Terminal;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class CriterioPuertoDestino implements CriterioDeRuta {

	@Override
	public boolean seCumplenQue(Viaje viaje, Terminal terminal) {
		return viaje.pasaPor(terminal);
	}
}
