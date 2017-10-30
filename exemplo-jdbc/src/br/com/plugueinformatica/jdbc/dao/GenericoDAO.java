package br.com.plugueinformatica.jdbc.dao;

import java.util.List;

public interface GenericoDAO<T> {
	
	void inserir(T obj);
	void atualizar(T obj);
	void deletar(Integer id);
	List<T> listarTodos();
	T buscarPorId(Integer id);

}
