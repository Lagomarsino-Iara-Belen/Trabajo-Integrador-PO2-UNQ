package ar.unq.edu.po2.tpIntegrador.EmpresaTransportista;

import ar.unq.edu.po2.tpIntegrador.Terminal.Terminal;

public class Camion {
	
	private String modelo;

	public Camion(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void cargar(Terminal terminal) {
		// Es figurativo, nos sirve para el mockito!
	}

	public void descargar(Terminal terminal) {
		// Es figurativo, nos sirve para el mockito!
	}
	
}
