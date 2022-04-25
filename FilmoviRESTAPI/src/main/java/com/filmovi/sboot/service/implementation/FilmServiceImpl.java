package com.filmovi.sboot.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmovi.sboot.exception.ResourceNotFoundException;
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
		Optional<Film> film = filmRepo.findById(id);
		if(film.isEmpty()) {
			throw new ResourceNotFoundException("Film","id",id);
		}else {
			return film.get();
		}
	}

	@Override
	public Film updateFilm(Film newFilm, Long id) {
		Film f = filmRepo.findById(id).get();
		if(f != null) {
			f.setNaziv(newFilm.getNaziv());
			f.setTrajanje(newFilm.getTrajanje());
			f.setGodinaIzdanja(newFilm.getGodinaIzdanja());
			f.setZanr(newFilm.getZanr());
			filmRepo.save(f);
			return f;
		}else {
			throw new ResourceNotFoundException("Film","id",id);
		}
	}

}
