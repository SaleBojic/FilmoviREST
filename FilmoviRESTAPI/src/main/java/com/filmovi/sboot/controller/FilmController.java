package com.filmovi.sboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmovi.sboot.model.Film;
import com.filmovi.sboot.service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	
	private FilmService filmService;

	public FilmController(FilmService filmService) {
		super();
		this.filmService = filmService;
	}
	
	@PostMapping
	public ResponseEntity<Film> addFilm(@RequestBody Film film){
		return new ResponseEntity<Film>(filmService.saveFilm(film),HttpStatus.CREATED);
	}
	
	
	
}
