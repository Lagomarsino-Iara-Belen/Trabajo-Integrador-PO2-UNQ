package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;

class BuqueTestCase {
	private Buque buque;

	@BeforeEach
	void setUp() throws Exception {
		buque = new Buque("La pinta");
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
