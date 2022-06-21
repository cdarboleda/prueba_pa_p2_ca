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
	public void crear(String nombre, String apellido, String cedula) {
		// TODO Auto-generated method stub
		Propietario p = new Propietario();
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setCedula(cedula);
		
		this.propietarioRepository.crear(p);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.propietarioRepository.buscar(cedula);
	}

	@Override
	public void actualizar(Propietario p) {
		// TODO Auto-generated method stub
		this.propietarioRepository.actualizar(p);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioRepository.eliminar(cedula);
	}

}
