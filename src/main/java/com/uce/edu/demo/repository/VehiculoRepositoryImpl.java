package com.uce.edu.demo.repository;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.Vehiculo;
@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository{

	@Override
	public void crear(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se ha creado un vehículo!"+ v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Devolviendo vehículo de cedula: "+ placa);
		
		//Datos de ejemplo porque no hay base de la cual retirar la informacion
		Vehiculo v = new Vehiculo();
		v.setMarca("Honda");
		v.setModelo("ABC");
		v.setTipo("L");
		v.setPrecio(new BigDecimal(10000));
		v.setPlaca(placa);
		return v;
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		System.out.println("Se ha actualizado un vehículo!"+ v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		System.out.println("Se ha eliminado el vehículo: "+ placa);
	}

}
