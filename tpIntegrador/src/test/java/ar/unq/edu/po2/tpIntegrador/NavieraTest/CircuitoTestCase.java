package ar.unq.edu.po2.tpIntegrador.NavieraTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Circuito;
import ar.unq.edu.po2.tpIntegrador.Naviera.Tramo;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class CircuitoTestCase {
	private Circuito circuito;
	private Tramo tramo1;
	private Terminal terminal1;
	private Terminal terminal2;
	private ArrayList<Tramo> listaTramo;

	@BeforeEach
	void setUp() throws Exception {
		tramo1 = mock(Tramo.class);
		
		listaTramo = new ArrayList<Tramo>();
		listaTramo.add(tramo1);
		circuito = new Circuito(listaTramo);
		
	}
	
	@Test
	void testGetPuertoInicio() {
		terminal1 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);

		assertEquals(tramo1.getPuertoOrigen(), circuito.getPuertoInicio() );
	}
	
	@Test
	void testGetPuertoFinal() {
		terminal1 = mock(Terminal.class);
		when(tramo1.getPuertoDestino()).thenReturn(terminal1);

		assertEquals(tramo1.getPuertoDestino(), circuito.getPuertoFinal() );
	}

	@Test
	void testProximaParadaDe() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		assertEquals(tramo1.getPuertoDestino(), circuito.proximaParadaDe(terminal1));
	}
	
	@Test
	void testHaySiguienteParada() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		assertTrue(circuito.haySiguienteParada(terminal1));
	}
	
	@Test
	void testNoHaySiguienteParada() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal2);
		when(tramo1.getPuertoDestino()).thenReturn(terminal1);
		
		assertFalse(circuito.haySiguienteParada(terminal1));
	}
	
	@Test
	void testGetTodosLosTramos() {
		
		assertEquals(listaTramo, circuito.getTodosLosTramos());
	}

}