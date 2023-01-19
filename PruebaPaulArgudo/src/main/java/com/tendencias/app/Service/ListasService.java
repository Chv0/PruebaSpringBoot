package com.tendencias.app.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tendencias.app.Entity.Canciones;
import com.tendencias.app.Entity.ListasDeReproduccion;

@Service
public interface ListasService {

	public Iterable<ListasDeReproduccion> findAll();
	
	public Page<ListasDeReproduccion> findAll(Pageable pageable);
	
	public Optional<ListasDeReproduccion> findById(Integer Id);
	
	public ListasDeReproduccion save(Canciones user);
	
	public void deleteById(Integer Id);
}
