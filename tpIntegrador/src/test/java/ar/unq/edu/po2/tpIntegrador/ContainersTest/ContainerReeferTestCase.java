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
		this.containerReefer = new ContainerReefer("ABCD0000001", 20, 40, 10, 500, false, blBasico);
	}

	@Test
	void testGetPeso(){
		when(blBasico.getPeso()).thenReturn(500);
		assertEquals(blBasico.getPeso(), this.containerReefer.getPeso());
	}
	
	@Test
	void testGetContenido() {
		assertEquals(blBasico, this.containerReefer.getContenido());
	}
	
	@Test
	void testGetId() {
		assertEquals("ABCD0000001", this.containerReefer.getId());
	}
	
	@Test
	void testGetAncho() {
		assertEquals(20, this.containerReefer.getAncho());
	}
}
