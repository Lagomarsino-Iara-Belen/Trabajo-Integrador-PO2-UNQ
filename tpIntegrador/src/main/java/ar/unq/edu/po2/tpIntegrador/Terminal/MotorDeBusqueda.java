package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class MotorDeBusqueda {
	
	private CriterioDeRuta criterio;
	private ModeloDeBusqueda modelo;
	
	public MotorDeBusqueda() {
		this.criterio = new CriterioPuertoDestino();
		this.modelo = new ModeloMasBarato();
	}
	
	public List<Viaje> buscarRuta(List <Viaje> rutas, Terminal terminal) {
		return rutas.stream()
				.filter(viaje -> this.criterio.seCumplenQue(viaje, terminal))
				.collect(Collectors.toList());
	}
	
	public void setCriterioDeRuta(CriterioDeRuta criterio) {
		this.criterio = criterio;
	}
	
	public void setModeloDeBusqueda(ModeloDeBusqueda modelo) {
		this.modelo = modelo;
	}
	
	public Optional<Viaje> buscarMejorRuta(List<Viaje> rutas, Terminal terminal) {
		return this.modelo.buscarMejorRuta(rutas, terminal);
	}
}
