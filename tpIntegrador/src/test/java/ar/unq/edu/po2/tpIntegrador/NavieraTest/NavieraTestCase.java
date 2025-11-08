package ar.unq.edu.po2.tpIntegrador.NavieraTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Naviera.Circuito;
import ar.unq.edu.po2.tpIntegrador.Naviera.Naviera;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;

class NavieraTestCase {

	 	private Naviera naviera;
	    private Buque buque1;
	    private Buque buque2;
	    private Viaje viaje1;
	    private Circuito circuito1;

	    @BeforeEach
	    void setUp() {
	        buque1 = mock(Buque.class);
	        buque2 = mock(Buque.class);
	        viaje1 = mock(Viaje.class);
	        circuito1 = mock(Circuito.class);

	        List<Viaje> viajes = new ArrayList<>();
	        viajes.add(viaje1);

	        List<Buque> buques = new ArrayList<>();
	        buques.add(buque1);

	        List<Circuito> circuitos = new ArrayList<>();
	        circuitos.add(circuito1);

	        naviera = new Naviera(viajes, buques, circuitos);
	    }

	    @Test
	    void testGetViajeARealizar() {
	        assertEquals(1, naviera.getViajeARealizar().size());
	        assertTrue(naviera.getViajeARealizar().contains(viaje1));
	    }

	    @Test
	    void testGetBuques() {
	        assertEquals(1, naviera.getBuques().size());
	        assertTrue(naviera.getBuques().contains(buque1));
	    }

	    @Test
	    void testGetCircuitos() {
	        assertEquals(1, naviera.getCurcuitos().size());
	        assertTrue(naviera.getCurcuitos().contains(circuito1));
	    }

	    @Test
	    void testAddCircuito() {
	        Circuito c2 = mock(Circuito.class);
	        naviera.addCircuito(c2);

	        assertEquals(2, naviera.getCurcuitos().size());
	        assertTrue(naviera.getCurcuitos().contains(c2));
	    }

	    @Test
	    void testAddBuque() {
	        naviera.addBuque(buque2);

	        assertEquals(2, naviera.getBuques().size());
	        assertTrue(naviera.getBuques().contains(buque2));
	    }

	    @Test
	    void testRemoveCircuito() {
	        naviera.removeCircuito(circuito1);

	        assertEquals(0, naviera.getCurcuitos().size());
	        assertFalse(naviera.getCurcuitos().contains(circuito1));
	    }

	    @Test
	    void testRemoveBuque() {
	        naviera.removeBuque(buque1);

	        assertEquals(0, naviera.getBuques().size());
	        assertFalse(naviera.getBuques().contains(buque1));
	    }

	    @Test
	    void testAsignarViaje() {
	        // Acción
	        naviera.asignarViaje(buque1, viaje1);

	        verify(buque1).setViaje(viaje1);
	    }

	    @Test
	    void testAsignarViajeNoExiste() {
	        naviera.asignarViaje(buque2, viaje1);

	        verify(buque2, never()).setViaje(any());
	    }
}
