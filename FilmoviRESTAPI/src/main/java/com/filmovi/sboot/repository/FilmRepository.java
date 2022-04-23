package com.filmovi.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmovi.sboot.model.Film;

public interface FilmRepository extends JpaRepository<Film,Long>{

}
