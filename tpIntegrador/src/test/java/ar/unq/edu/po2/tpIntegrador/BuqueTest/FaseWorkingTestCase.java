package ar.unq.edu.po2.tpIntegrador.BuqueTest;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseWorking;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class FaseWorkingTestCase {

    private Buque buque;
    private Viaje viaje;
    private Terminal parada;
    private Orden orden1;
    private Orden orden2;

    private FaseWorking fase;

    @BeforeEach
    void setUp() {
        buque  = mock(Buque.class);
        viaje  = mock(Viaje.class);
        parada = mock(Terminal.class);
        orden1     = mock(Orden.class);
        orden2     = mock(Orden.class);

        fase = new FaseWorking(buque);
    }

    @Test
    void testActualizar() {
        when(viaje.getParadaActual()).thenReturn(parada);

        fase.actualizar(100, viaje);

        verify(parada).cambiarElEstadoDe(any(), any());
    }

    @Test
    void testOperarse() {
        List<Orden> ordenes = Arrays.asList(orden1, orden2);
        
        fase.operar(ordenes);

        verify(orden1).operarse(buque);
        verify(orden2).operarse(buque);
    }
}