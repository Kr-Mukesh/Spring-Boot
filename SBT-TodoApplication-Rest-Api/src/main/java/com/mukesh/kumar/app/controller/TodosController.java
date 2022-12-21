package com.mukesh.kumar.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mukesh.kumar.app.dao.TodoDao;
import com.mukesh.kumar.app.model.Todos;

@RestController
@RequestMapping("/todos")
public class TodosController {

	@Autowired
	TodoDao todoDao;

	private Logger log = LoggerFactory.getLogger(TodosController.class);

	@PostMapping("/todos/create")
	public String createTask(@RequestBody Todos todos) {

		log.info("TodosController :- CreateTask Executed..");

		todos = todoDao.createTodo(todos);

		return todos.getTaskId() != null ? "New TODO Created With Id :" + todos.getTaskId() : "TODO Not Created";
	}

	@GetMapping("/")
	public List<Todos> findAll() {

		log.info("TodosController :- findAll Executed..");

		return todoDao.findAllTodos();
	}

	@GetMapping("/{id}")
	public Todos findOneTodo(@PathVariable Long id) {
		log.info("TodosController :- findOneTodo Executed..");
		Todos todos = todoDao.findOneTodo(id);

		return todos;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTodo(@PathVariable Long id) {
		log.info("TodosController :- deleteOneTodo Executed..");

		Todos todos = todoDao.deleteTodo(id);

		return todos.getTaskId() != null ? "TODO Deleted With Id :" + todos.getTaskId() : "TODO Not Deleted";
	}

	@PutMapping("/update/{id}")
	public String updateOneTodo(@PathVariable Long id, @RequestBody Todos newTodo) {

		Todos todos = todoDao.updateTodo(id, newTodo);

		return todos.getTaskId() != null ? "TODO Updated With Id :" + todos.getTaskId() : "TODO Not Updated";
	}
}
