package ar.unq.edu.po2.tpIntegrador.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Servicios.Pesado;

public class PesadoTestCase {
	
	@Test
    void testPrecioDelServicio() {
        Container container = Mockito.mock(Container.class);

        Pesado pesado = new Pesado(500.0);

        assertEquals(500.0, pesado.precioDelServicio(container));
    }
}
