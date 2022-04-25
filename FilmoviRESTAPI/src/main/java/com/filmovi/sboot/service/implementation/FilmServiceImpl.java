package com.filmovi.sboot.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmovi.sboot.model.Film;
import com.filmovi.sboot.repository.FilmRepository;
import com.filmovi.sboot.service.FilmService;
import com.filmovi.sboot.service.ReziserService;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

	private final FilmRepository filmRepo;
	
	@Autowired
	ReziserService rs;
	
	public FilmServiceImpl(FilmRepository filmRepo) {
		super();
		this.filmRepo = filmRepo;
	}

	@Override
	public Film saveFilm(Film film) {
		System.out.println(film.getReziser());
		rs.saveReziser(film.getReziser());
		return filmRepo.save(film);
	}

	@Override
	public List<Film> getAllFilmovi() {
		return filmRepo.findAll();
	}

	@Override
	public Film getFilmById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
