package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.time.LocalDate;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class CriterioFechaDeSalida implements CriterioDeRuta {

	private LocalDate fechaDeSalida;
	
	public CriterioFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}
	
	@Override
	public boolean seCumplenQue(Viaje viaje, Terminal terminal) {
		return viaje.getFechaDeInicio().equals(fechaDeSalida);
	}

}
