package eus.tartanga.psp.PMD_PSP.model;

public class Game {
	
	private String nombre;
	private String descripcion;
	private double valoracion_media;
	private String aviso;
	private Reseña reseña;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getValoracion_media() {
		return valoracion_media;
	}
	public void setValoracion_media(double valoracion_media) {
		this.valoracion_media = valoracion_media;
	}
	public String getAviso() {
		return aviso;
	}
	public void setAviso(String aviso) {
		this.aviso = aviso;
	}
	public Reseña getReseña() {
		return reseña;
	}
	public void setReseña(Reseña reseña) {
		this.reseña = reseña;
	}
	@Override
	public String toString() {
		return "Game [nombre=" + nombre + ", descripcion=" + descripcion + ", valoracion_media=" + valoracion_media
				+ ", aviso=" + aviso + ", reseña=" + reseña + "]";
	}
}
