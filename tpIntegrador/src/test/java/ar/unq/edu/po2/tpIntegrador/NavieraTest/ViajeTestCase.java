package ar.unq.edu.po2.tpIntegrador.NavieraTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Naviera.Circuito;
import ar.unq.edu.po2.tpIntegrador.Naviera.Tramo;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ViajeTestCase {
	private Viaje viaje;
	private Circuito circuito;
	private Tramo tramo;
	private Terminal terminal1;
	private Terminal terminal2;
	private LocalDate fecha;
	

	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.of(2025, 10, 20);
		circuito = mock(Circuito.class);
		terminal1 = mock(Terminal.class);
		
		when(circuito.getPuertoInicio()).thenReturn(terminal1);
		
		viaje = new Viaje(fecha, circuito); 
	}

	@Test
	void testCronograma() {
		ArrayList<LocalDate> cronog = new ArrayList<>();
		cronog.add(fecha); 
		cronog.add(fecha.plusWeeks(2));
		
		when(circuito.cronogramaSaliendo(any())).thenReturn(cronog);
		
		assertEquals(cronog, viaje.cronograma());
	}
	
	@Test
	void testProximaParada() { 
		terminal2 = mock(Terminal.class);
		
		when(circuito.proximaParadaDe(terminal1))
				.thenReturn(terminal2);
		when(circuito.haySiguienteParada(terminal1))
				.thenReturn(true);
		
		viaje.proximaParada(terminal1);
		
		assertEquals(terminal2, viaje.getParadaActual());
	}
	
	@Test
	void testProximaParada2() { 
		when(circuito.haySiguienteParada(terminal1))
				.thenReturn(false);
		
		viaje.proximaParada(terminal1);
		
		assertEquals(terminal1, viaje.getParadaActual());
	}
	
	@Test
	void testFechaDeInicio() {
		assertEquals(fecha, viaje.getFechaDeInicio());
	}
	
	@Test
	void testGetCircuito() {
		assertEquals(circuito, viaje.getCircuito());
	}
	
	@Test
	void testGetParadaActual() {
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		
		when(circuito.getTodosLosTramos())
				.thenReturn(new ArrayList<>(List.of(tramo)));
		
		assertEquals(circuito.getPuertoInicio(), viaje.getParadaActual());
	}
	
	@Test
	void testFechaDeParada() {
		when(circuito.cronogramaSaliendo(any())).thenReturn(Arrays.asList(fecha));
		
		assertEquals(fecha, viaje.fechaDeParada(terminal1));
	}
	
	@Test
	void testFechaDeParada2() {
		ArrayList<LocalDate> cronog = new ArrayList<>();
		cronog.add(fecha); 
		cronog.add(fecha.plusWeeks(2));
		terminal2 = mock(Terminal.class);
		when(circuito.proximaParadaDe(terminal1))
			.thenReturn(terminal2);
		when(circuito.haySiguienteParada(terminal1))
			.thenReturn(true);
		
		when(circuito.cronogramaSaliendo(any())).thenReturn(cronog);
		
		assertEquals(fecha.plusWeeks(2), viaje.fechaDeParada(terminal2));
	}
	
	@Test
	void testFechaDeParada3() {
		terminal2 = mock(Terminal.class);
		when(circuito.cronogramaSaliendo(any())).thenReturn(Arrays.asList(fecha));
		when(circuito.haySiguienteParada(terminal1))
			.thenReturn(false);
		
		assertEquals(fecha, viaje.fechaDeParada(terminal2));
	}
	
	@Test
	void testPasaPor() {
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		
		when(circuito.getTodosLosTramos())
				.thenReturn(new ArrayList<>(List.of(tramo)));
		when(circuito.getPuertoInicio()).thenReturn(terminal1);
		
		assertTrue(viaje.pasaPor(terminal1));
	}
	
	@Test
	void testPasaPor2() {
		terminal2 = mock(Terminal.class);
		
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo.getPuertoDestino()).thenReturn(terminal2);
		when(tramo.getSemanas()).thenReturn(2);
		
		when(circuito.getPuertoInicio()).thenReturn(terminal1);
		when(circuito.getTodosLosTramos())
				.thenReturn(new ArrayList<>(List.of(tramo)));
		when(circuito.proximaParadaDe(terminal1))
			.thenReturn(terminal2);
		when(circuito.haySiguienteParada(terminal1))
			.thenReturn(true);
		
		assertTrue(viaje.pasaPor(terminal2));
	}
	
	@Test
	void testPasaPor3() {
		terminal2 = mock(Terminal.class);
		
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo.getPuertoDestino()).thenReturn(terminal2);
		when(tramo.getSemanas()).thenReturn(2);
		
		when(circuito.getPuertoInicio()).thenReturn(terminal1);
		when(circuito.getTodosLosTramos())
				.thenReturn(new ArrayList<>(List.of(tramo)));
		when(circuito.haySiguienteParada(terminal1))
			.thenReturn(false);
		
		assertFalse(viaje.pasaPor(terminal2));
	}
	
	@Test
	void testPrecioDelViajeDe() {
	    terminal2 = mock(Terminal.class);
	    Terminal terminal3 = mock(Terminal.class);

	    // Tramos con sus precios
	    Tramo tramo1 = mock(Tramo.class);
	    when(tramo1.getPrecio()).thenReturn(100.0);

	    Tramo tramo2 = mock(Tramo.class);
	    when(tramo2.getPrecio()).thenReturn(150.0);

	    // El viaje empieza en terminal1
	    when(circuito.haySiguienteParada(terminal1)).thenReturn(true);
	    when(circuito.proximaParadaDe(terminal1)).thenReturn(terminal2);

	    when(circuito.haySiguienteParada(terminal2)).thenReturn(true);
	    when(circuito.proximaParadaDe(terminal2)).thenReturn(terminal3);

	    // tramoActualDe siempre se consulta con el **destino final**
	    when(circuito.tramoActualDe(terminal2)).thenReturn(tramo1);
	    when(circuito.tramoActualDe(terminal3)).thenReturn(tramo2);

	    double precio = viaje.precioDelViajeDe(terminal3);

	    assertEquals(250.0, precio);  // 100 + 150
	}
	
	@Test
	void testCantidadDeParadasDe() {
	    terminal2 = mock(Terminal.class);
	    Terminal terminal3 = mock(Terminal.class);

	    when(circuito.haySiguienteParada(terminal1)).thenReturn(true);
	    when(circuito.proximaParadaDe(terminal1)).thenReturn(terminal2);

	    when(circuito.haySiguienteParada(terminal2)).thenReturn(true);
	    when(circuito.proximaParadaDe(terminal2)).thenReturn(terminal3);

	    int cant = viaje.cantidadDeParadasDe(terminal3);

	    assertEquals(2, cant); // terminal1 → terminal2 → terminal3
	}
}
