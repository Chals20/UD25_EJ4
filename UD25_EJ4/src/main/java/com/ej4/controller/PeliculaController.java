package com.ej4.controller;

import java.util.List;
import com.ej4.dto.Pelicula;
import com.ej4.service.PeliculaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PeliculaController {

	@Autowired
	PeliculaServiceImpl PeliculaServiceImpl;
	
	//listar pelis
	@GetMapping("/peliculas")
	public List<Pelicula> listarPeliculas(){
		return PeliculaServiceImpl.listarPeliculas();
	}
	
	//guardar pelicula
	@PostMapping("/peliculas")
	public Pelicula salvarPelicula(@RequestBody Pelicula peli) {
		return PeliculaServiceImpl.guardarPelicula(peli);
	}
	
	//mostrar pelicula por ID
	@GetMapping("/peliculas/{id}") 
	public Pelicula PeliculaXID(@PathVariable(name="id") Long id){ // 
		Pelicula peliID = new Pelicula();
		
		peliID=PeliculaServiceImpl.peliculaXID(id);

		System.out.println("Pelicula XID: "+peliID);
		
		return peliID;
	}
	
	//actualizar pelicula por ID
	@PutMapping("/peliculas/{id}")
	public Pelicula actualizarPelicula(@PathVariable(name="id")Long id,@RequestBody Pelicula peli) {
		
		Pelicula peli_select= new Pelicula();
		Pelicula peli_act= new Pelicula();
		
		peli_select= PeliculaServiceImpl.peliculaXID(id);
		
		peli_select.setNombre(peli.getNombre());
		peli_select.setCalificacion_edad(peli.getCalificacion_edad());
		peli_select.setSala(peli.getSala());
		
		peli_act = PeliculaServiceImpl.actualizarPelicula(peli_select);
		
		System.out.println("Pelicula actualizada es: "+ peli_act);
		
		return peli_act;
	}
	
	//eliminar sala ID
	@DeleteMapping("/peliculas/{id}")
	public void eleiminarPelicula(@PathVariable(name="id")Long id) {
		PeliculaServiceImpl.eliminarPelicula(id);
	}
}
