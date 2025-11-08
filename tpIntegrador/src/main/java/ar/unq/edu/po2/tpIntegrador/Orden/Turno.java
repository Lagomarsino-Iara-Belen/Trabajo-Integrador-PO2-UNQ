package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.Duration;
import java.time.LocalDateTime;

public class Turno {

	LocalDateTime horario;
	Duration retraso;
	
	public Turno(LocalDateTime horario, Duration duration) {
		this.horario = horario;
	}
	
	public LocalDateTime getHorario() {
		return this.horario;
	}
	
	public Duration getRetraso() {
		return this.retraso;
	}
	
	public boolean estáRetrasado() {
		return this.getFechaInicio().isAfter(getFechaFin());
	}
	
	public LocalDateTime getFechaInicio() {
	    return this.horario;
	}

	public LocalDateTime getFechaFin() {
        return this.horario.plus(this.retraso);
    }
}
