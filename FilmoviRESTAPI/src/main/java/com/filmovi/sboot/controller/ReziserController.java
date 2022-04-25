package com.filmovi.sboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return new ResponseEntity<>(rs.saveReziser(reziser),HttpStatus.CREATED);
	}

	@GetMapping
	public List<Reziser> getAllReziseri(){
		return rs.getAllReziseri();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Reziser> getReziserById(@PathVariable(name="id") long id) {
		return new ResponseEntity<>(rs.getReziserById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Reziser> updateReziser(@PathVariable(name="id") long id, 
													@RequestBody Reziser reziser){
		return new ResponseEntity<>(rs.updateReziser(reziser,id),HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteReziser(@PathVariable(name="id") long id){
		rs.deletReziser(id);
		return new ResponseEntity<>("REziser with id:" + id + " successfully deleted",HttpStatus.OK);
	}
}
