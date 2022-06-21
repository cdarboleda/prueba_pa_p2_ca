package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.Matricula;

public interface IMatriculaRepository {
	public void crear(Matricula m);
	public Matricula buscar(String cedula, String placa);
	public void actualizar(Matricula m);
	public void eliminar(String cedula, String placa);
}
