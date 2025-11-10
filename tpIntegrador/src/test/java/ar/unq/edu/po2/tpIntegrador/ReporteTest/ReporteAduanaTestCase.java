package ar.unq.edu.po2.tpIntegrador.ReporteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteAduana;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ReporteAduanaTestCase {
	private Buque buqueMock;
    private Viaje viajeMock;
    private ReporteAduana reporte;

    @BeforeEach
    void setUp() {
        buqueMock = mock(Buque.class);
        viajeMock = mock(Viaje.class);
        reporte = new ReporteAduana();
    }

    @Test
    void generarReportePara_debeDelegarALoQueDevuelveBuqueAceptarReporte() {
        //con @SuppressWarnings("unchecked") indico al compilador que crea que el código es seguro y no causará excepciones inesperadas
        @SuppressWarnings("unchecked")
        List<Orden> ordenes = (List<Orden>) mock(List.class);
        when(buqueMock.aceptarReporte(reporte)).thenReturn("HTML-REPORTE");
       
        String resultado = reporte.generarReportePara(buqueMock, ordenes);
        
        assertNotNull(resultado);
        assertEquals("HTML-REPORTE", resultado);
        verify(buqueMock, times(1)).aceptarReporte(reporte);
    }

    @Test
    void visitarBuque_debeIncluirNombreFechaYListaDeContainers_vacioSiNoHayContainers() {
        
        String nombre = "MiBuque";
        LocalDate fecha = LocalDate.of(2025, 10, 20);
        Terminal terminal = mock(Terminal.class);

        when(buqueMock.getNombre()).thenReturn(nombre);
        when(buqueMock.getViaje()).thenReturn(viajeMock);
        when(viajeMock.getParadaActual()).thenReturn(terminal);
        when(viajeMock.fechaDeParada(any())).thenReturn(fecha);
        when(buqueMock.getContainers()).thenReturn(Collections.emptyList());

        
        String html = reporte.visitar(buqueMock);

        assertNotNull(html);
        assertTrue(html.contains("<title> Reporte de Aduana </title>"));
        assertTrue(html.contains("<p> Nombre del buque: " + nombre + "</p>"));
        assertTrue(html.contains("<p> fecha de arribo: " + fecha.toString() + "</p>"));
        assertTrue(html.contains("<p> fecha de partida: " + fecha.toString() + "</p>"));
        // Como no hay containers, la lista debe generarse pero vacía de items <li>
        // Verificamos que haya la etiqueta <ul> pero no un <li>
        assertTrue(html.contains("<ul>"));
        assertFalse(html.contains("<li>"), "No debe contener ningún elemento <li> cuando no hay containers");
    }

    @Test
    void visitarBuque_debeIncluirElementosDeContainers_siLosHay() {

        String nombre = "La pinta";
        LocalDate fecha = LocalDate.of(2025, 10, 20);
        Terminal terminal = mock(Terminal.class);
        BLBasico blBasico1 = mock(BLBasico.class);
        BLBasico blBasico2 = mock(BLBasico.class);
        ArrayList<String> prod1 = new ArrayList<>();
        prod1.add("Teclado");
        ArrayList<String> prod2 = new ArrayList<>();
        prod2.add("Celulares");

        Container cont1 = mock(Container.class);
        when(cont1.getId()).thenReturn("ABCD1234567");
        when(cont1.getContenido()).thenReturn(blBasico1);
        when(blBasico1.getTipoProducto()).thenReturn(prod1);

        Container cont2 = mock(Container.class);
        when(cont2.getId()).thenReturn("EFGH9876543");
        when(cont2.getContenido()).thenReturn(blBasico2);
        when(blBasico2.getTipoProducto()).thenReturn(prod2);
        
        List<Container> contList = Arrays.asList(cont1, cont2);

        when(buqueMock.getNombre()).thenReturn(nombre);
        when(buqueMock.getViaje()).thenReturn(viajeMock);
        when(viajeMock.getParadaActual()).thenReturn(terminal);
        when(viajeMock.fechaDeParada(any())).thenReturn(fecha);
        when(buqueMock.getContainers()).thenReturn(contList);

        String html = reporte.visitar(buqueMock);
        
        assertNotNull(html);
        assertTrue(html.contains("<p> Nombre del buque: " + nombre + "</p>"));
        assertTrue(html.contains("<p> fecha de arribo: " + fecha.toString() + "</p>"));
        assertTrue(html.contains("<p> fecha de partida: " + fecha.toString() + "</p>"));

        //Aca se verifica que cada contenedor aparezca como <li> ... 
        assertTrue(html.contains("<li> ID: ABCD1234567 tiene los productos: Teclado</li>"));
        assertTrue(html.contains("<li> ID: EFGH9876543 tiene los productos: Celulares</li>"));
    }

    @Test
    void visitarOrdenDeExportacion_debeRetornarCadenaVacia() {
        // Como el método visitar(OrdenDeExportacion) simplemente devuelve "", lo verificamos
        // Vamos a mockear una orden de exportación para invocar aceptarReporte
        OrdenDeExportacion ordenExp = mock(OrdenDeExportacion.class);
        when(ordenExp.aceptarReporte(reporte)).thenCallRealMethod();

        String resultado = ordenExp.aceptarReporte(reporte);

        assertEquals("", resultado);
    }

    @Test
    void visitarOrdenDeImportacion_debeRetornarCadenaVacia() {
    	OrdenDeImportacion ordenImp = mock(OrdenDeImportacion.class);
        when(ordenImp.aceptarReporte(reporte)).thenCallRealMethod();

        String resultado = ordenImp.aceptarReporte(reporte);

        assertEquals("", resultado);
    }

}
