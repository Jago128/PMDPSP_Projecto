package eus.tartanga.psp.PMD_PSP.service;

import java.util.*;
import java.util.regex.*;

import org.apache.commons.codec.digest.DigestUtils;

import eus.tartanga.psp.PMD_PSP.exceptions.EmailFormatException;
import eus.tartanga.psp.PMD_PSP.model.*;

@org.springframework.stereotype.Service
public class Service {

	private ArrayList<Game> games = new ArrayList<>();
	private HashMap<String, User> users = new HashMap<>();

	public ArrayList<Game> showGameList() {
		if (games != null) {
			return games;
		} else {
			return null;
		}
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = modelo.matcher(email);
		if (!matcher.matches()) {
			throw new EmailFormatException();
		}
	}

	public ArrayList<Reseña> getGameReviews(Game game) {
		boolean exists = false;
		int index = 0;

		for (int i = 0; i < games.size() && !exists; i++) {
			if (game.equals(game)) {
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

	public boolean addUser(String nom, String email, String pass, Genero gender, Dispositivo device) {
		boolean exists = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(nom).getNombre().equalsIgnoreCase(nom)) {
				exists = true;
			}
		}

		if (nom.isBlank() || pass.isBlank() || gender == null || device == null || exists) {
			return false;
		} else {
			// Site for reference (para borrar en cuanto lo veas, Victor):
			// https://www.baeldung.com/sha-256-hashing-java
			String passHash = DigestUtils.sha256Hex(pass);
			users.put(nom, new User(nom, email, passHash, gender, device));
			return true;
		}
	}

	public boolean createReview(Game game, String review, double rating) {
		boolean check = false;
		int index = 0;

		for (int i = 0; i < games.size() && !check; i++) {
			if (game.equals(game)) {
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
