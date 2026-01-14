package eus.tartanga.psp.PMD_PSP.model;

public class Reseña {

	private String texto;
	private double valoracion;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Reseña [texto=" + texto + ", valoracion=" + valoracion + "]";
	}
}
