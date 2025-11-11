package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class ModeloConMenosTerminales implements ModeloDeBusqueda {

	@Override
	public Optional<Viaje> buscarMejorRuta(List<Viaje> rutas, Terminal terminal) {
		return rutas.stream().min(Comparator.comparingInt(viaje -> viaje.cantidadDeParadasDe(terminal)));
	}
}
