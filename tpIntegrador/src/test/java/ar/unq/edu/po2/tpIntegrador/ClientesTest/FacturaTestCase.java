package ar.unq.edu.po2.tpIntegrador.ClientesTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Clientes.Factura;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;
import ar.unq.edu.po2.tpIntegrador.Servicios.Servicio;

public class FacturaTestCase {
	 private Factura factura;
	 private OrdenDeImportacion orden;
	 private Servicio servicio1;
	 private Servicio servicio2;
	 private Container container;
	
	@BeforeEach
	void setup() {
		orden = mock(OrdenDeImportacion.class);
        servicio1 = mock(Servicio.class);
        servicio2 = mock(Servicio.class);
        container = mock(Container.class);

        factura = new Factura(orden,0d);

        when(orden.getContainer()).thenReturn(container);

        when(orden.getServicios()).thenReturn(List.of(servicio1, servicio2));

        when(servicio1.precioDelServicio(container)).thenReturn(1000.0);
        when(servicio2.precioDelServicio(container)).thenReturn(500.0);
	}
	
	@Test
	public void testSeCreaUnaFactura() {
		assertEquals(factura.getOrden(), orden);
	}
	
	@Test
	public void testMontoDeFactura() {		
		assertEquals(factura.montoTotal(), 1500.0);
	}
}
