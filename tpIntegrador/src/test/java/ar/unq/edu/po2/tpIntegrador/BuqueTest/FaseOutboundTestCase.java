package ar.unq.edu.po2.tpIntegrador.BuqueTest;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseOutbound;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

class FaseOutboundTestCase {

	private Buque buque;
	private Viaje viaje;
	private FaseOutbound fase;
	
	@BeforeEach
    void setUp() {
        buque = mock(Buque.class);
        viaje = mock(Viaje.class);

        fase = new FaseOutbound(buque);
    }

    @Test
    void testActualizar_ramaDelFalse() {
    	fase.actualizar(50, viaje);
    	fase.actualizar(100, viaje);
        
        verify(buque, times(0)).setFase(any());
    }

    @Test
    void testActualizar_ramaDelTrue() {
    	fase.actualizar(49, viaje);

        verify(buque).setFase(any());
    }
}
