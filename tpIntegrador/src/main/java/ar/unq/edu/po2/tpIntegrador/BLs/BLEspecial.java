package ar.unq.edu.po2.tpIntegrador.BLs;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.unq.edu.po2.tpIntegrador.Clientes.Cliente;

public class BLEspecial implements BL {
	
	private double peso;
	private ArrayList<String> tipoProducto;
	private ArrayList<BL> contenidos;
	private ArrayList<Cliente> clientes;
	
	public BLEspecial(ArrayList<String> tipoProducto, double peso, ArrayList<Cliente> clientes, ArrayList<BL> contenidos) {
		this.peso = peso;
		this.tipoProducto = tipoProducto;
		this.contenidos = contenidos;
		this.clientes = clientes;
	}

	@Override	
	public ArrayList<String> getTipoProducto() {
	    return Stream.concat(
	            tipoProducto.stream(),
	            contenidos.stream()
	                .flatMap(cont -> cont.getTipoProducto().stream())
	        )
	        .collect(Collectors.toCollection(ArrayList::new));
	}


	@Override
	public ArrayList<Cliente> getImportador() {
		 return Stream.concat(
		            clientes.stream(),
		            contenidos.stream()
		                .flatMap(cont -> cont.getImportador().stream())
		        )
		        .collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public double getPeso() {
		double cantAnterior = contenidos.stream().mapToDouble(cont -> cont.getPeso())
				  								 .sum();
		return peso + cantAnterior;
	}

	public ArrayList<BL> getBLs() {
		return this.contenidos;
	}
	
	public void addBL(BL bl) {
		this.contenidos.add(bl);
	}
	
	public void removeBL(BL bl) {
		this.contenidos.remove(bl);
	}
}
