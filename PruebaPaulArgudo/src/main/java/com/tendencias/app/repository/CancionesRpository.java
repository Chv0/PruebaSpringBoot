package com.tendencias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tendencias.app.Entity.Canciones;


public interface CancionesRpository extends JpaRepository<Canciones, Integer>{

}
