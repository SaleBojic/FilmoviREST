package com.filmovi.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmovi.sboot.model.Film;
import com.filmovi.sboot.service.FilmService;
import com.filmovi.sboot.service.ReziserService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	private FilmService filmService;

	public FilmController(FilmService filmService,ReziserService reziserService) {
		super();
		this.filmService = filmService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<Film> addFilm(@RequestBody Film film){
		System.out.println(film);
		System.out.println("-----------------------------------");
		System.out.println(film.getReziser());
		return new ResponseEntity<Film>(filmService.saveFilm(film),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Film> getAllFilmovi(){
		return filmService.getAllFilmovi();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable(name="id") long id) {
		return new ResponseEntity<Film>(filmService.getFilmById(id),HttpStatus.OK); 
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Film> updateFilm( @PathVariable(name="id") long id ,@RequestBody Film film){
		return new ResponseEntity<Film>(filmService.updateFilm(film, id),HttpStatus.OK);
	}
	
}
