package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.GPS;

class GPSTestCase {
	private GPS gps;
	private Buque buque;

	@BeforeEach
	void setUp() throws Exception {
		gps = new GPS();
	}

	@Test
	void testGetUbicacion() {
		assertEquals(0, gps.getUbicacion());
	}
	
	@Test
	void testSetUbicacion() {
		gps.setUbicacion(5);
		assertEquals(5, gps.getUbicacion());
	}
	
	@Test
	void testAvisarCambio() {
		buque = mock(Buque.class);
		gps.addObserver(buque);
		gps.avisarCambio();
		
		verify(buque).actualizar(gps.getUbicacion());
	}
	
	@Test
	void testRemoveObserver() {
		buque = mock(Buque.class);
		
		gps.addObserver(buque);
		gps.removeObserver(buque);
		
		assertEquals(0, gps.getObservers().size());
	}
}
