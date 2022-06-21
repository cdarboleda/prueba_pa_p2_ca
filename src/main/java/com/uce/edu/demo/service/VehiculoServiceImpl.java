package com.uce.edu.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.Vehiculo;
import com.uce.edu.demo.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	@Override
	public void crear(String marca, String modelo, String placa, String tipo, BigDecimal precio) {
		// TODO Auto-generated method stub
		Vehiculo v = new Vehiculo();
		v.setMarca(marca);
		v.setModelo(modelo);
		v.setPlaca(placa);
		v.setPrecio(precio);
		v.setTipo(tipo);
		this.vehiculoRepository.crear(v);
	}

	@Override
	public Vehiculo buscar(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.buscar(placa);
	}

	@Override
	public void actualizar(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.actualizar(v);
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoRepository.eliminar(placa);
	}

}
