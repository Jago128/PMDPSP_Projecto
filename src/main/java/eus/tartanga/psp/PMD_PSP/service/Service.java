package eus.tartanga.psp.PMD_PSP.service;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

import org.apache.commons.codec.digest.DigestUtils;

import eus.tartanga.psp.PMD_PSP.exceptions.EmailFormatException;
import eus.tartanga.psp.PMD_PSP.exceptions.WrongHashException;
import eus.tartanga.psp.PMD_PSP.model.*;

@org.springframework.stereotype.Service
public class Service {

	private ArrayList<Game> games = new ArrayList<>();
	private HashMap<String, User> users = new HashMap<>();

	public ArrayList<Game> showGameList() {
		if (games != null) {
			return games;
		} else {
			try {
				fillData();
				return games;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	private void fillData() {
		games.add(new Game("", "", 1, new File(""))); // Unset image file
	}

	public String getIcon(String gameN) throws IOException {
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getNombre().equalsIgnoreCase(gameN)) {
				return games.get(i).getIcon().getCanonicalPath();
			}
		}
		return null;
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = modelo.matcher(email);
		if (!matcher.matches()) {
			throw new EmailFormatException();
		}
	}

	public ArrayList<Reseña> getGameReviews(String gameN) {
		boolean exists = false;
		int index = 0;

		for (int i = 0; i < games.size() && !exists; i++) {
			if (games.get(i).getNombre().equalsIgnoreCase(gameN)) {
				exists = true;
				index = i;
			}
		}

		if (!exists) {
			return null;
		} else {
			return games.get(index).getReseñas();
		}
	}

	public boolean checkHash(String gameN, String hash) throws WrongHashException {
		boolean exists = false;
		Game game = null;

		for (int i = 0; i < games.size() && !exists; i++) {
			if (games.get(i).getNombre().equalsIgnoreCase(gameN)) {
				exists = true;
				game = games.get(i);
			}
		}

		if (!exists) {
			return false;
		} else {
			if (game.getHash().equals(hash)) {
				return true;
			} else {
				throw new WrongHashException("Ha occurido un error al descargar el juego.");
			}
		}
	}

	public double avgRatingGame(String name) {
		for (int i = 0; i < games.size(); i++) {
			if (games.get(i).getNombre().equalsIgnoreCase(name)) {
				return games.get(i).getValoracion_media();
			}
		}

		return -1;
	}

	public boolean addUser(String nom, String email, String pass, String genderSet, String deviceSet)
			throws IllegalArgumentException {
		boolean exists = false;
		Genero gender = null;
		Dispositivo device = null;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(nom).getNombre().equalsIgnoreCase(nom)) {
				exists = true;
			}
		}

		switch (genderSet) {
		case "Hombre":
			gender = Genero.HOMBRE;
			break;

		case "Mujer":
			gender = Genero.MUJER;
			break;

		case "Otro":
			gender = Genero.OTRO;
			break;

		default:
			throw new IllegalArgumentException();
		}

		switch (deviceSet) {
		case "Tablet":
			device = Dispositivo.TABLET;
			break;

		case "Movil":
			device = Dispositivo.MOVIL;
			break;

		default:
			throw new IllegalArgumentException();
		}

		if (nom.isBlank() || pass.isBlank() || genderSet == null || deviceSet == null || exists) {
			return false;
		} else {
			// Site for reference (para borrar en cuanto lo veas, Victor):
			// https://www.baeldung.com/sha-256-hashing-java
			String passHash = DigestUtils.sha256Hex(pass);
			users.put(nom, new User(nom, email, passHash, gender, device));
			return true;
		}
	}

	public boolean createReview(String review, double rating, String gameN) {
		boolean check = false;
		int index = 0;

		for (int i = 0; i < games.size() && !check; i++) {
			if (games.get(i).getNombre().equalsIgnoreCase(gameN)) {
				check = true;
				index = i;
			}
		}

		if (review.isBlank() || rating == 0 || !check) {
			return false;
		} else {
			games.get(index).getReseñas().add(new Reseña(review, rating));
			return true;
		}
	}
}
