package ar.unq.edu.po2.tpIntegrador.ServiciosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Servicios.Almacenamiento;

public class AlmacenamientoTestCase {
	
	 @Test
	    void testPrecioDelServicio() {
	        Container container = Mockito.mock(Container.class);

	        Almacenamiento almacenamiento = new Almacenamiento(100.0, 3);

	        assertEquals(300.0, almacenamiento.precioDelServicio(container));
	    }
}
