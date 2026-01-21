package eus.tartanga.psp.PMD_PSP.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import eus.tartanga.psp.PMD_PSP.exceptions.EmailFormatException;
import eus.tartanga.psp.PMD_PSP.model.*;

@org.springframework.stereotype.Service
public class Service {

	private ArrayList<Game> games = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();

	public ArrayList<Game> showGameList() {
		return games;
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = modelo.matcher(email);
		if (!matcher.matches()) {
			throw new EmailFormatException();
		}
	}

	public boolean addUser(String nom, String email, String pass, Genero gender, Dispositivo device) {
		if (nom.isBlank() || pass.isBlank() || gender == null || device == null) {
			return false;
		} else {
			// Site for reference: https://www.baeldung.com/sha-256-hashing-java
			String passHash = DigestUtils.sha256Hex(pass);
			users.add(new User(nom, email, passHash, gender, device));
			return true;
		}
	}
}
