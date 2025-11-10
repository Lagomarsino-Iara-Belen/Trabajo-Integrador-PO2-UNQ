package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriterioFechaDeSalida;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class CriterioFechaDeSalidaTestCase {
	private CriterioFechaDeSalida criterio;
	private Terminal terminal;
	private Viaje viaje;
	private LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);
		terminal = mock(Terminal.class);
		fecha = LocalDate.of(2025, 11, 5);
		criterio = new CriterioFechaDeSalida(fecha);	
	}

	@Test
	void testSeCumplenQue() {
		when(viaje.getFechaDeInicio()).thenReturn(fecha);
		assertTrue(criterio.seCumplenQue(viaje, terminal));
	}
	
	@Test
	void testNoSeCumplenQue() {
		when(viaje.getFechaDeInicio()).thenReturn(fecha.plusDays(21));
		assertFalse(criterio.seCumplenQue(viaje, terminal));
	}
}
