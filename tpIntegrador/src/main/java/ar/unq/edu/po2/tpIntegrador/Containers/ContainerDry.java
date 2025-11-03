package ar.unq.edu.po2.tpIntegrador.Containers;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.BLs.BL;
import ar.unq.edu.po2.tpIntegrador.BLs.BLEspecial;
import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class ContainerDry extends Container {

	BLEspecial contenido;
	
	public ContainerDry(String id, int ancho, int largo, int altura, int peso, boolean desconsolidado, BLEspecial contenidos) {
		super(id, ancho, largo, altura, peso, desconsolidado);
		this.contenido = contenidos;
	}

	@Override
	public List<Cliente> getImportadores() {
		return this.contenido.getImportador();
	}

	@Override
	public BL getContenido() {
		return this.contenido;
	}

}
