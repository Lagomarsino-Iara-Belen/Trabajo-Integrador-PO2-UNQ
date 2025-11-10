package ar.unq.edu.po2.tpIntegrador.OrdenTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Orden.Turno;

class TurnoTestCase {

	private Turno turno;
	
	@BeforeEach
	void setUp() throws Exception {
		turno = new Turno(LocalDateTime.of(2025,11,10,0,0,0), Duration.ofHours(3));
		
	}

	@Test
	void testGetFechaInicio() {
        assertEquals(LocalDateTime.of(2025,11,10,0,0,0),turno.getFechaInicio());
    }

	@Test
	void testGetRetraso() {
        assertEquals(Duration.ofHours(3),turno.getRetraso());
    }
	
	@Test
	void testGetFechaFin() {
		LocalDateTime fechaFin = LocalDateTime.of(2025,11,10,0,0,0).plus(Duration.ofHours(3));
		
        assertEquals(fechaFin,turno.getFechaFin());
    }
	
	@Test
	void testEstáRetrasado() {
		LocalDateTime fechaPasada = LocalDateTime.of(2025,11,10,4,0,0);
        
		assertTrue(turno.estáRetrasado(fechaPasada));
    }
}
