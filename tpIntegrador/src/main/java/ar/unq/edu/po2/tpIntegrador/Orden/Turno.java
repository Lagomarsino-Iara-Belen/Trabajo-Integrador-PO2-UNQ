package ar.unq.edu.po2.tpIntegrador.Orden;

import java.time.LocalDateTime;

public class Turno {

	LocalDateTime horario;
	LocalDateTime retraso;
	
	public Turno(LocalDateTime horario, LocalDateTime retraso) {
		this.horario = horario;
	}
	
	public LocalDateTime getHorario() {
		return this.horario;
	}
	
	public LocalDateTime getRetraso() {
		return this.retraso;
	}
	
	public boolean estáRetrasado() {
		return this.horario.plusHours(this.retraso.getHour()).isBefore(LocalDateTime.now());
	}
}
