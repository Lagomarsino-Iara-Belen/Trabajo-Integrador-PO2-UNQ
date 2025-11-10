package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseDeBuque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;

class BuqueTestCase {
	private Buque buque;
	private FaseDeBuque fase;
	private Viaje viaje;
	private Container container1;
	private Container container2;

	@BeforeEach
	void setUp() throws Exception {
		fase = mock(FaseDeBuque.class);
		viaje = mock(Viaje.class);
		container1 = mock(Container.class);
		container2 = mock(Container.class);
		
		buque = new Buque("La pinta");
		buque.addContainer(container1);
	}

	@Test
	void testSetFase_y_testActualizar() {
		buque.setFase(fase);
		buque.setViaje(viaje);
		buque.actualizar(0);
		
		verify(fase).actualizar(0, viaje);
	}
	
	@Test
	void testAddContainer() {
		buque.addContainer(container2);
		
		assertEquals(2,buque.getContainers().size());
	}
	
	@Test
	void testRemoveContainer() {
		buque.removeContainer(container1);
		
		assertEquals(0,buque.getContainers().size());
	}
	
	@Test
	void testGetContainers() {
		assertEquals(Arrays.asList(container1),buque.getContainers());
	}
	
	@Test
	void testSetViaje_y_testGetViaje() {
		buque.setViaje(viaje);
		
		assertEquals(viaje,buque.getViaje());
	}
	
	@Test
	void testOperar() {
		Orden orden = mock(Orden.class);
		
		buque.setFase(fase);
		buque.operar(Arrays.asList(orden));
		
		verify(fase).operar(Arrays.asList(orden));
	}
	
	@Test
	void testAceptarReporte() {
		Reporte reporte = mock(Reporte.class);
		
		buque.aceptarReporte(reporte);
		
		verify(reporte).visitar(buque);
	}
	
	@Test
	void testGetNombre() {
		assertEquals("La pinta", buque.getNombre());
	}
}
