package eus.tartanga.psp.PMD_PSP.model;

import java.io.File;
import java.util.ArrayList;

public class Game {

	private String nombre;
	private String descripcion;
	private double valoracion_media;
	private ArrayList<Reseña> reseñas;
	private File icon;
	// Apk
	private String hash;

	public Game(String nombre, String descripcion, double valoracion_media, File icon) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valoracion_media = valoracion_media;
		this.reseñas = new ArrayList<>();
		this.icon = icon;
		this.hash = "";
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

	public ArrayList<Reseña> getReseñas() {
		return reseñas;
	}

	public void setReseñas(ArrayList<Reseña> reseñas) {
		this.reseñas = reseñas;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	// method to set hash
	public void generateHash() {
		// Can't be done without APK
	}

	// method to set average rating
	public double getAvgRating() {
		double avg = 0;
		
		if (this.reseñas != null) {
			for (int i = 0; i < reseñas.size(); i++) {
				avg += reseñas.get(i).getValoracion()*10;
			}
		}

		if (avg == 0) {
			return -1;
		} else {
			return avg / reseñas.size();
		}
	}

	@Override
	public String toString() {
		return "Game [nombre=" + nombre + ", descripcion=" + descripcion + ", valoracion_media=" + valoracion_media
				+ ", reseñas=" + reseñas + ", hash=" + hash + "]";
	}
}
