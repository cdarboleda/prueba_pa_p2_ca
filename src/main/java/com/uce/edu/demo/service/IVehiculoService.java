package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {
	public void crear(Vehiculo v);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo v);
	public void eliminar(String placa);
}
