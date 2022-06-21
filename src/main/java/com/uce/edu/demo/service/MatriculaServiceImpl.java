package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Override
	public void crear(String cedula, String placa) {
		// TODO Auto-generated method stub
		
		//Aqui para crear una matricula debo consultar en la base de datos
		//los vehiculos y propietarios, es por eso que se usa el buscar
		//pero lo que devuelve son datos de ejemplo
		Propietario p = this.propietarioService.buscar(cedula);
		Vehiculo v = this.vehiculoService.buscar(placa);
		
		Matricula m = new Matricula();
		m.setFechaMatricula(LocalDateTime.of(2022, 1,1,0,0));
		m.setPropietario(p);
		m.setVehiculo(v);
		
		//Calculo del valor de matricula
		BigDecimal nuevoValor = null;
		
		if (v.getTipo()=="P") {
			nuevoValor = v.getPrecio().multiply(new BigDecimal(12).divide(new BigDecimal(100)));
		}else if (v.getTipo()=="L") {
			nuevoValor = v.getPrecio().multiply(new BigDecimal(14).divide(new BigDecimal(100)));
		}
		
		//Si el valor de matricula es mayor a 2000
		if(nuevoValor.compareTo(new BigDecimal(2000))==1) {
			nuevoValor = nuevoValor.subtract(nuevoValor.multiply(new BigDecimal(7).divide(new BigDecimal(100))));
			System.out.println("Se ha aplicado un descuento del 7%!!");
		}
	
		m.setValorMatricula(nuevoValor);
		this.matriculaRepository.crear(m);
	
	}

	@Override
	public Matricula buscar(String cedula, String placa) {
		// TODO Auto-generated method stub
		return this.matriculaRepository.buscar(cedula, placa);
	}

	@Override
	public void actualizar(Matricula m) {
		// TODO Auto-generated method stub
		this.matriculaRepository.actualizar(m);
	}

	@Override
	public void eliminar(String cedula, String placa) {
		// TODO Auto-generated method stub
		this.matriculaRepository.eliminar(cedula, placa);
	}

}
