package com.ej4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ej4.dao.ISalaDAO;
import com.ej4.dto.Sala;

@Service 
public class SalaServiceImpl implements ISalaService{

	@Autowired
	ISalaDAO iSalaDAO;
	
	@Override
	public List<Sala> listarSalas() {
		// TODO Auto-generated method stub
		return iSalaDAO.findAll();
	}

	@Override
	public Sala guardarSala(Sala Sala) {
		// TODO Auto-generated method stub
			return iSalaDAO.save(Sala); //guardo el nuevo Sala	
	}

	@Override
	public Sala salaXID(Long id) {
		// TODO Auto-generated method stub
		return iSalaDAO.findById(id).get();
	}

	@Override
	public Sala actualizarSala(Sala Sala) {
		// TODO Auto-generated method stub
		return iSalaDAO.save(Sala);
	}

	@Override
	public void eliminarSala(Long id) {
		iSalaDAO.deleteById(id);
		
	}
}
