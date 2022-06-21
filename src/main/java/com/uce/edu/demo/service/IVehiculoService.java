package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.modelo.Vehiculo;

public interface IVehiculoService {
	public void crear(String marca, String modelo, String placa, String tipo, BigDecimal precio);
	public Vehiculo buscar(String placa);
	public void actualizar(Vehiculo v);
	public void eliminar(String placa);
}
