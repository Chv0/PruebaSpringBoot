package com.tendencias.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tendencias.app.Entity.ListasDeReproduccion;
import com.tendencias.app.repository.ListasRepository;

@Service
public class ListaServiceImpl implements ListasService{
	@Autowired
	ListasRepository listas;

	@Override
	@Transactional(readOnly=true)
	public Iterable<ListasDeReproduccion> findAll() {
		// TODO Auto-generated method stub
		return listas.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<ListasDeReproduccion> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return listas.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<ListasDeReproduccion> findById(Integer Id) {
		// TODO Auto-generated method stub
		return listas.findById(Id);
	}

	@Override@Transactional
	public ListasDeReproduccion save(ListasDeReproduccion lista) {
		// TODO Auto-generated method stub
		return listas.save(lista);
	}

	@Override
	@Transactional(readOnly=true)
	public void deleteById(Integer Id) {
		listas.deleteById(Id);
		
	}
	
}
