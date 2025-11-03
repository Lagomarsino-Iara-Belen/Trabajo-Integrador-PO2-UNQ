package ar.unq.edu.po2.tpIntegrador.Containers;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class ContainerReefer extends Container {

	private BLBasico contenido;
	private int consumo;
	
	public ContainerReefer(String id, int ancho, int largo, int altura, int peso, boolean desconsolidado, BLBasico contenido, int consumo) {
		super(id, ancho, largo, altura, peso, desconsolidado);
		this.contenido = contenido;
		this.consumo = consumo;
	}
	
	public int getConsumo() {
		return this.consumo;
	}

	public BLBasico getContenido() {
		return contenido;
	}

	@Override
	public List<Cliente> getImportadores() {
		return this.contenido.getImportador();
	}
	
}
