package ar.unq.edu.po2.tpIntegrador.EmpresaTransportistaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;

public class ChoferTestCase {
	
	 @Test
	    void testGetNombre() {
	        Chofer chofer = new Chofer("Juan");
	        assertEquals("Juan", chofer.getNombre());
	    }
}
