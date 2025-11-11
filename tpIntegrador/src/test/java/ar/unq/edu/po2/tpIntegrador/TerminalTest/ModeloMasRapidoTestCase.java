package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.ModeloMasRapido;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ModeloMasRapidoTestCase {

    private ModeloMasRapido modelo;
    private Viaje viaje1;
    private Viaje viaje2;
    private Viaje viaje3;
    private Terminal terminal;

    @BeforeEach
    void setUp() throws Exception {
        modelo = new ModeloMasRapido();
        viaje1 = mock(Viaje.class);
        viaje2 = mock(Viaje.class);
        viaje3 = mock(Viaje.class);
        terminal = mock(Terminal.class);
    }

    @Test
    void testEligeElViajeMasRapido() {
        when(viaje1.fechaDeParada(terminal)).thenReturn(LocalDate.of(2025, 10, 10));
        when(viaje2.fechaDeParada(terminal)).thenReturn(LocalDate.of(2025, 10, 5));  // el más temprano
        when(viaje3.fechaDeParada(terminal)).thenReturn(LocalDate.of(2025, 10, 20));

        List<Viaje> viajes = List.of(viaje1, viaje2, viaje3);

        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isPresent());
        assertEquals(viaje2, resultado.get());
    }

    @Test
    void testCuandoNoHayRutasDevuelveOptionalVacio() {
        List<Viaje> viajes = List.of();

        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isEmpty());
    }
}