package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Terminal.And;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriterioFechaDeLlegada;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriterioPuertoDestino;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriteriosCombinados;
import ar.unq.edu.po2.tpIntegrador.Terminal.Or;

class CriteriosCombinadosTestCase {
	private CriteriosCombinados criteComb;
	private CriterioPuertoDestino critePDes;
	private CriterioFechaDeLlegada criteFLlegada;
	private And and = new And();
	private Or or = new Or();

	@BeforeEach
	void setUp() throws Exception {
		critePDes = mock(CriterioPuertoDestino.class);
		criteFLlegada = mock(CriterioFechaDeLlegada.class);
	}

	@Test
	void testSeCumplenQue() {
		criteComb = new CriteriosCombinados(critePDes, criteFLlegada, and);
		
		when(critePDes.seCumplenQue(null, null)).thenReturn(true);
		when(criteFLlegada.seCumplenQue(null, null)).thenReturn(true);
		
		assertTrue(criteComb.seCumplenQue(null, null));
	}
	
	@Test
	void testSeCumplenQue2() {
		criteComb = new CriteriosCombinados(critePDes, criteFLlegada, or);
		
		when(critePDes.seCumplenQue(null, null)).thenReturn(false);
		when(criteFLlegada.seCumplenQue(null, null)).thenReturn(true);
		
		assertTrue(criteComb.seCumplenQue(null, null));
	}
	
	@Test
	void testNoSeCumplenQue() {
		criteComb = new CriteriosCombinados(critePDes, criteFLlegada, and);
		
		when(critePDes.seCumplenQue(null, null)).thenReturn(true);
		when(criteFLlegada.seCumplenQue(null, null)).thenReturn(false);
		
		assertFalse(criteComb.seCumplenQue(null, null));
	}
	
	@Test
	void testNoSeCumplenQue2() {
		criteComb = new CriteriosCombinados(critePDes, criteFLlegada, or);
		
		when(critePDes.seCumplenQue(null, null)).thenReturn(false);
		when(criteFLlegada.seCumplenQue(null, null)).thenReturn(false);
		
		assertFalse(criteComb.seCumplenQue(null, null));
	}

}
