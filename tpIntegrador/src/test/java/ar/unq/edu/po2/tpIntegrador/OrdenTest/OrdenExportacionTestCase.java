package ar.unq.edu.po2.tpIntegrador.OrdenTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

class OrdenExportacionTestCase {

	private Cliente cliente;
	private Buque buque;
	private Container container;
	private Turno turno;
	private OrdenDeExportacion orden;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = mock(Cliente.class);
		buque = mock(Buque.class);
		container = mock(Container.class);
		turno = mock(Turno.class);
		
		orden = new OrdenDeExportacion(LocalDateTime.of(2025,11,10,0,0,0), LocalDateTime.of(2025,11,15,0,0,0), container, buque, turno, cliente);
	}

	@Test
	void testGetServicios() {
		assertEquals(new ArrayList<Servicio>(), orden.getServicios());
	}
	
	@Test
	void testOperarse() {
		orden.operarse(buque);
		verify(buque).removeContainer(any());
	}
	
	@Test
	void testGetBuque() {
		assertEquals(buque, orden.getBuque());
	}
	
	@Test
	void testGetContainer() {
		assertEquals(container, orden.getContainer());
	}
	
	@Test
	void testGetTurno() {
		assertEquals(turno, orden.getTurno());
	}
	
	@Test
	void testGetFechaSalida() {
		assertEquals(LocalDateTime.of(2025,11,10,0,0,0), orden.getFechaSalida());
	}
	
	@Test
	void testGetFechaLlegada() {
		assertEquals(LocalDateTime.of(2025,11,15,0,0,0), orden.getFechaLlegada());
	}
}
