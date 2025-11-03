package ar.unq.edu.po2.tpIntegrador.Containers;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class ContainerTanque extends Container {

	private BLBasico contenido;
	
	public ContainerTanque(String id, int ancho, int largo, int altura, int peso, boolean desconsolidado, BLBasico contenido) {
		super(id, ancho, largo, altura, peso, desconsolidado);
		this.contenido = contenido;
	}
	
	public BLBasico getContenido() {
		return this.contenido;
	}

	@Override
	public List<Cliente> getImportadores() {
		return this.contenido.getImportador();
	}
}
