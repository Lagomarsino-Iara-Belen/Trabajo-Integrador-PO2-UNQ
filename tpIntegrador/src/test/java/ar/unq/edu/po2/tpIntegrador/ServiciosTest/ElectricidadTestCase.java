package ar.unq.edu.po2.tpIntegrador.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Servicios.Electricidad;

public class ElectricidadTestCase {
	@Test
    void testPrecioSinHorasDeConsumoEsCero() {
        Container container = mock(Container.class);
        Electricidad electricidad = new Electricidad(50.0, 0);

        assertEquals(0.0, electricidad.precioDelServicio(container));
    }

    @Test
    void testPrecioConHorasDeConsumo() {
        Container container = mock(Container.class);
        Electricidad electricidad = new Electricidad(50.0, 10);

        assertEquals(500.0, electricidad.precioDelServicio(container));
    }
}
