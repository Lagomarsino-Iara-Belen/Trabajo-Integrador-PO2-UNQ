package ar.unq.edu.po2.tpIntegrador.ClientesTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Clientes.Factura;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.EmpresaTransportista;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class ClienteTestCase {

    private Cliente cliente;
    private EmpresaTransportista transportista;
    private Turno turno;
    private Factura factura;
    private Terminal terminal;

    @BeforeEach
    void setUp() {
        transportista = mock(EmpresaTransportista.class);
        turno = mock(Turno.class);
        factura = mock(Factura.class);
        terminal = mock(Terminal.class);

        cliente = new Cliente("Juan Pérez", "juan@mail.com", transportista);
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("Juan Pérez", cliente.getNombre());
        assertEquals("juan@mail.com", cliente.getMail());
        assertEquals(transportista, cliente.getTransportista());
    }

    @Test
    void testGuardarFactura() {
        cliente.guardarFactura(factura);

        List<Factura> facturas = cliente.getFacturas();
        assertTrue(facturas.contains(factura));
        assertEquals(1, facturas.size());
    }

    @Test
    void testGuardarTurno() {
        cliente.guardarTurno(turno);

        List<Turno> turnos = cliente.getTurnos();
        assertTrue(turnos.contains(turno));
        assertEquals(1, turnos.size());
    }

    @Test
    void testEnviarExportacionA() {
        cliente.guardarTurno(turno);
        cliente.enviarExportacionA(terminal, turno);

        assertFalse(cliente.getTurnos().contains(turno));

        verify(transportista).enviarExportacion(terminal, turno);
    }

    @Test
    void testEnviarImportacionA() {
        cliente.guardarTurno(turno);
        cliente.enviarImportacionA(terminal, turno);

        assertFalse(cliente.getTurnos().contains(turno));
        verify(transportista).enviarImportacion(terminal, turno);
    }

    @Test
    void testRecibirMailEsInvocable() {
        cliente.recibirMail();
    }
}