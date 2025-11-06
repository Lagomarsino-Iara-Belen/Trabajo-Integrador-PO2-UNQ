package ar.unq.edu.po2.tpIntegrador.BlsTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.BLs.BL;
import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.BLs.BLEspecial;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

class BLEspecialTestCase {
	private BLEspecial blEspecial = new BLEspecial(new ArrayList<BL>());
	private Cliente cliente = mock(Cliente.class);
	private Cliente cliente2 = mock(Cliente.class);;
	private BLBasico blBasico = new BLBasico("Celulares", 500d,cliente);
	
	@BeforeEach
	void setUp() throws Exception {
		blEspecial.addBL(blBasico);
	}

	@Test
	void testGetTipoProducto() {
		assertEquals(List.of("Celulares"), blEspecial.getTipoProducto());
		
	}
	@Test
	void testGetTipoProducto2() {
		
		BLBasico blBasico = mock(BLBasico.class);
		when(blBasico.getTipoProducto()).thenReturn(new ArrayList<>(List.of("Teclados")));
		
		blEspecial.addBL(blBasico);
		
		assertEquals(List.of("Celulares", "Teclados"),blEspecial.getTipoProducto());
	}
	
	@Test
	void testGetImportador() {
		assertEquals(List.of(cliente),blEspecial.getImportador());
	}
	
	@Test
	void testGetImportador2() {
		cliente2 = mock(Cliente.class);
		
		BLBasico blBasico = mock(BLBasico.class);
		when(blBasico.getImportador()).thenReturn(new ArrayList<>(List.of(cliente2)));
		
		blEspecial.addBL(blBasico);
		
		assertEquals(List.of(cliente, cliente2),blEspecial.getImportador());
	}
	
	@Test
	void testGetPeso() {
		assertEquals(500d, blEspecial.getPeso());
	}
	
	@Test
	void testGetPeso2() {
		cliente2 = mock(Cliente.class);
		BLBasico blBasico = new BLBasico("Teclados", 600d,cliente2);
		
		blEspecial.addBL(blBasico);
		
		assertEquals(1100d, blEspecial.getPeso());
	}
	
	@Test
	void testGetBLs() {
		assertEquals(List.of(blBasico), blEspecial.getBLs());
	}
	
	@Test
	void testGetBLs2() {
		BLBasico blBasico2 = mock(BLBasico.class);
		
		blEspecial.addBL(blBasico2);
		
		assertEquals(List.of(blBasico,blBasico2), blEspecial.getBLs());
	}
	
	@Test
	void testAddBLs() {
		BLBasico blBasico2 = mock(BLBasico.class);
		BLBasico blBasico3 = mock(BLBasico.class);
	
		blEspecial.addBL(blBasico2);
		blEspecial.addBL(blBasico3);
		assertEquals(List.of(blBasico, blBasico2, blBasico3), blEspecial.getBLs());
	}
	
	@Test
	void testRemoveBLs() {
		BLBasico blBasico2 = mock(BLBasico.class);
	
		blEspecial.addBL(blBasico2);
		blEspecial.removeBL(blBasico2);
		
		assertEquals(List.of(blBasico), blEspecial.getBLs());
	}


}
