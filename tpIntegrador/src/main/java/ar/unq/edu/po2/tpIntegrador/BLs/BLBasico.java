package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class BLBasico implements BL {

	private int peso;
	private List<String> tipoProducto;
	private List<Cliente> importador;
	
	public BLBasico(int peso,String tipoProducto, Cliente importador) {
		this.peso = peso;
		this.tipoProducto = List.of(tipoProducto);
		this.importador = List.of(importador);
	}

	@Override
	public List<String> getTipoProducto() {
		return tipoProducto;
	}

	@Override
	public List<Cliente> getImportador() {
		return importador;
	}

	@Override
	public double getPeso() {
		return peso;
	}
}