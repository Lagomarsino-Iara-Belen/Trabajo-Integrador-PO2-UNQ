package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class BLEspecial implements BL {
	
	private double peso;
	private List<String> tipoProducto;
	private List<BL> contenidos;
	private List<Cliente> clientes;
	
	public BLEspecial(List<String> tipoProducto, double peso, List<Cliente> clientes, List<BL> contenidos) {
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.contenidos = contenidos;
		this.clientes = clientes;
	}

	@Override
	public List<String> getTipoProducto() {
		return this.tipoProducto;
	}

	@Override
	public List<Cliente> getImportador() {
		return this.clientes;
	}

	@Override
	public double getPeso() {
		return this.peso;
	}

	public List<BL> getBLs() {
		return this.contenidos;
	}
	
	public void addBL(BL bl) {
		this.contenidos.add(bl);
	}
	
	public void removeBL(BL bl) {
		this.contenidos.remove(bl);
	}
}
