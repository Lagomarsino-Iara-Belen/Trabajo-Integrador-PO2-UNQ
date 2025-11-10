package ar.unq.edu.po2.tpIntegrador.ReporteTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteBuque;

class ReporteBuqueTestCase {
	private ReporteBuque reporte;

    @BeforeEach
    void setUp() {
        reporte = new ReporteBuque();
    }

    @Test
    void generarReportePara_conSoloImportaciones_debeIncluirItemsDeImportacionYExportVacío() {
        OrdenDeImportacion imp1 = mock(OrdenDeImportacion.class);
        Container contImp1 = mock(Container.class);
        when(contImp1.getId()).thenReturn("ABCD1234567");
        when(imp1.getContainer()).thenReturn(contImp1);
        when(imp1.aceptarReporte(reporte)).thenCallRealMethod();

        List<Orden> lista = Collections.singletonList(imp1);

        String resultado = reporte.generarReportePara(null , lista); //buque no usado en este método

        assertNotNull(resultado);
        assertTrue(resultado.contains("<import>"));
        assertTrue(resultado.contains("<item>ABCD1234567</item>"));
        assertTrue(resultado.contains("</export>")); // export bloque existe aunque vacío
    }

    @Test
    void generarReportePara_conSoloExportaciones_debeIncluirItemsDeExportacionYImportVacío() {

        OrdenDeExportacion exp1 = mock(OrdenDeExportacion.class);
        Container contExp1 = mock(Container.class);
        when(contExp1.getId()).thenReturn("ABCD1234567");
        when(exp1.getContainer()).thenReturn(contExp1);
        when(exp1.aceptarReporte(reporte)).thenCallRealMethod();

        List<Orden> lista = Collections.singletonList(exp1);

        String resultado = reporte.generarReportePara(null, lista);

        assertNotNull(resultado);
        assertTrue(resultado.contains("<export>"));
        assertTrue(resultado.contains("<item>ABCD1234567</item>"));
        assertTrue(resultado.contains("</export>"));  // import bloque existe aunque vacío
    }

    @Test
    void generarReportePara_conAmbasImportYExport_debeSepararLosItemsCorrespondientes() {

        OrdenDeImportacion imp1 = mock(OrdenDeImportacion.class);
        Container contImp = mock(Container.class);
        when(contImp.getId()).thenReturn("ABCD1234567");
        when(imp1.getContainer()).thenReturn(contImp);
        when(imp1.aceptarReporte(reporte)).thenCallRealMethod();

        OrdenDeExportacion exp1 = mock(OrdenDeExportacion.class);
        Container contExp = mock(Container.class);
        when(contExp.getId()).thenReturn("EFGH9876543");
        when(exp1.getContainer()).thenReturn(contExp);
        when(exp1.aceptarReporte(reporte)).thenCallRealMethod();

        List<Orden> lista = Arrays.asList(imp1, exp1);

        String resultado = reporte.generarReportePara(null, lista);


        assertNotNull(resultado);
        // Verifica que el ítem de importación está dentro del bloque <import>
        assertTrue(resultado.indexOf("<import>") < resultado.indexOf("<item>ABCD1234567</item>"));
        // Verifica que el ítem de exportación aparece y está dentro <export>
        assertTrue(resultado.contains("<item>EFGH9876543</item>"));
        // Asegura que export bloque aparece después del import bloque
        assertTrue(resultado.indexOf("</import>") < resultado.indexOf("<export>"));
    }

    @Test
    void generarReportePara_conListaVacia_debeMostrarBloquesVacios() {
    	
        List<Orden> lista = Collections.emptyList();

        String resultado = reporte.generarReportePara(null, lista);

        assertNotNull(resultado);
        // Debe contener los bloques incluso sin items
        assertTrue(resultado.contains("<import>"));
        assertTrue(resultado.contains("</import>"));
        assertTrue(resultado.contains("<export>"));
        assertTrue(resultado.contains("</export>"));
        // No debe contener ningún <item>
        assertFalse(resultado.contains("<item>"));
    }
    
    @Test
    void generarReportePara_unBuque_debeRetornarCadenaVacia() {
    	Buque buque = mock(Buque.class);
        when(buque.aceptarReporte(reporte)).thenCallRealMethod();

        String resultado = buque.aceptarReporte(reporte);

        assertEquals("", resultado);
    }

}
