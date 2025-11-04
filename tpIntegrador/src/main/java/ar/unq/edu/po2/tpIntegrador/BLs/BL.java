package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.ArrayList;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public interface BL {
	public ArrayList<String> getTipoProducto();
	public ArrayList<Cliente> getImportador();
	public double getPeso();
}
