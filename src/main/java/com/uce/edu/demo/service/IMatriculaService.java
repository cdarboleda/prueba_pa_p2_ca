package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.Matricula;

public interface IMatriculaService {
	public void crear(String cedula, String placa);
	public Matricula buscar(String cedula, String placa);
	public void actualizar(Matricula m);
	public void eliminar(String cedula, String placa);
}
