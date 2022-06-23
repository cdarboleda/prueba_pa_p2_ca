package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Propietario;
import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.service.IMatriculaGestorService;
import com.uce.edu.demo.service.IPropietarioService;
import com.uce.edu.demo.service.IVehiculoService;

@SpringBootApplication
public class PruebaPaP2CaApplication implements CommandLineRunner{

	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private IMatriculaGestorService matriculaGestorService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\n1. Crear un propietario");
		Propietario p = new Propietario();
		p.setNombre("Cristian");
		p.setApellido("Arboleda");
		p.setCedula("1751146786");
		this.propietarioService.crear(p);
		
		System.out.println("\n2. Crear un vehiculo");
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("Honda");
		vehiculo.setPlaca("PNK-047");
		vehiculo.setPrecio(new BigDecimal(10000));
		vehiculo.setTipo("L");
		vehiculo.setModelo("Modelo a");
		this.vehiculoService.crear(vehiculo);
		
		System.out.println("\n3. Actualizar un atributo");
		vehiculo.setMarca("Ford");
		this.vehiculoService.actualizar(vehiculo);
		
		System.out.println("\n4. Realizar una matricula");
		this.matriculaGestorService.generar("1751146786", "PNK-047");
	}

}
