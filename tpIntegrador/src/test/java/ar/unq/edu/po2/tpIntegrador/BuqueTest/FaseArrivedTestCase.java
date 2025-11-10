package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseArrived;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class FaseArrivedTestCase {

	private Buque buque;
	private Viaje viaje;
	private Terminal terminal;
	private FaseArrived fase;
	
	@BeforeEach
    void setUp() {
        buque = mock(Buque.class);
        viaje = mock(Viaje.class);
        terminal = mock(Terminal.class);
        
        fase = new FaseArrived(buque);
        when(viaje.getParadaActual()).thenReturn(terminal);
    }
	
    @Test
    void testActualizar() {
    	fase.actualizar(2, viaje);

        verify(terminal).cambiarElEstadoDe(any(), any());
        verify(terminal).verOperacionesDe(buque);
    }
}
