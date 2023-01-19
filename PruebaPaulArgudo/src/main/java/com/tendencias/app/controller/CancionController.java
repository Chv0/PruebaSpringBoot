package com.tendencias.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.tendencias.app.Entity.Canciones;
import com.tendencias.app.Service.CancionesService;

@RestController
@RequestMapping("/api/cancion")
public class CancionController {
	@Autowired
	private CancionesService canc;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Canciones user){
		return ResponseEntity.status(HttpStatus.CREATED) .body(canc.save(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") Integer Id){
		Optional<Canciones> user=canc.findById(Id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Canciones cancion, @PathVariable(value = "id") Integer userId){
		Optional<Canciones> canci = canc.findById(userId);
		
		if(!canci.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		canci.get().setNombre(cancion.getNombre());
		canci.get().setAlbum(cancion.getAlbum());
		canci.get().setAnio(cancion.getAnio());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(canc.save(canci.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Integer userId){
		
		if (!canc.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		canc.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Canciones> readAll() {
		
		List<Canciones> user = StreamSupport.stream(canc.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return user;
	}
	
}
