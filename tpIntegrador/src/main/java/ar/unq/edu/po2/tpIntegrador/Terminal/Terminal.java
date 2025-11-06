package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.unq.edu.po2.tpIntegrador.Buque.Buque;
import ar.unq.edu.po2.tpIntegrador.Buque.FaseDeBuque;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Clientes.Factura;
import ar.unq.edu.po2.tpIntegrador.Containers.Container;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Camion;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.Chofer;
import ar.unq.edu.po2.tpIntegrador.EmpresaTransportista.EmpresaTransportista;
import ar.unq.edu.po2.tpIntegrador.Naviera.Naviera;
import ar.unq.edu.po2.tpIntegrador.Orden.Orden;
import ar.unq.edu.po2.tpIntegrador.Orden.Turno;

public class Terminal {

	List<Orden> ordenes = new ArrayList<Orden>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Naviera> navieras = new ArrayList<Naviera>();
	List<EmpresaTransportista> transportistas = new ArrayList<EmpresaTransportista>();
	
	public boolean chequearCamionYChofer(Camion camion, Chofer chofer) {
		return this.transportistas.stream().anyMatch(transportista -> transportista.chequearCamionYChofer(camion, chofer));
	}
	
	public void exportar(Orden orden, Cliente cliente) {
		addOrden(orden);
		cliente.guardarTurno(new Turno(orden.getFechaSalida()));
	}
	
	public void importar(Orden orden, Cliente cliente) {
		addOrden(orden); 
		// Falta ver que hacer con el cliente!
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

	public void enviarMailALosClientesDe(Buque buque, List<Container> containers) {
		clientesConOrdenesEn(buque, containers).stream().forEach(cliente -> cliente.recibirMail());
	}

	public void enviarFacturacion(Buque buque, List<Container> containers) {
		ordenesDelBuque(buque)
		.forEach(orden -> orden.getContainer().getImportadores().stream()
				.forEach(cliente -> this.hacerFacturaPara(cliente, orden)));
	}
	
	public void hacerFacturaPara(Cliente cliente, Orden orden) {
		cliente.guardarFactura(new Factura(orden));
	}
	
	private List<Cliente> clientesConOrdenesEn(Buque buque, List<Container> containers) {
		List<Cliente> clientes = containers.stream()
			.flatMap(container -> container.getImportadores().stream())
			.filter(cliente -> ordenesDelBuque(buque).anyMatch(orden -> orden.getCliente().equals(cliente)))
			.collect(Collectors.toList());
		return clientes;
	}
	
	private Stream<Orden> ordenesDelBuque(Buque buque) {
		return this.ordenes.stream().filter(orden -> orden.getBuque().equals(buque));
	}
}
