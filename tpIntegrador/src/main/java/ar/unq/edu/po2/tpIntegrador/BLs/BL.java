package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public interface BL {
	public List<String> getTipoProducto();
	public List<Cliente> getImportador();
	public double getPeso();
}
