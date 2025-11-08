package ar.unq.edu.po2.tpIntegrador.Clientes;

import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.EmpresaTransportista;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;
import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Cliente {
	private String nombre;
	private String mail;
	private EmpresaTransportista transportista;
	private List<Factura> facturas = new ArrayList<Factura>();
	private List<Turno> turnos = new ArrayList<Turno>();
	
	public Cliente(String nombre, String mail, EmpresaTransportista transportista) {
		this.nombre = nombre;
		this.mail = mail;
		this.transportista = transportista;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public EmpresaTransportista getTransportista() {
		return this.transportista;
	}
	
	public void recibirMail() {
		// Es figurativo, nos sirve para el mockito!
	}

	public void guardarFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public void guardarTurno(Turno turno) {
		this.turnos.add(turno);
	}

	public void enviarExportacionA(Terminal terminal, Turno turno) {
		this.turnos.remove(turno);
		this.transportista.enviarExportacion(terminal, turno);
	}

	public void enviarImportacionA(Terminal terminal, Turno turno) {
		this.turnos.remove(turno);
		this.transportista.enviarImportacion(terminal, turno);
	}
}
