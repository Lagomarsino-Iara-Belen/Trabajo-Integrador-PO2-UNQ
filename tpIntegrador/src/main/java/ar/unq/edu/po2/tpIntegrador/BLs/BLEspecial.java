package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class BLEspecial implements BL {
	
	private List<BL> contenidos;
	
	public BLEspecial(List<BL> contenidos) {
		this.contenidos = contenidos;
	}

	@Override	
	public List<String> getTipoProducto() {
	    return this.contenidos.stream()
	    		.map(bl -> bl.getTipoProducto())
	    		.reduce((new ArrayList<String>()), (accum, rec) -> Stream.concat(accum.stream(), rec.stream()).toList());
	}

	@Override
	public List<Cliente> getImportador() {
		 return this.contenidos.stream()
		    		.map(bl -> bl.getImportador())
		    		.reduce((new ArrayList<Cliente>()), (accum, rec) -> Stream.concat(accum.stream(), rec.stream()).toList());
	}

	@Override
	public double getPeso() {
		return this.contenidos.stream().mapToDouble(cont -> cont.getPeso()).sum();
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
