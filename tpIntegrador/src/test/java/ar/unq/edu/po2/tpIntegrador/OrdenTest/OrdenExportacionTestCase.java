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
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

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
		verify(buque).removeContainer(container);
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
	
	@Test
	void testAsignarServicio() {
		Servicio servicio = mock(Servicio.class);
		
		orden.asignarServicio(servicio);
		
		assertEquals(1,orden.getServicios().size());
	}
	
	@Test
	void testSacarServicio() {
		Servicio servicio1 = mock(Servicio.class);
		Servicio servicio2 = mock(Servicio.class);
		orden.asignarServicio(servicio1);
		orden.asignarServicio(servicio2);
		
		orden.sacarServicio(servicio2);
		
		assertEquals(1,orden.getServicios().size());
	}
	
	@Test
	void testAceptarReporte() {
		Reporte reporte = mock(Reporte.class);
		
		orden.aceptarReporte(reporte);
		
		verify(reporte).visitar(orden);
	}
	
	@Test
	void testGetCliente() {
		assertEquals(cliente,orden.getCliente());
	}
	
	@Test
	void testAvisarCliente() {
		Terminal terminal = mock(Terminal.class);
		
		orden.avisarCliente(terminal);
		
		verify(cliente).enviarExportacionA(terminal, turno);
	}
	
	@Test
	void setTurno() {
		Turno turno2 = mock(Turno.class);
		
		orden.setTurno(turno2);
		
		assertNotEquals(turno, orden.getTurno());
		assertEquals(turno2, orden.getTurno());
	}
}
