package com.uce.edu.demo.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Propietario;
@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@Override
	public void crear(Propietario p) {
		// TODO Auto-generated method stub
		System.out.println("Creando un propietario: " + p);
	}

	@Override
	public Propietario buscar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Buscando el propietario: " + cedula);
		
		//Datos de ejemplo porque no hay base de la cual retirar la informacion
		Propietario p = new Propietario();
		p.setNombre("Cristian");
		p.setApellido("Arboleda");
		p.setCedula("1751146786");
		return p;
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		System.out.println("Eliminando un propietario: " +cedula);
	}

}
