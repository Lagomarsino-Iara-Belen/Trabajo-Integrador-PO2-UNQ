package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.ArrayList;
import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class BLBasico implements BL {

	private Double peso;
	private ArrayList<String> tipoProducto;
	private ArrayList<Cliente> importador;
	
	public BLBasico(String tipoProducto, Double peso, Cliente importador) {
		this.peso = peso;
		this.tipoProducto = new ArrayList<>(List.of(tipoProducto));
		this.importador = new ArrayList<>(List.of(importador));
	}

	@Override
	public ArrayList<String> getTipoProducto() {
		return tipoProducto;
	}

	@Override
	public ArrayList<Cliente> getImportador() {
		return importador;
	}

	@Override
	public double getPeso() {
		return peso;
	}
}