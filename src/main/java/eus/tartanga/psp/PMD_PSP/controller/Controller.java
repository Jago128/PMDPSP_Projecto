package eus.tartanga.psp.PMD_PSP.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eus.tartanga.psp.PMD_PSP.exceptions.WrongHashException;
import eus.tartanga.psp.PMD_PSP.model.*;
import eus.tartanga.psp.PMD_PSP.service.Service;

@RestController
@RequestMapping("/games")
public class Controller {
	private final Service service;

	public Controller(Service service) {
		this.service = service;
	}

	@GetMapping("/gameList")
	public ResponseEntity<ArrayList<Game>> getGames() {
		// ArrayList<Game> games = service.showGameList();

		return null;
	}

	@GetMapping("/gameIcon/{gameName}")
	public ResponseEntity<ArrayList<Game>> getGameIcon(@PathVariable String gameN) {
		// Method goes here

		return null;
	}

	@GetMapping("/game/{gameName}")
	public ResponseEntity<ArrayList<Game>> getGameApp(@PathVariable String gameN) {
		// Method goes here

		return null;
	}

	@GetMapping("/apkHash/{gameName}")
	public ResponseEntity<ArrayList<Game>> checkHash(@PathVariable String gameN, @PathVariable String hash) {
		try {
			if (service.checkHash(gameN, hash)) {
				return null;
			} else {
				return null;
			}
		} catch (WrongHashException e) {
			// Message is set, call e.getMessage();
			return null;
		}
	}

	@GetMapping("/gameRatingsAvg/{gameName}")
	public ResponseEntity<ArrayList<Reseña>> getGameRatingAverage() {
		// Method goes here

		return null;
	}

	@PostMapping("/addUser")
	public ResponseEntity<ArrayList<Game>> addUser(@PathVariable String nom, @PathVariable String email,
			@PathVariable String pass, @PathVariable String gender, @PathVariable String device) {

		try {
			if (service.addUser(nom, email, pass, gender, device)) {
				return null;
			} else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			// Needs a message for enum mistakes
			return null;
		}
	}

	@PostMapping("/addReview/{gameName}")
	public ResponseEntity<ArrayList<Game>> createReview(@PathVariable String nom, @PathVariable double rating,
			@PathVariable String gameN) {
		if (service.createReview(nom, rating, gameN)) {
			return null;
		} else {
			return null;
		}
	}
}
