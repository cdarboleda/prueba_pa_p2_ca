package com.uce.edu.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.service.IMatriculaService;
import com.uce.edu.demo.service.IPropietarioService;
import com.uce.edu.demo.service.IVehiculoService;

@SpringBootApplication
public class PruebaPaP2CaApplication implements CommandLineRunner{

	@Autowired
	private IVehiculoService vehiculoService;
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private IMatriculaService matriculaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaPaP2CaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("\n1. Crear un propietario");
		this.propietarioService.crear("Cristian", "Arboleda", "1751146786");
		
		System.out.println("\n2. Crear un vehiculo");
		this.vehiculoService.crear("Honda", "ABC","PNK-047","L", new BigDecimal(10000));
		
		System.out.println("\n3. Actualizar un atributo");
		Vehiculo nuevoVehi = this.vehiculoService.buscar("PNK-047");
		nuevoVehi.setMarca("Ford");
		this.vehiculoService.actualizar(nuevoVehi);
		
		System.out.println("\n4. Realizar una matricula");
		this.matriculaService.crear("1751146786", "PNK-047");
	}

}
