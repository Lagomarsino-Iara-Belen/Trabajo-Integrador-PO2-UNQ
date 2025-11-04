package ar.unq.edu.po2.tpIntegrador.BlsTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.BLs.BLEspecial;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

class BLEspecialTestCase {
	private BLEspecial blEspecial;
	private Cliente cliente;
	private Cliente cliente2;

	@BeforeEach
	void setUp() throws Exception {
		cliente = mock(Cliente.class);
		
		blEspecial = new BLEspecial(new ArrayList<>(List.of("Celulares")), 500d, new ArrayList<>(List.of(cliente)), new ArrayList<>());
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
		assertEquals(List.of(), blEspecial.getBLs());
	}
	
	@Test
	void testGetBLs2() {
		BLBasico blBasico = mock(BLBasico.class);
	
		blEspecial.addBL(blBasico);
		assertEquals(List.of(blBasico), blEspecial.getBLs());
	}
	
	@Test
	void testAddBLs() {
		BLBasico blBasico = mock(BLBasico.class);
		BLBasico blBasico2 = mock(BLBasico.class);
	
		blEspecial.addBL(blBasico);
		blEspecial.addBL(blBasico2);
		assertEquals(List.of(blBasico, blBasico2), blEspecial.getBLs());
	}
	
	@Test
	void testRemoveBLs() {
		BLBasico blBasico = mock(BLBasico.class);
		BLBasico blBasico2 = mock(BLBasico.class);
	
		blEspecial.addBL(blBasico);
		blEspecial.addBL(blBasico2);
		
		blEspecial.removeBL(blBasico2);
		assertEquals(List.of(blBasico), blEspecial.getBLs());
	}


}
