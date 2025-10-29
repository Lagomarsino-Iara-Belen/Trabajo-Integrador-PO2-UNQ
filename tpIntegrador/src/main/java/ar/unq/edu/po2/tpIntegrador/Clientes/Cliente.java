package ar.unq.edu.po2.tpIntegrador.Clientes;

public abstract class Cliente {
	private String nombre;
	private String mail;
	
	public Cliente(String nombre, String mail) {
		this.nombre = nombre;
		this.mail = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getMail() {
		return mail;
	}
	
	
}
