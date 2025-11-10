package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Terminal.And;

class AndTestCase {
	private boolean verdadero = true;
	private boolean falso = false;
	private And and = new And();

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void testCombinarCriterios1() {
		assertTrue(and.combinarCriterios(verdadero, verdadero));
	}
	
	@Test
	void testCombinarCriterios2() {
		assertFalse(and.combinarCriterios(verdadero, falso));
	}
	
	@Test
	void testCombinarCriterios3() {
		assertFalse(and.combinarCriterios(falso, falso));
	}
	
	@Test
	void testCombinarCriterios4() {
		assertFalse(and.combinarCriterios(falso, verdadero));
	}

}
