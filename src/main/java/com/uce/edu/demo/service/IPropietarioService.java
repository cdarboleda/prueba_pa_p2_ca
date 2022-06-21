package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Propietario;

public interface IPropietarioService {
	public void crear(String nombre, String apellido, String cedula);
	public Propietario buscar(String cedula);
	public void actualizar(Propietario p);
	public void eliminar(String cedula);
}
