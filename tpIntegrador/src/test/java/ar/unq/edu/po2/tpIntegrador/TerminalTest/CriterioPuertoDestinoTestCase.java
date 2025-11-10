package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriterioPuertoDestino;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class CriterioPuertoDestinoTestCase {
	private CriterioPuertoDestino criterio;
	private Terminal terminal;
	private Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);
		terminal = mock(Terminal.class);
		criterio = new CriterioPuertoDestino();	
	}

	@Test
	void testSeCumplenQue() {
		when(viaje.pasaPor(terminal)).thenReturn(true);
		assertTrue(criterio.seCumplenQue(viaje, terminal));
	}
	
	@Test
	void testNoSeCumplenQue() {
		when(viaje.pasaPor(terminal)).thenReturn(false);
		assertFalse(criterio.seCumplenQue(viaje, terminal));
	}

}
