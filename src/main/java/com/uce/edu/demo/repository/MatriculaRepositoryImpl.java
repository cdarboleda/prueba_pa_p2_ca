package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@Override
	public void crear(Matricula m) {
		// TODO Auto-generated method stub
		System.out.println("Creando matricula: "+ m);
	}

	@Override
	public Matricula buscar(String cedula, String placa) {
		// TODO Auto-generated method stub
		System.out.println("Devolviendo matricula del propietario: "+ cedula +" y placa: "+ placa);
		
		//Datos de ejemplo porque no hay base de la cual retirar la informacion
		Propietario p = new Propietario();
		p.setNombre("Cristian");
		p.setApellido("Arboleda");
		p.setCedula("1751146786");
		
		Vehiculo v = new Vehiculo();
		v.setMarca("Honda");
		v.setModelo("ABC");
		v.setTipo("L");
		v.setPrecio(new BigDecimal(10000));
		v.setPlaca(placa);
		
		Matricula m = new Matricula();
		m.setPropietario(p);
		m.setVehiculo(v);
		m.setValorMatricula(new BigDecimal(2500));
		m.setFechaMatricula(LocalDateTime.of(2000, 1,1,0,0));
		return m;
	}

	@Override
	public void actualizar(Matricula m) {
		// TODO Auto-generated method stub
		System.out.println("Actualizando matricula: "+ m);
	}

	@Override
	public void eliminar(String cedula, String placa) {
		// TODO Auto-generated method stub
		System.out.println("Eliminando matricula: "+ placa);
	}

}
