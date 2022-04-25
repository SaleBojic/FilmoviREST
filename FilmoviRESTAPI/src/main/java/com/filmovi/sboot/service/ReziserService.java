package com.filmovi.sboot.service;

import java.util.List;

import com.filmovi.sboot.model.Reziser;

public interface ReziserService {
	Reziser saveReziser(Reziser reziser);
	List<Reziser> getAllReziseri();
}
