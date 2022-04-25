package com.filmovi.sboot.service.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.filmovi.sboot.model.Reziser;
import com.filmovi.sboot.repository.ReziserRepository;
import com.filmovi.sboot.service.ReziserService;

@Service
@Transactional
public class ReziserServiceImpl implements ReziserService {

	ReziserRepository reziserRepository;
	
	
	public ReziserServiceImpl(ReziserRepository reziserRepository) {
		super();
		this.reziserRepository = reziserRepository;
	}



	@Override
	public Reziser saveReziser(Reziser reziser) {
		return reziserRepository.save(reziser);
	}
	
}
