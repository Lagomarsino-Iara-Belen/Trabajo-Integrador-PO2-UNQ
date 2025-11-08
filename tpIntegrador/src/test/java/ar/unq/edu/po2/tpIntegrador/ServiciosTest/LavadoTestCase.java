package ar.unq.edu.po2.tpIntegrador.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Servicios.Lavado;

public class LavadoTestCase {
	
	@Test
    void testLavadoContainerChico() {
        Container container = mock(Container.class);
        when(container.getMetroCubico()).thenReturn(50);

        Lavado lavado = new Lavado(200.0);

        assertEquals(200.0, lavado.precioDelServicio(container));
    }

    @Test
    void testLavadoContainerGrande() {
        Container container = mock(Container.class);
        when(container.getMetroCubico()).thenReturn(100);

        Lavado lavado = new Lavado(200.0);

        assertEquals(400.0, lavado.precioDelServicio(container)); // doble
    }
}
