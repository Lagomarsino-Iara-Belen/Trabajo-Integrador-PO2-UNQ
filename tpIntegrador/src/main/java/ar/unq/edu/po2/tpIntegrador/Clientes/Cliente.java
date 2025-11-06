package ar.unq.edu.po2.tpIntegrador.Clientes;

import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Orden.Turno;

public class Cliente {
	private String nombre;
	private String mail;
	private List<Factura> facturas = new ArrayList<Factura>();
	private List<Turno> turnos = new ArrayList<Turno>();
	
	public Cliente(String nombre, String mail) {
		this.nombre = nombre;
		this.mail = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getMail() {
		return mail;
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
}
