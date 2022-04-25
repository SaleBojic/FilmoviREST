package com.filmovi.sboot.service.implementation;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.filmovi.sboot.exception.ResourceNotFoundException;
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



	@Override
	public List<Reziser> getAllReziseri() {
		return reziserRepository.findAll();
	}



	@Override
	public Reziser getReziserById(Long id) {
		Optional<Reziser> r = reziserRepository.findById(id);
		if(r.isPresent()) {
			return r.get();
		}else {
			throw new ResourceNotFoundException("Reziser", "id", id);
		}
	}
	
}
