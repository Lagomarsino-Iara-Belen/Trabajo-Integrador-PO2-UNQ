package ar.unq.edu.po2.tpIntegrador.ContainersTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.ContainerTanque;

class ContainerTanqueTestCase {

	private ContainerTanque containerTanque;
	private BLBasico blBasico;
	
	@BeforeEach
	void setUp() throws Exception {
		blBasico = mock(BLBasico.class);
		containerTanque = new ContainerTanque("ABCD0000001", 20, 40, 10, 500, false, this.blBasico);
	}
	
	@Test
	void testGetId() {
		assertEquals("ABCD0000001", containerTanque.getId());
	}
	
	@Test
	void testGetAncho() {
		assertEquals(20, containerTanque.getAncho());
	}
	
	@Test
	void testGetLargo() {
		assertEquals(40, containerTanque.getLargo());
	}
	
	@Test
	void testGetMetroCubico() {
		assertEquals(8000, containerTanque.getMetroCubico());
	}
	
	@Test
	void testGetAltura() {
		assertEquals(10, containerTanque.getAltura());
	}
	
	@Test
	void testGetPeso(){
		when(blBasico.getPeso()).thenReturn(500d);
		assertEquals(blBasico.getPeso(), containerTanque.getPeso());
	}
	
	@Test
	void testGetEsDesconsolidado(){
		assertEquals(false, containerTanque.getEsDesconsolidado());
	}
	
	@Test
	void testGetContenido() {
		assertEquals(blBasico, containerTanque.getContenido());
	}
	
	@Test
	void testGetImportador() {
		Cliente cliente = mock(Cliente.class);
		when(blBasico.getImportador()).thenReturn(new ArrayList<>(List.of(cliente)));
		
		assertEquals(blBasico.getImportador(), containerTanque.getImportadores());
	}

}
