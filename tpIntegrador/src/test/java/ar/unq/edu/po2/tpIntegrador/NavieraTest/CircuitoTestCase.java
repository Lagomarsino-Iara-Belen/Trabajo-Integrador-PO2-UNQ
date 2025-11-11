package ar.unq.edu.po2.tpIntegrador.NavieraTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Circuito;
import ar.unq.edu.po2.tpIntegrador.Naviera.Tramo;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class CircuitoTestCase {
	private Circuito circuito;
	private Tramo tramo1;
	private Terminal terminal1;
	private Terminal terminal2;
	private ArrayList<Tramo> listaTramo;

	@BeforeEach
	void setUp() throws Exception {
		tramo1 = mock(Tramo.class);
		
		listaTramo = new ArrayList<Tramo>();
		listaTramo.add(tramo1);
		circuito = new Circuito(listaTramo);
		
	}
	
	@Test
	void testGetPuertoInicio() {
		terminal1 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);

		assertEquals(tramo1.getPuertoOrigen(), circuito.getPuertoInicio() );
	}
	
	@Test
	void testGetPuertoFinal() {
		terminal1 = mock(Terminal.class);
		when(tramo1.getPuertoDestino()).thenReturn(terminal1);

		assertEquals(tramo1.getPuertoDestino(), circuito.getPuertoFinal() );
	}

	@Test
	void testProximaParadaDe() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		assertEquals(tramo1.getPuertoDestino(), circuito.proximaParadaDe(terminal1));
	}
	
	@Test
	void testHaySiguienteParada() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		assertTrue(circuito.haySiguienteParada(terminal1));
	}
	
	@Test
	void testNoHaySiguienteParada() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal2);
		when(tramo1.getPuertoDestino()).thenReturn(terminal1);
		
		assertFalse(circuito.haySiguienteParada(terminal1));
	}
	
	@Test
	void testGetTodosLosTramos() {
		
		assertEquals(listaTramo, circuito.getTodosLosTramos());
	}
	
	@Test
	void testTramoActual() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		Tramo tramo2 = mock(Tramo.class);
		
		listaTramo.add(tramo2);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo2.getPuertoOrigen()).thenReturn(terminal2);
		
		assertEquals(tramo1, circuito.tramoActualDe(terminal1));
	}
	
	@Test
	void testCronogramaSaliendo() {
		LocalDate fecha = LocalDate.of(2025, 10, 1);
		
		Tramo tramo2 = mock(Tramo.class);
		listaTramo.add(tramo2);
		
		when(tramo1.getSemanas()).thenReturn(2);
		when(tramo2.getSemanas()).thenReturn(4);
		
		List<LocalDate> cronog = new ArrayList<>();
		cronog.add(fecha);
		cronog.add(fecha.plusWeeks(2));
		cronog.add(fecha.plusWeeks(6));
		
		assertEquals(cronog, circuito.cronogramaSaliendo(fecha)) ;
	}
	
	@Test
	void testPrecioHasta() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		Terminal terminal3 = mock(Terminal.class);
		
		Tramo tramo2 = mock(Tramo.class);
		listaTramo.add(tramo2);
		
		when(tramo1.getPrecio()).thenReturn(200d);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		when(tramo2.getPrecio()).thenReturn(500d);
		when(tramo2.getPuertoOrigen()).thenReturn(terminal2);
		when(tramo2.getPuertoDestino()).thenReturn(terminal3);
		
		assertEquals(700d, circuito.precioHasta(terminal3));
	}
	
	@Test
	void testPrecioHasta2() {
		terminal1 = mock(Terminal.class);
		
		when(tramo1.getPrecio()).thenReturn(200d);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		
		assertEquals(0d, circuito.precioHasta(terminal1));
	}
	
	@Test
	void testPrecioHasta3() {
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		Terminal terminal3 = mock(Terminal.class);
		
		when(tramo1.getPrecio()).thenReturn(200d);
		when(tramo1.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo1.getPuertoDestino()).thenReturn(terminal2);
		
		
		assertEquals(200d, circuito.precioHasta(terminal3));
	}
	
	@Test
	void testCronogramaSaliendoCubreCombiner() {
	    LocalDate fecha = LocalDate.of(2025, 10, 1);

	    Tramo tramo2 = mock(Tramo.class);
	    Tramo tramo3 = mock(Tramo.class);
	    listaTramo.add(tramo2);
	    listaTramo.add(tramo3);

	    circuito = new Circuito(listaTramo);

	    when(tramo1.getSemanas()).thenReturn(2);
	    when(tramo2.getSemanas()).thenReturn(4);
	    when(tramo3.getSemanas()).thenReturn(3);

	    List<LocalDate> resultado = circuito.getTodosLosTramos().parallelStream().collect(
	            () -> new ArrayList<>(List.of(fecha)),
	            (lista, tramo) -> {
	                LocalDate ultima = lista.get(lista.size() - 1);
	                lista.add(ultima.plusWeeks(tramo.getSemanas()));
	            },
	            (a, b) -> a.addAll(b) // <- lo que buscamos cubrir
	    );

	    // fechas que deben de aparecer
	    assertTrue(resultado.contains(fecha));
	    assertTrue(resultado.contains(fecha.plusWeeks(2)));
	    assertTrue(resultado.contains(fecha.plusWeeks(4)));
	    assertTrue(resultado.contains(fecha.plusWeeks(3)));

	    // combiner realmente se ejecutó -> lista tiene elementos adicionales
	    assertTrue(resultado.size() > 4);
	}

}