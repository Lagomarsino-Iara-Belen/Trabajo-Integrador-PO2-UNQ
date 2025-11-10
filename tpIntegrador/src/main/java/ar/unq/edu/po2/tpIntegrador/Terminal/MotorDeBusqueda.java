package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class MotorDeBusqueda {
	
	private CriterioDeRuta criterio;
	
	public MotorDeBusqueda() {
		this.criterio = new CriterioPuertoDestino();
	}
	
	public List<Viaje> buscarRuta(List <Viaje> rutas, Terminal terminal) {
		return null;
	}
	
	public void setCriterioDeRuta(CriterioDeRuta criterio) {
		this.criterio = criterio;
	}
}
