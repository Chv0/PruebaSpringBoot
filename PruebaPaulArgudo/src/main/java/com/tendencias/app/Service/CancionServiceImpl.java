package com.tendencias.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tendencias.app.Entity.Canciones;
import com.tendencias.app.repository.CancionesRpository;

@Service
public class CancionServiceImpl implements CancionesService{

	@Autowired
	CancionesRpository cancion;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Canciones> findAll() {
		// TODO Auto-generated method stub
		return cancion.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Canciones> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return cancion.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Canciones> findById(Integer Id) {
		// TODO Auto-generated method stub
		return cancion.findById(Id);
	}

	@Override
	@Transactional
	public Canciones save(Canciones canciones) {
		// TODO Auto-generated method stub
		return cancion.save(canciones);
	}

	@Override
	@Transactional
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		cancion.deleteById(Id);
	}

}
