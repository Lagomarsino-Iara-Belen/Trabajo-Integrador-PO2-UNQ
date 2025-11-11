package ar.unq.edu.po2.tpIntegrador.TerminalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseDeBuque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.EmpresaTransportista;
import ar.unq.edu.po2.tpIntegrador.Naviera.Naviera;
import ar.unq.edu.po2.tpIntegrador.Naviera.Viaje;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import ar.unq.edu.po2.tpIntegrador.Terminal.CriterioDeRuta;
import ar.unq.edu.po2.tpIntegrador.Terminal.MotorDeBusqueda;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class TerminalTestCase {
	Terminal terminal;
    Buque buque;
    Orden orden;
    Cliente cliente;
    Container container;
    Reporte reporte;
    @Mock private EmpresaTransportista transportistaMock;
    @Mock private Camion camionMock;
    @Mock private Chofer choferMock;
    @Mock private Turno turnoMock;
    @Mock private MotorDeBusqueda motor;
    private Orden ordenMock;
    private Cliente clienteMock;
    private Naviera navieraMock;
    
    @BeforeEach
    void setup() {
    	motor = mock(MotorDeBusqueda.class);
    	
    	terminal = new Terminal(motor);
    	
        buque = mock(Buque.class);
        orden = mock(Orden.class);
        cliente = mock(Cliente.class);
        container = mock(Container.class);
        reporte = mock(Reporte.class);
        camionMock = mock(Camion.class);
        choferMock = mock(Chofer.class);
        turnoMock = mock(Turno.class);
        transportistaMock = mock(EmpresaTransportista.class);
        
        ordenMock = mock(Orden.class);
        clienteMock = mock(Cliente.class);
        navieraMock = mock(Naviera.class);

        when(orden.getBuque()).thenReturn(buque);
        when(orden.getCliente()).thenReturn(cliente);
        when(container.getImportadores()).thenReturn(List.of(cliente));
        when(orden.getContainer()).thenReturn(container);

        terminal.addOrden(orden);
        terminal.addCliente(cliente);

        terminal.addTransportista(transportistaMock);
    }

    @Test 
    void testCambiarCriterioDelMotor() {
    	CriterioDeRuta criterioNuevo = mock(CriterioDeRuta.class);
    	
    	terminal.cambiarCriterioDelMotor(criterioNuevo);
    	
    	verify(motor).setCriterioDeRuta(criterioNuevo);
    }
    
    @Test
    void testBuscarRuta() {
    	Viaje viaje1 = mock(Viaje.class);
    	Viaje viaje2 = mock(Viaje.class);
    	
    	List<Viaje> rutas = new ArrayList<Viaje>();
    	rutas.add(viaje1);
    	List<Viaje> rutas2 = rutas;
    	rutas.add(viaje2);
    	
    	when(navieraMock.getViajeARealizar()).thenReturn(rutas);
    	when(motor.buscarRuta(rutas, terminal)).thenReturn(rutas2);
    	terminal.addNaviera(navieraMock);
    	
    	assertEquals(terminal.buscarRuta(),rutas2);
    }
    
    @Test
    void testCambiarEstadoDe() {
        FaseDeBuque fase = mock(FaseDeBuque.class);

        terminal.cambiarElEstadoDe(fase, buque);

        verify(buque).setFase(fase);
    }

    @Test
    void testVerOperacionesDe() {
        terminal.verOperacionesDe(buque);

        verify(buque).operar(anyList());
    }

    @Test
    void testEnviarMailALosClientesDe() {
        terminal.enviarMailALosClientesDe(buque, List.of(container));

        verify(cliente).recibirMail();
    }

    @Test
    void testEnviarFacturacion() {
        terminal.enviarFacturacion(buque, List.of(container));

        verify(orden).hacerFacturaPara(cliente, terminal);
    }

    @Test
    void testAvisarAClientes() {
        terminal.avisarAClientes(buque);

        verify(orden).avisarCliente(terminal);
    }

    @Test
    void testReporteParaBuque() {
        when(reporte.generarReportePara(eq(buque), anyList())).thenReturn("REPORTE OK");

        String resultado = terminal.reporteParaBuque(reporte, buque);

        assertEquals("REPORTE OK", resultado);
    }
    
    @Test
    void testChequearEnvioTrueCuandoCamionYChoferCoincidenYTurnoEstaRetrasado() {
        Mockito.when(transportistaMock.chequearCamionYChofer(camionMock, choferMock)).thenReturn(true);

        Mockito.when(turnoMock.estáRetrasado(any())).thenReturn(true);

        boolean resultado = terminal.chequearEnvio(camionMock, choferMock, turnoMock);

        assertTrue(resultado);
    }

    @Test
    void testChequearEnvioFalseCuandoTurnoNoEstaRetrasado() {
        Mockito.when(transportistaMock.chequearCamionYChofer(camionMock, choferMock)).thenReturn(true);

        Mockito.when(turnoMock.estáRetrasado(LocalDateTime.now())).thenReturn(false);

        boolean resultado = terminal.chequearEnvio(camionMock, choferMock, turnoMock);

        assertFalse(resultado);
    }

    @Test
    void testChequearEnvioFalseCuandoNoCoincideCamionYChofer() {
        
        Mockito.when(transportistaMock.chequearCamionYChofer(camionMock, choferMock)).thenReturn(false);

        Mockito.when(turnoMock.estáRetrasado(LocalDateTime.now())).thenReturn(true);

        boolean resultado = terminal.chequearEnvio(camionMock, choferMock, turnoMock);

        assertFalse(resultado);
    }
    
    @Test
    void testAddNaviera_agregaLaNavieraALaListaInterna() {

    	terminal.removeNaviera(navieraMock);
    	
        assertTrue(terminal.getNavieras().isEmpty());

        terminal.addNaviera(navieraMock);

        assertEquals(1, terminal.getNavieras().size());
        assertTrue(terminal.getNavieras().contains(navieraMock));
    }

    @Test
    void testAddTransportista_agregaElTransportistaAlSetInterno() {
    	terminal.removeTransportista(transportistaMock);
    	
        assertTrue(terminal.getTransportistas().isEmpty());

        terminal.addTransportista(transportistaMock);

        assertEquals(1, terminal.getTransportistas().size());
        assertTrue(terminal.getTransportistas().contains(transportistaMock));
    }

    @Test
    void testExportar_agregaOrdenTransportistaYGuardaTurnoEnClienteYSeteaTurnoEnOrden() {
        LocalDateTime salida = LocalDateTime.of(2025, 11, 1, 10, 0);
        when(ordenMock.getFechaSalida()).thenReturn(salida);

        terminal.removeTransportista(transportistaMock);
        terminal.removeOrden(orden);
        
        assertTrue(terminal.getOrdenes().isEmpty());
        assertTrue(terminal.getTransportistas().isEmpty());

        terminal.exportar(ordenMock, clienteMock, transportistaMock);

        assertTrue(terminal.getOrdenes().contains(ordenMock));

        assertTrue(terminal.getTransportistas().contains(transportistaMock));

        ArgumentCaptor<Turno> captor = ArgumentCaptor.forClass(Turno.class);
        verify(clienteMock).guardarTurno(captor.capture());
        verify(ordenMock).setTurno(any(Turno.class));

        Turno turnoCreado = captor.getValue();
        assertNotNull(turnoCreado);
        
        assertEquals(salida, turnoCreado.getFechaInicio());
        assertEquals(salida.plusHours(3), turnoCreado.getFechaFin());
    }

    @Test
    void testImportar_agregaOrdenTransportistaYGuardaTurnoEnClienteYSeteaTurnoEnOrden() {
        LocalDateTime llegada = LocalDateTime.of(2025, 11, 2, 8, 30);
        when(ordenMock.getFechaLlegada()).thenReturn(llegada);

        terminal.removeTransportista(transportistaMock);
        terminal.removeOrden(orden);
        
        assertTrue(terminal.getOrdenes().isEmpty());
        assertTrue(terminal.getTransportistas().isEmpty());

        terminal.importar(ordenMock, clienteMock, transportistaMock);

        assertTrue(terminal.getOrdenes().contains(ordenMock));

        assertTrue(terminal.getTransportistas().contains(transportistaMock));

        ArgumentCaptor<Turno> captor = ArgumentCaptor.forClass(Turno.class);
        verify(clienteMock).guardarTurno(captor.capture());
        verify(ordenMock).setTurno(any(Turno.class));

        Turno turnoCreado = captor.getValue();
        assertNotNull(turnoCreado);

        assertEquals(llegada, turnoCreado.getFechaInicio());
        assertEquals(llegada.plusHours(24), turnoCreado.getFechaFin());
    }
}
