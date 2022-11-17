package com.ej4.service;

import java.util.List;

import com.ej4.dto.Sala;

public interface ISalaService {

	//Métodos del CRUD
	public List<Sala> listarSalas(); //Listar salas
	
	public Sala guardarSala(Sala Sala); //Guarda una sala CREATE
	
	public Sala salaXID(Long id); //Leer datos de una sala READ
	
	public Sala actualizarSala(Sala Sala); //Actualiza datos sala UPDATE
	
	public void eliminarSala(Long id);//Elimina sala DELETE
}
