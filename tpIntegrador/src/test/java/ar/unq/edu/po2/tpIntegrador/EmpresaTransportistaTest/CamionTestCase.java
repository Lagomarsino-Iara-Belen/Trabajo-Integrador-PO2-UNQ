package ar.unq.edu.po2.tpIntegrador.EmpresaTransportistaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class CamionTestCase {
	
	@Test
    void testGetModelo() {
        Camion camion = new Camion("Mercedes Actros");
        assertEquals("Mercedes Actros", camion.getModelo());
    }

    @Test
    void testCargarYDescargarSonInvocables() {
        Camion camion = new Camion("Volvo");
        Terminal terminal = mock(Terminal.class);

        camion.cargar(terminal);
        camion.descargar(terminal);
        // No falla = OK
    }

}
