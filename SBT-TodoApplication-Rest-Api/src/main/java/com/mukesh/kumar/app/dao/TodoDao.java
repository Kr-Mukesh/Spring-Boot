package com.mukesh.kumar.app.dao;

import java.util.List;

import com.mukesh.kumar.app.model.Todos;

public interface TodoDao {

	public List<Todos> findAllTodos();
	public Todos findOneTodo(Long id);
	public Todos deleteTodo(Long id); 
	public Todos createTodo(Todos todos);
	public Todos updateTodo(Long id, Todos todos);
}
