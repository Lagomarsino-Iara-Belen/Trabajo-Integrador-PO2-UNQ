package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.ModeloMasBarato;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ModeloMasBaratoTestCase {

    private ModeloMasBarato modelo;
    private Viaje viaje1;
    private Viaje viaje2;
    private Viaje viaje3;
    private Terminal terminal;

    @BeforeEach
    void setUp() throws Exception {
        modelo = new ModeloMasBarato();
        viaje1 = mock(Viaje.class);
        viaje2 = mock(Viaje.class);
        viaje3 = mock(Viaje.class);
        terminal = mock(Terminal.class);
    }

    @Test
    void testBuscaElViajeMasBarato() {
        // precios simulados
        when(viaje1.precioDelViajeDe(terminal)).thenReturn(300.0);
        when(viaje2.precioDelViajeDe(terminal)).thenReturn(150.0);
        when(viaje3.precioDelViajeDe(terminal)).thenReturn(500.0);
        
        List<Viaje> viajes = List.of(viaje1, viaje2, viaje3);
        
        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isPresent());
        assertEquals(viaje2, resultado.get()); // el más barato
    }

    @Test
    void testCuandoNoHayRutasDevuelveOptionalVacio() {
        List<Viaje> viajes = List.of();
        
        Optional<Viaje> resultado = modelo.buscarMejorRuta(viajes, terminal);

        assertTrue(resultado.isEmpty());
    }
}
