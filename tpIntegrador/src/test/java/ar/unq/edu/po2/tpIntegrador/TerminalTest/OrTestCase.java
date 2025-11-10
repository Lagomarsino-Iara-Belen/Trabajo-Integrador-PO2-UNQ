package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Terminal.Or;

class OrTestCase {
	private boolean verdadero = true;
	private boolean falso = false;
	private Or or = new Or();

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void testCombinarCriterios1() {
		assertTrue(or.combinarCriterios(verdadero, verdadero));
	}
	
	@Test
	void testCombinarCriterios2() {
		assertTrue(or.combinarCriterios(verdadero, falso));
	}
	
	@Test
	void testCombinarCriterios3() {
		assertFalse(or.combinarCriterios(falso, falso));
	}
	
	@Test
	void testCombinarCriterios4() {
		assertTrue(or.combinarCriterios(falso, verdadero));
	}

}
