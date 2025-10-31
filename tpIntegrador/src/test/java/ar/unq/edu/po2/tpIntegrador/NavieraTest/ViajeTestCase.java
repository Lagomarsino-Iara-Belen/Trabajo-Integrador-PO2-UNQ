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
		
		viaje = new Viaje(fecha, circuito); 
	}

	@Test
	void testCronograma() {
		 ArrayList<LocalDate> cronog = new ArrayList<>();
		 cronog.add(fecha); 
		 cronog.add(fecha.plusWeeks(2));
		 
		 tramo = mock(Tramo.class);
		when(tramo.getSemanas()).thenReturn(2);
		when(circuito.getTodosLosTramos())
			.thenReturn(new ArrayList<>(List.of(tramo)));
		
		assertEquals(cronog, viaje.cronograma());
	}
	
	@Test
	void testProximaParada() { 
		terminal1 = mock(Terminal.class);
		terminal2 = mock(Terminal.class);
		
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		when(tramo.getPuertoDestino()).thenReturn(terminal2);
		
		when(circuito.proximaParadaDe(terminal1))
				.thenReturn(terminal2);
		when(circuito.haySiguienteParada(terminal1))
				.thenReturn(true);
		
		viaje.proximaParada(terminal1);
		
		assertEquals(terminal2, viaje.getParadaActual());
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
		terminal1 = mock(Terminal.class);
		
		tramo = mock(Tramo.class);
		when(tramo.getPuertoOrigen()).thenReturn(terminal1);
		
		when(circuito.getTodosLosTramos())
				.thenReturn(new ArrayList<>(List.of(tramo)));
		
		assertEquals(circuito.getPuertoInicio(), viaje.getParadaActual());
	}


}
