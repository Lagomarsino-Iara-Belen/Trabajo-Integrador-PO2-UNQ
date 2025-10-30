package ar.unq.edu.po2.tpIntegrador.NavieraTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Tramo;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class TramoTestCase {
	private Tramo tramo;
	private Terminal terminalOrig;
	private Terminal terminalDes;
	

	@BeforeEach
	void setUp() throws Exception {
		terminalOrig = mock(Terminal.class);
		terminalDes = mock(Terminal.class);
		
		tramo = new Tramo(2, 500d, terminalOrig, terminalDes);
	}

	@Test
	void testGetSemana() {
		assertEquals(2, tramo.getSemanas());
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(500d, tramo.getPrecio());
	}
	
	@Test
	void testGetOrigen() {
		assertEquals(terminalOrig, tramo.getPuertoOrigen());
	}

	@Test
	void testGetDestino() {
		assertEquals(terminalDes, tramo.getPuertoDestino());
	}

}
