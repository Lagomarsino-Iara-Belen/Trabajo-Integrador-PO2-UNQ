package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseDeBuque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.*;
import ar.unq.edu.po2.tpIntegrador.Naviera.Naviera;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.OrdenDeExportacion;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;

public class Terminal {

	ArrayList<Orden> ordenes;
	ArrayList<Cliente> clientes;
	ArrayList<Naviera> navieras;
	ArrayList<EmpresaTransportista> transportistas;
	
	public Terminal() {
		this.ordenes = new ArrayList<Orden>();
		this.clientes = new ArrayList<Cliente>();
		this.navieras = new ArrayList<Naviera>();
		this.transportistas = new ArrayList<EmpresaTransportista>();
	}
	
	public boolean chequearCamionYChofer(Camion camion, Chofer chofer) {
		return this.transportistas.stream().anyMatch(transportista -> transportista.chequearCamionYChofer(camion, chofer));
	}
	
	public Turno exportar(Orden orden, LocalDateTime horario) {
		addOrden(orden);
		return new Turno(horario);
	}
	
	public void addOrden(Orden orden) {
		this.ordenes.add(orden);	
	}
	
	public void addNaviera(Naviera naviera) {
		this.navieras.add(naviera);
	}
	
	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void cambiarElEstadoDe(FaseDeBuque fase, Buque buque) {
		buque.cambiarEstado(fase);
	}
	
	public void verOperacionesDe(Buque buque) {
		buque.operar(ordenesDelBuque(buque).collect(Collectors.toList()));
	}

	public void enviarMailAShipper(Buque buque, List<Container> containers) {
		List<Cliente> shippers = containers.stream()
			.flatMap(co -> co.getImportadores().stream())
			.filter(shipper -> ordenesDelBuque(buque).anyMatch(orden -> orden.getCliente().equals(shipper)))
			.collect(Collectors.toList());
		
		shippers.stream().forEach(shipper -> shipper.recibirMail());
	}

	public void enviarFacturacion() {
		// TODO Auto-generated method stub
	}

	public void enviarMailALosConsignees() {
		// TODO Auto-generated method stub
	}
	
	private Stream<Orden> ordenesDelBuque(Buque buque) {
		return this.ordenes.stream().filter(orden -> orden.getBuque().equals(buque));
	}
}
