package com.filmovi.sboot.service;

import java.util.List;

import com.filmovi.sboot.model.Film;

public interface FilmService {
	Film saveFilm(Film film);
	List<Film> getAllFilmovi();
	Film getFilmById(Long id);
	Film updateFilm(Film film,Long id);
	void deleteFilm(Long id);
}
