package com.ej4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ej4.dto.Pelicula;

public interface IPeliculaDAO extends JpaRepository<Pelicula, Long>{

}
