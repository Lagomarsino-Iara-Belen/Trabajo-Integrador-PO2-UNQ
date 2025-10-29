package ar.unq.edu.po2.tpIntegrador.Containers;

public abstract class Container {
	
	private String id;
	private int ancho;
	private int largo;
	private int altura;
	private int peso;
	private boolean desconsolidado;
	
	public Container(String id, int ancho, int largo, int altura, int peso, boolean desconsolidado) {
		this.id = id;
		this.ancho = ancho;
		this.largo = largo;
		this.altura = altura;
		this.peso = peso;
		this.desconsolidado = desconsolidado;
	}
	
	public String getId() {
		return id;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getLargo() {
		return largo;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getMetroCubico() {
		return this.getAltura() * this.getAncho() * this.getLargo();
	}
	
	public int getPeso() {
		return peso;
	}
	
	public boolean getEsDesconsolidado() {
		return desconsolidado;
	}
}
