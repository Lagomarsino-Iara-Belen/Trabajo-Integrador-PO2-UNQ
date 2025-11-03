package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;
import ar.unq.edu.po2.tpIntegrador.Clientes.Consignee;

public class BLEspecial implements BL {
	
	private List<BL> contenidos;
	private Cliente consignee;
	
	public BLEspecial()

	@Override
	public List<String> getTipoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consignee> getImportador() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPeso() {
		return 0;
	}

}
