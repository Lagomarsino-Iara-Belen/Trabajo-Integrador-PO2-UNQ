package ar.unq.edu.po2.tpIntegrador.BlsTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

class BLBasicoTestCase {
	private BLBasico blBasico;
	private Cliente cliente;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = mock(Cliente.class);
		blBasico = new BLBasico("Celulares",500d, cliente);
	}

	@Test
	void testGetTipoProducto() {
		assertEquals(List.of("Celulares"), blBasico.getTipoProducto());
	}
	
	@Test
	void testGetImportador() {
		assertEquals(List.of(cliente),blBasico.getImportador());
	}
	
	@Test
	void testGetPeso() {
		assertEquals(500d, blBasico.getPeso());
	}


}
