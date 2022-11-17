package com.ej4.controller;

import java.util.List;
import com.ej4.dto.Sala;
import com.ej4.service.SalaServiceImpl;

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
public class SalaController {

	@Autowired
	SalaServiceImpl SalaServiceImpl;
	
	//listar salas
	@GetMapping("/salas")
	public List<Sala> listarSalas(){
		return SalaServiceImpl.listarSalas();
	}
	
	//guardar sala
	@PostMapping("/salas")
	public Sala salvarSala(@RequestBody Sala sala) {
		return SalaServiceImpl.guardarSala(sala);
	}
	
	//mostrar sala por ID
	@GetMapping("/salas/{id}") 
	public Sala SalaXID(@PathVariable(name="id") Long id){ 
		Sala salaID = new Sala();
		
		salaID=SalaServiceImpl.salaXID(id);

		System.out.println("Sala XID: "+salaID);
		
		return salaID;
	}
	
	//actualizar sala ID
	@PutMapping("/salas/{id}")
	public Sala actualizarSala(@PathVariable(name="id")Long id,@RequestBody Sala sala) {
		
		Sala sala_select= new Sala();
		Sala sala_act= new Sala();
		
		sala_select= SalaServiceImpl.salaXID(id);
		
		sala_select.setNombre(sala.getNombre());
		sala_select.setPelicula(sala.getPelicula());
		
		sala_act = SalaServiceImpl.actualizarSala(sala_select);
		
		System.out.println("Sala actualizada es: "+ sala_act);
		
		return sala_act;
	}
	
	//eliminar sala por ID
	@DeleteMapping("/salas/{id}")
	public void eleiminarSala(@PathVariable(name="id")Long id) {
		SalaServiceImpl.eliminarSala(id);
	}
}
