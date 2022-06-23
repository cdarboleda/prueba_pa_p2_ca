package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.repository.IPropietarioRepository;

@Service
public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Override
	public void crear(Propietario pro) {
		// TODO Auto-generated method stub
		this.propietarioRepository.crear(pro);
	}


	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminar(cedula);
	}

}
