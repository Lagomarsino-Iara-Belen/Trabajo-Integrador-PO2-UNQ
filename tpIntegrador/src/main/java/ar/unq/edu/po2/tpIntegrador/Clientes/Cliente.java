package ar.unq.edu.po2.tpIntegrador.Clientes;

public class Cliente {
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

	public void recibirMail() {
		// Es figurativo, nos sirve para el mockito!
	}
}
