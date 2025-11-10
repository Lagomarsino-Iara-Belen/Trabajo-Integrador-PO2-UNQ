package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.List;
import java.util.stream.Collectors;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class MotorDeBusqueda {
	
	private CriterioDeRuta criterio;
	
	public MotorDeBusqueda() {
		this.criterio = new CriterioPuertoDestino();
	}
	
	public List<Viaje> buscarRuta(List <Viaje> rutas, Terminal terminal) {
		return rutas.stream()
				.filter(viaje -> this.criterio.seCumplenQue(viaje, terminal))
				.collect(Collectors.toList());
	}
	
	public void setCriterioDeRuta(CriterioDeRuta criterio) {
		this.criterio = criterio;
	}
}
