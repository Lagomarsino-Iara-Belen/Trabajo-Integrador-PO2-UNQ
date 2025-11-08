package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.Duration;
import java.time.LocalDateTime;

public class Turno {

	LocalDateTime horario;
	Duration retraso;
	
	public Turno(LocalDateTime fechaInicio, Duration retraso) {
        this.horario = fechaInicio;
        this.retraso = retraso;
    }

    public LocalDateTime getFechaInicio() {
        return this.horario;
    }

    public Duration getRetraso() {
        return this.retraso;
    }

    public LocalDateTime getFechaFin() {
        return this.horario.plus(this.retraso);
    }

    public boolean estáRetrasado() {
        return this.getFechaFin().isBefore(LocalDateTime.now());
    }
}
