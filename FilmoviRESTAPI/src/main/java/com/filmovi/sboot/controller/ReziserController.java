package com.filmovi.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmovi.sboot.model.Reziser;
import com.filmovi.sboot.service.ReziserService;

@RestController
@RequestMapping("/api/reziser")
public class ReziserController {

	private final ReziserService rs;
	
	public ReziserController(ReziserService rs) {
		super();
		this.rs = rs;
	}

	@PostMapping("/save")
	public ResponseEntity<Reziser> addReziser(@RequestBody Reziser reziser){
		return new ResponseEntity<Reziser>(rs.saveReziser(reziser),HttpStatus.CREATED);
	}

	@GetMapping
	public List<Reziser> getAllReziseri(){
		return rs.getAllReziseri();
	}
}
