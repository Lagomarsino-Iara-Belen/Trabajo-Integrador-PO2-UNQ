package ar.unq.edu.po2.tpIntegrador.Terminal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import ar.unq.edu.po2.tpIntegrador.Reporte.Reporte;
import java.time.Duration;

public class Terminal {

	List<Orden> ordenes = new ArrayList<Orden>();
	List<Cliente> clientes = new ArrayList<Cliente>();
	List<Naviera> navieras = new ArrayList<Naviera>();
	Set<EmpresaTransportista> transportistas = new HashSet<EmpresaTransportista>();
	MotorDeBusqueda motor;
	
	public Terminal(MotorDeBusqueda motor) {
		this.motor = motor;
	}
	
	public boolean chequearEnvio(Camion camion, Chofer chofer, Turno turno) {
		return this.chequearCamionYChofer(camion, chofer) && this.chequearTurno(turno);
	}
	
	private boolean chequearTurno(Turno turno) {
		return turno.estáRetrasado();
	}
	
	private boolean chequearCamionYChofer(Camion camion, Chofer chofer) {
		return this.transportistas.stream().anyMatch(transportista -> transportista.chequearCamionYChofer(camion, chofer));
	}
	
	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public List<Naviera> getNavieras() {
		return navieras;
	}

	public Set<EmpresaTransportista> getTransportistas() {
		return transportistas;
	}

	public void exportar(Orden orden, Cliente cliente, EmpresaTransportista transportista) {
		Turno turnoExp = new Turno(orden.getFechaSalida(),Duration.ofHours(3));
		
		this.addOrden(orden);
		this.addTransportista(transportista);
		cliente.guardarTurno(turnoExp);
		orden.setTurno(turnoExp); // Esto lo tendria que sacar porque lo tendria que hacer el motor de busqueda cuando lo genera, por eso no esta en el UML
	}

	public void importar(Orden orden, Cliente cliente, EmpresaTransportista transportista) {
		Turno turnoImp = new Turno(orden.getFechaLlegada(),Duration.ofHours(24));
		
		this.addOrden(orden); 
		this.addTransportista(transportista);
		cliente.guardarTurno(turnoImp);
		orden.setTurno(turnoImp); // Esto lo tendria que sacar porque lo tendria que hacer el motor de busqueda cuando lo genera, por eso no esta en el UML
	}
	
	public void addTransportista(EmpresaTransportista transportista) {
		this.transportistas.add(transportista);
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
		buque.operar(this.ordenesDelBuque(buque).collect(Collectors.toList()));
	}

	public void enviarMailALosClientesDe(Buque buque, List<Container> containers) {
		this.clientesConOrdenesEn(buque, containers).stream().forEach(cliente -> cliente.recibirMail());
	}

	public void enviarFacturacion(Buque buque, List<Container> containers) {
		this.ordenesDelBuque(buque)
		.forEach(orden -> orden.getContainer().getImportadores().stream()
				.forEach(cliente -> this.hacerFacturaPara(cliente, orden)));
	}
	
	public void avisarAClientes(Buque buque) {
		this.ordenesDelBuque(buque).forEach(orden -> orden.avisarCliente(this));
		
	}
	
	public void hacerFacturaPara(Cliente cliente, Orden orden) {
		cliente.guardarFactura(new Factura(orden));
	}
	
	/**
	 * los clientes con ordenes en el buque dado por parametro nunca van a ser shippers y consignees juntos porque, antes de trabajar en el buque
	 * solo hay ordenes de importacion que estoy esperando, porque las de exportacion todavia no las subi, despues de trabajar en el buque
	 * solo hay ordenes de exportacion que envie, porque las de importacion ya las bajé.
	 */
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
	
	public String reporteParaBuque(Reporte reporte, Buque buque) {
		return reporte.generarReportePara(buque, this.ordenesDelBuque(buque).toList());
	}
	
	public void removeTransportista(EmpresaTransportista e) {
		this.transportistas.remove(e);
	}
	
	public void removeOrden(Orden o) {
		this.ordenes.remove(o);
	}
	
	public void removeNaviera(Naviera n) {
		this.navieras.remove(n);
	}
	
	public void cambiarCriterioDelMotor(CriterioDeRuta criterio) {
		this.motor.setCriterioDeRuta(criterio);
	}
}
