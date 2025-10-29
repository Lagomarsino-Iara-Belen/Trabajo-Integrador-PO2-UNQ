package ar.unq.edu.po2.tpIntegrador.Containers;

import ar.unq.edu.po2.tpIntegrador.BLs.BLBasico;

public class ContainerReefer extends Container {

	private BLBasico contenido;
	
	public ContainerReefer(String id, int ancho, int largo, int altura, int peso, boolean desconsolidado, BLBasico contenido) {
		super(id, ancho, largo, altura, peso, desconsolidado);
		this.contenido = contenido;
	}

	public BLBasico getContenido() {
		return contenido;
	}
	
}
