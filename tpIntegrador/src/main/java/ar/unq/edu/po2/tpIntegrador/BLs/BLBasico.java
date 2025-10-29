package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Consignee;

public class BLBasico implements BL {

	private int peso;
	private List<String> tipoProducto;
	private List<Consignee> importadores;
	
	public BLBasico(int peso, List<String> tipoProducto, List<Consignee> importadores) {
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.importadores = importadores;
	}

	@Override
	public List<String> getTipoProducto() {
		// TODO Auto-generated method stub
		return tipoProducto;
	}

	@Override
	public List<Consignee> getImportador() {
		// TODO Auto-generated method stub
		return importadores;
	}

	@Override
	public int getPeso() {
		// TODO Auto-generated method stub
		return peso;
	}
}