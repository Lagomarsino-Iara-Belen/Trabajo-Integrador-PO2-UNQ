package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.time.LocalDate;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

public class CriterioFechaDeLlegada implements CriterioDeRuta {

	private LocalDate fechaDeLlegada;
	
	public CriterioFechaDeLlegada(LocalDate fechaDeLlegada) {
		this.fechaDeLlegada = fechaDeLlegada;
	}
	
	@Override
	public boolean seCumplenQue(Viaje viaje, Terminal terminal) {
		return viaje.fechaDeParada(terminal).equals(fechaDeLlegada);
	}

}
