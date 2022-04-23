package com.filmovi.sboot.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.filmovi.sboot.model.Film;
import com.filmovi.sboot.repository.FilmRepository;
import com.filmovi.sboot.service.FilmService;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

	private final FilmRepository filmRepo;
	
	public FilmServiceImpl(FilmRepository filmRepo) {
		super();
		this.filmRepo = filmRepo;
	}

	@Override
	public Film saveFilm(Film film) {
		return filmRepo.save(film);
	}

	@Override
	public List<Film> getAllFilmovi() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film getFilmById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
