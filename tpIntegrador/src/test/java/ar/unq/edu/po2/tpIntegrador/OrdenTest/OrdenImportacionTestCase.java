package ar.unq.edu.po2.tpIntegrador.OrdenTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeImportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteAduana;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteBuque;
import ar.unq.edu.po2.tpIntegrador.Reporte.ReporteMuelle;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

class OrdenImportacionTestCase {
	private Cliente cliente;
    private Buque buque;
    private Container container;
    private Terminal terminal;
    private OrdenDeImportacion orden;

    private LocalDateTime fechaSalida = LocalDateTime.of(2025, 1, 1, 10, 0);
    private LocalDateTime fechaLlegada = LocalDateTime.of(2025, 1, 5, 15, 0);

    @BeforeEach
    void setUp() {
    	cliente = mock(Cliente.class);
    	buque = mock(Buque.class);
    	container = mock(Container.class);
    	terminal = mock(Terminal.class);

        //Creo la orden con los datos necesarios
        orden = new OrdenDeImportacion(
            fechaSalida,
            fechaLlegada,
            container,
            buque,
            null, // creo un turno vacio
            cliente
        );
    }

    @Test
    void testOperarse_AddsContainerToBuque() {
        // cuando operarse se invoque con un buque, debe añadir el contenedor al buque
        orden.operarse(buque);

        // verifico que buque.addContainer fue llamado con el contenedor de la orden
        verify(buque).addContainer(container);
    }

    @Test
    void testGetCliente_ReturnsShipperCliente() {
        assertEquals(cliente, orden.getCliente());
    }

    @Test
    void testAvisarCliente_InvokesEnviarImportacionAOnCliente() {
        // para probar avisarCliente, necesito que la orden tenga un turno definido, por eso creo un Turno
        Turno turno = new Turno(fechaLlegada, java.time.Duration.ofHours(24));
        orden.setTurno(turno);

        orden.avisarCliente(terminal);

        // verifico que el cliente recibió la llamada enviarImportacionA con terminal + turno
        verify(cliente).enviarImportacionA(terminal, turno);
    }

    @Test
    void testAceptarReporteDeAduana() {
        ReporteAduana reporteAduana = mock(ReporteAduana.class);
        when(reporteAduana.visitar(orden)).thenReturn("");

        String resultado = orden.aceptarReporte(reporteAduana);

        assertEquals("", resultado);
        verify(reporteAduana).visitar(orden);
    }
    
    @Test
    void testAceptarReporteDeBuque() {
        ReporteBuque reporteBuque = mock(ReporteBuque.class);
        when(reporteBuque.visitar(orden)).thenReturn("<item>  </item>");

        String resultado = orden.aceptarReporte(reporteBuque);

        assertTrue(resultado.contains("<item>"));
        assertTrue(resultado.contains("</item>"));
        verify(reporteBuque).visitar(orden);
    }
    
    @Test
    void testAceptarReporteDeMuelle() {
        ReporteMuelle reporteMuelle = mock(ReporteMuelle.class);
        when(reporteMuelle.visitar(orden)).thenReturn("");

        String resultado = orden.aceptarReporte(reporteMuelle);

        assertEquals("", resultado);
        verify(reporteMuelle).visitar(orden);
    }
}

