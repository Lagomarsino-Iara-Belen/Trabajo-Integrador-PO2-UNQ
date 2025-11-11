package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.ModeloConMenosTerminales;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ModeloConMenosTerminalesTestCase {

    private ModeloConMenosTerminales modelo;
    private Viaje viaje1;
    private Viaje viaje2;
    private Viaje viaje3;
    private Terminal terminal;

    @BeforeEach
    void setUp() throws Exception {
        modelo = new ModeloConMenosTerminales();
        viaje1 = mock(Viaje.class);
        viaje2 = mock(Viaje.class);
        viaje3 = mock(Viaje.class);
        terminal = mock(Terminal.class);
    }

    @Test
    void testEligeElViajeConMenosParadas() {
        // Simulamos cantidades de paradas hasta terminal
        when(viaje1.cantidadDeParadasDe(terminal)).thenReturn(5);
        when(viaje2.cantidadDeParadasDe(terminal)).thenReturn(2);
        when(viaje3.cantidadDeParadasDe(terminal)).thenReturn(8);

        List<Viaje> viajes = List.of(viaje1, viaje2, viaje3);

        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isPresent());
        assertEquals(viaje2, resultado.get()); // el que tiene 2 paradas
    }

    @Test
    void testCuandoNoHayRutasDevuelveOptionalVacio() {
        List<Viaje> viajes = List.of();

        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isEmpty());
    }
}