package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.*;

class MotorDeBusquedaTestCase {

    private MotorDeBusqueda motor;
    private CriterioDeRuta criterioMock;
    private ModeloDeBusqueda modeloMock;
    private Viaje viaje1;
    private Viaje viaje2;
    private Terminal terminal;

    @BeforeEach
    void setUp() throws Exception {
        motor = new MotorDeBusqueda();
        criterioMock = mock(CriterioDeRuta.class);
        modeloMock = mock(ModeloDeBusqueda.class);
        viaje1 = mock(Viaje.class);
        viaje2 = mock(Viaje.class);
        terminal = mock(Terminal.class);
    }

    @Test
    void testBuscarRutaConFiltro() {
        motor.setCriterioDeRuta(criterioMock);
        
        List<Viaje> viajes = Arrays.asList(viaje1, viaje2);

        when(criterioMock.seCumplenQue(viaje1, terminal)).thenReturn(true);
        when(criterioMock.seCumplenQue(viaje2, terminal)).thenReturn(false);

        List<Viaje> resultado = motor.buscarRuta(viajes, terminal);

        assertEquals(1, resultado.size());
        assertTrue(resultado.contains(viaje1));
        assertFalse(resultado.contains(viaje2));
    }

    @Test
    void testSetCriterioDeRuta() {
        motor.setCriterioDeRuta(criterioMock);
        List<Viaje> viajes = Arrays.asList(viaje1);

        when(criterioMock.seCumplenQue(viaje1, terminal)).thenReturn(true);

        assertEquals(1, motor.buscarRuta(viajes, terminal).size());
    }

    @Test
    void testBuscarMejorRutaUsaModelo() {
        motor.setModeloDeBusqueda(modeloMock);

        List<Viaje> viajes = Arrays.asList(viaje1, viaje2);
        Optional<Viaje> esperado = Optional.of(viaje2);

        when(modeloMock.buscarMejorRuta(viajes, terminal)).thenReturn(esperado);

        Optional<Viaje> resultado = motor.buscarMejorRuta(viajes, terminal);

        assertEquals(esperado, resultado);
    }
}