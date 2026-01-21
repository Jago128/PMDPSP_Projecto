package eus.tartanga.psp.PMD_PSP.model;

import java.util.ArrayList;

public class Game {

	private String nombre;
	private String descripcion;
	private double valoracion_media;
	private String aviso;
	private ArrayList<Reseña> reseñas;
	
	public Game() {
		this.nombre = "";
		this.descripcion = "";
		this.valoracion_media = 0;
		this.aviso = "";
		this.reseñas = new ArrayList<>();
	}

	public Game(String nombre, String descripcion, double valoracion_media, String aviso, ArrayList<Reseña> reseñas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valoracion_media = valoracion_media;
		this.aviso = aviso;
		this.reseñas = reseñas;
	}

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

	public ArrayList<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(ArrayList<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	@Override
	public String toString() {
		return "Game [nombre=" + nombre + ", descripcion=" + descripcion + ", valoracion_media=" + valoracion_media
				+ ", aviso=" + aviso + ", reseña=" + reseñas + "]";
	}
}
