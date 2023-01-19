package com.tendencias.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tendencias.app.Entity.Canciones;

@Service
public interface CancionesService {
	public Iterable<Canciones> findAll();
	
	public Page<Canciones> findAll(Pageable pageable);
	
	public Optional<Canciones> findById(Integer Id);
	
	public Canciones save(Canciones canciones);
	
	public void deleteById(Integer Id);
}
