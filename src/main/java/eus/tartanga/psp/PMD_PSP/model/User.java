package eus.tartanga.psp.PMD_PSP.model;

public class User {

	private String nombre;
	private String email;
	private String contraseña;
	private Genero genero;
	private Dispositivo dispositivo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	@Override
	public String toString() {
		return "User [nombre=" + nombre + ", email=" + email + ", contraseña=" + contraseña + ", genero=" + genero
				+ ", dispositivo=" + dispositivo + "]";
	}
}
