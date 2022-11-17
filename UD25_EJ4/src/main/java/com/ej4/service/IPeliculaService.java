package com.ej4.service;

import java.util.List;

import com.ej4.dto.Pelicula;

public interface IPeliculaService {

	//Métodos del CRUD
	public List<Pelicula> listarPeliculas(); //Listar pelis
	
	public Pelicula guardarPelicula(Pelicula Pelicula); //Guarda pelicula CREATE
	
	public Pelicula peliculaXID(Long id); //Leer datos pelicula READ
	
	public Pelicula actualizarPelicula(Pelicula Pelicula); //Actualiza datos pelicula UPDATE
	
	public void eliminarPelicula(Long id);//Elimina pelicula DELETE
	
}
