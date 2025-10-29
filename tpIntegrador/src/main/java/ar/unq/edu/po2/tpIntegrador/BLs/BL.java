package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.List;
import ar.unq.edu.po2.tpIntegrador.Clientes.Consignee;

public interface BL {
	public List<String> getTipoProducto();
	public List<Consignee> getImportador();
	public int getPeso();
}
