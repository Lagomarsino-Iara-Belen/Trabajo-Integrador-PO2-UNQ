package ar.unq.edu.po2.tpIntegrador.EmpresaTransportistaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.EmpresaTransportista;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class EmpresaTransportistaTestCase {
	private EmpresaTransportista empresa;
    private Chofer chofer;
    private Camion camion;
    private Chofer chofer2;
    private Camion camion2;

    @BeforeEach
    void setUp() {
        chofer = new Chofer("Carlos");
        camion = new Camion("Volvo FH");

        empresa = new EmpresaTransportista(
            "TransLog",
            new ArrayList<>(List.of(chofer)),
            new ArrayList<>(List.of(camion))
        );
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("TransLog", empresa.getNombre());
        assertTrue(empresa.getChoferes().contains(chofer));
        assertTrue(empresa.getCamiones().contains(camion));
    }

    @Test
    void testAddChofer() {
        Chofer nuevo = new Chofer("Luis");
        empresa.addChofer(nuevo);

        assertTrue(empresa.getChoferes().contains(nuevo));
    }

    @Test
    void testRemoveChofer() {
        empresa.removeChofer(chofer);

        assertFalse(empresa.getChoferes().contains(chofer));
    }

    @Test
    void testAddCamion() {
        Camion nuevoCamion = new Camion("Scania R500");
        empresa.addCamion(nuevoCamion);

        assertTrue(empresa.getCamiones().contains(nuevoCamion));
    }

    @Test
    void testRemoveCamion() {
        empresa.removeCamion(camion);

        assertFalse(empresa.getCamiones().contains(camion));
    }

    @Test
    void testChequearCamionYChofer() {
        assertTrue(empresa.chequearCamionYChofer(camion, chofer));
    }

    @Test
    void testChequearCamionYChoferYCamionNoEsta() {
    	camion2 = mock(Camion.class);
    	
        assertFalse(empresa.chequearCamionYChofer(camion2, chofer));
    }

    @Test
    void testChequearCamionYChofer_False_ChoferNoEsta() {
    	chofer2 = mock(Chofer.class);
        assertFalse(empresa.chequearCamionYChofer(camion, chofer2));
    }

    @Test
    void testEnviarExportacionCuandoEsPosible() {
        Terminal terminal = mock(Terminal.class);
        Turno turno = mock(Turno.class);
        Camion camionMock = mock(Camion.class);
        Chofer choferMock = mock(Chofer.class);

        empresa.getCamiones().clear();
        empresa.getChoferes().clear();
        empresa.getCamiones().add(camionMock);
        empresa.getChoferes().add(choferMock);

        when(terminal.chequearEnvio(camionMock, choferMock, turno)).thenReturn(true);

        empresa.enviarExportacion(terminal, turno);

        verify(camionMock).cargar(terminal);
    }

    @Test
    void testEnviarExportacionCuandoNoEsPosible() {
        Terminal terminal = mock(Terminal.class);
        Turno turno = mock(Turno.class);
        Camion camionMock = mock(Camion.class);
        Chofer choferMock = mock(Chofer.class);

        empresa.getCamiones().clear();
        empresa.getChoferes().clear();
        empresa.getCamiones().add(camionMock);
        empresa.getChoferes().add(choferMock);

        when(terminal.chequearEnvio(camionMock, choferMock, turno)).thenReturn(false);

        empresa.enviarExportacion(terminal, turno);

        verify(camionMock, never()).cargar(any());
    }

    @Test
    void testEnviarImportacion() {
        Terminal terminal = mock(Terminal.class);
        Turno turno = mock(Turno.class);
        Camion camionMock = mock(Camion.class);
        Chofer choferMock = mock(Chofer.class);

        empresa.getCamiones().clear();
        empresa.getChoferes().clear();
        empresa.getCamiones().add(camionMock);
        empresa.getChoferes().add(choferMock);

        when(terminal.chequearEnvio(camionMock, choferMock, turno)).thenReturn(true);

        empresa.enviarImportacion(terminal, turno);

        verify(camionMock).descargar(terminal);
    }
}
