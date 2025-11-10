package ar.unq.edu.po2.tpIntegrador.Terminal;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public interface CriterioDeRuta {
	public boolean seCumplenQue(Viaje viaje, Terminal terminal);
}
