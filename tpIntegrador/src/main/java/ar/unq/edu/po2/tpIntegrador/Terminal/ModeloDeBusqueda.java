package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.List;
import java.util.Optional;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public interface ModeloDeBusqueda {
	public Optional<Viaje> buscarMejorRuta(List<Viaje> viajes, Terminal terminal);
}
