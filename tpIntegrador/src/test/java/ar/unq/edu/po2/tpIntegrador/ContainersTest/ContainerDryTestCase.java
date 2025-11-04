package ar.unq.edu.po2.tpIntegrador.ContainersTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.unq.edu.po2.tpIntegrador.BLs.BLEspecial;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.ContainerDry;

class ContainerDryTestCase {

	private ContainerDry containerDry;
	private BLEspecial blEspecial;
	
	@BeforeEach
	void setUp() throws Exception {
		blEspecial = mock(BLEspecial.class);
		containerDry = new ContainerDry("ABCD0000001", 20, 40, 10, 500, false, blEspecial);
	}
	
	@Test
	void testGetId() {
		assertEquals("ABCD0000001", containerDry.getId());
	}
	
	@Test
	void testGetAncho() {
		assertEquals(20, containerDry.getAncho());
	}
	
	@Test
	void testGetLargo() {
		assertEquals(40, containerDry.getLargo());
	}
	
	@Test
	void testGetMetroCubico() {
		assertEquals(8000, containerDry.getMetroCubico());
	}
	
	@Test
	void testGetAltura() {
		assertEquals(10, this.containerDry.getAltura());
	}
	
	@Test
	void testGetPeso(){
		when(this.blEspecial.getPeso()).thenReturn(500d);
		assertEquals(blEspecial.getPeso(), containerDry.getPeso());
	}
	
	@Test
	void testGetEsDesconsolidado(){
		assertEquals(false, containerDry.getEsDesconsolidado());
	}
	
	@Test
	void testGetContenido() {
		assertEquals(blEspecial, containerDry.getContenido());
	}
	
	@Test
	void testGetImportador() {
		Cliente cliente = mock(Cliente.class);
		when(blEspecial.getImportador()).thenReturn(new ArrayList<>(List.of(cliente)));
		
		assertEquals(blEspecial.getImportador(), containerDry.getImportadores());
	}
	
	@Test
	void testGetImportador2() {
		Cliente cliente1 = mock(Cliente.class);
		Cliente cliente2 = mock(Cliente.class);
		when(blEspecial.getImportador()).thenReturn(new ArrayList<>(List.of(cliente1,cliente2)));
		
		assertEquals(blEspecial.getImportador(), containerDry.getImportadores());
	}

}
