package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseDeparting;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class FaseDepartingTestCase {

	private Buque buque;
	private Viaje viaje;
	private Terminal terminal;
	private FaseDeparting fase;
	
	@BeforeEach
    void setUp() {
        buque = mock(Buque.class);
        viaje = mock(Viaje.class);
        terminal = mock(Terminal.class);
        
        fase = new FaseDeparting(buque);
        when(viaje.getParadaActual()).thenReturn(terminal);
    }

    @Test
    void testActualizar_ramaDelFalse() {
    	fase.actualizar(0, viaje);
        
        verify(buque, times(0)).setFase(any());
        verify(terminal, times(0)).enviarMailALosClientesDe(any(), any());
        verify(terminal, times(0)).enviarFacturacion(any(), any());
    }

    @Test
    void testActualizar_ramaDelTrue() {
    	fase.actualizar(2, viaje);

        verify(buque).setFase(any());
        verify(terminal).enviarMailALosClientesDe(any(), any());
        verify(terminal).enviarFacturacion(any(), any());
    }
}
