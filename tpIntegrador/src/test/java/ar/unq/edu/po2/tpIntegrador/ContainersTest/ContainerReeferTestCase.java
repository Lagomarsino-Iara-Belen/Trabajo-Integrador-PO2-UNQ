package ar.unq.edu.po2.tpIntegrador.ContainersTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Containers.ContainerReefer;

class ContainerReeferTestCase {

	private ContainerReefer containerReefer;
	private BLBasico blBasico;
	
	@BeforeEach
	void setUp() throws Exception {
		blBasico = mock(BLBasico.class);
		this.containerReefer = new ContainerReefer("ABCD0000001", 20, 40, 10, 500, false, this.blBasico);
	}
	
	@Test
	void testGetId() {
		assertEquals("ABCD0000001", this.containerReefer.getId());
	}
	
	@Test
	void testGetAncho() {
		assertEquals(20, this.containerReefer.getAncho());
	}
	
	@Test
	void testGetLargo() {
		assertEquals(40, this.containerReefer.getLargo());
	}
	
	@Test
	void testGetMetroCubico() {
		assertEquals(8000, this.containerReefer.getMetroCubico());
	}
	
	@Test
	void testGetAltura() {
		assertEquals(10, this.containerReefer.getAltura());
	}
	
	@Test
	void testGetPeso(){
		when(this.blBasico.getPeso()).thenReturn(500);
		assertEquals(this.blBasico.getPeso(), this.containerReefer.getPeso());
	}
	
	@Test
	void testGetEsDesconsolidado(){
		assertEquals(false, this.containerReefer.getEsDesconsolidado());
	}
	
	@Test
	void testGetContenido() {
		assertEquals(this.blBasico, this.containerReefer.getContenido());
	}
}
