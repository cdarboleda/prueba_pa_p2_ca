package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Matricula;
import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IMatriculaRepository;
import com.uce.edu.demo.repository.IPropietarioRepository;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class MatriculaGestorServiceImpl implements IMatriculaGestorService{

	@Autowired
	private IPropietarioRepository propietarioRepository;
	
	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaService matriculaServicePesado;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaService matriculaServiceLiviano;
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		
		//Aqui para crear una matricula debo consultar en la base de datos
		//los vehiculos y propietarios, es por eso que se usa el buscar
		//pero lo que devuelve son datos de ejemplo
		Propietario p = this.propietarioRepository.buscar(cedula);
		Vehiculo v = this.vehiculoRepository.buscar(placa);
		
		Matricula m = new Matricula();
		m.setFechaMatricula(LocalDateTime.now());
		m.setPropietario(p);
		m.setVehiculo(v);
		
		//Calculo del valor de matricula
		BigDecimal nuevoValor = null;
		
		if (v.getTipo()=="P") {
			nuevoValor = this.matriculaServicePesado.calcular(v.getPrecio());
		}else if (v.getTipo()=="L") {
			nuevoValor = this.matriculaServiceLiviano.calcular(v.getPrecio());
		}
		
		//Si el valor de matricula es mayor a 2000
		if(nuevoValor.compareTo(new BigDecimal(2000))>0) {
			nuevoValor = nuevoValor.subtract(nuevoValor.multiply(new BigDecimal(7).divide(new BigDecimal(100))));
			System.out.println("Se ha aplicado un descuento del 7%!!");
		}
	
		m.setValorMatricula(nuevoValor);
		this.matriculaRepository.crear(m);
	
	}


}
