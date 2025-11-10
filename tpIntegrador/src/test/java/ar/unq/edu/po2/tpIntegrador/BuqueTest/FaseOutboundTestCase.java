package ar.unq.edu.po2.tpIntegrador.BuqueTest;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseOutbound;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;

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
    
    @Test
    void testOperarse() {
    	Orden orden1 = mock(Orden.class);
        Orden orden2 = mock(Orden.class);
        List<Orden> ordenes = Arrays.asList(orden1, orden2);
        
        fase.operar(ordenes);
        
        verifyNoInteractions(orden1);
        verifyNoInteractions(orden2);
    }
}
