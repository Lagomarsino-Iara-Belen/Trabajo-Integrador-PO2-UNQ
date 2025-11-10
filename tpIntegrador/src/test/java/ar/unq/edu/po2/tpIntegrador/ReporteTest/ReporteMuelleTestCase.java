package ar.unq.edu.po2.tpIntegrador.ReporteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteMuelle;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class ReporteMuelleTestCase {
	private Buque buqueMock;
    private Viaje viajeMock;
    private ReporteMuelle reporte;

    @BeforeEach
    void setUp() {
        buqueMock = mock(Buque.class);
        viajeMock = mock(Viaje.class);
        reporte = new ReporteMuelle();
    }

    @Test
    void generarReportePara_conTresOrdenes_debeIncluirCantidadTresYAceptacionDelBuque() {
    	
        when(buqueMock.aceptarReporte(reporte)).thenReturn("BUQUE-REPORTE\n");
        List<Orden> ordenes = Arrays.asList(
            mock(Orden.class),
            mock(Orden.class),
            mock(Orden.class)
        );

        String resultado = reporte.generarReportePara(buqueMock, ordenes);

 
        assertNotNull(resultado);
        assertTrue(resultado.startsWith("BUQUE-REPORTE\n"),
                   "Debe comenzar con lo que devuelve buque.aceptarReporte()");
        assertTrue(resultado.contains("Cantidad de containers operados: 3"),
                   "Debe contener la cantidad de órdenes operadas: 3");
        verify(buqueMock, times(1)).aceptarReporte(reporte);
    }

    @Test
    void generarReportePara_conZeroOrdenes_debeIncluirCantidadCero() {
    
        when(buqueMock.aceptarReporte(reporte)).thenReturn("REPORTE-VACIO\n");
        List<Orden> ordenes = Collections.emptyList();

     
        String resultado = reporte.generarReportePara(buqueMock, ordenes);

     
        assertNotNull(resultado);
        assertTrue(resultado.startsWith("REPORTE-VACIO\n"));
        assertTrue(resultado.contains("Cantidad de containers operados: 0"),
                   "Debe contener la cantidad de órdenes operadas: 0");
        verify(buqueMock, times(1)).aceptarReporte(reporte);
    }

    @Test
    void visitarBuque_debeIncluirNombreYFechasDelViaje() {
  
    	Terminal terminal = mock(Terminal.class);
    	
        LocalDate fecha = LocalDate.of(2025, 10, 20);
        when(buqueMock.getNombre()).thenReturn("BuenBuque");
        when(buqueMock.getViaje()).thenReturn(viajeMock);
        when(viajeMock.getParadaActual()).thenReturn(terminal);
        when(viajeMock.fechaDeParada(any())).thenReturn(fecha);

      
        String resultado = reporte.visitar(buqueMock);

      
        assertNotNull(resultado);
        assertTrue(resultado.contains("Nombre del buque: BuenBuque"));
        assertTrue(resultado.contains("Fecha de arribo: " + fecha.toString()));
        assertTrue(resultado.contains("Fecha de partida: " + fecha.toString()));
    }

    @Test
    void visitarOrdenDeImportacion_debeRetornarCadenaVacia() {
     
        OrdenDeImportacion ordImp = mock(OrdenDeImportacion.class);
        when(ordImp.aceptarReporte(reporte)).thenCallRealMethod(); 
       
        String resultado = ordImp.aceptarReporte(reporte);

      
        assertEquals("", resultado);
    }

    @Test
    void visitarOrdenDeExportacion_debeRetornarCadenaVacia() {
       
        OrdenDeExportacion ordExp = mock(OrdenDeExportacion.class);
        when(ordExp.aceptarReporte(reporte)).thenCallRealMethod(); 
      
        String resultado = ordExp.aceptarReporte(reporte);

      
        assertEquals("", resultado);
    }

}
