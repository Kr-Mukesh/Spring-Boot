//package com.mukesh.kumar.app.repository;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.mukesh.kumar.app.model.Todos;
//
//@Component
//public class TodoRepository {
//
//	private static List<Todos> todoList;
//
//	public TodoRepository() {
//
//		todoList = new ArrayList<>();
//		
//		todoList.add(new Todos(101L, "Create UI Page", "create User Registration Page", "Active", new Date(), null));
//		todoList.add(new Todos(102L, "Create Database", "create database in Oracle Db", "Active", new Date(), null));
//		todoList.add(
//				new Todos(103L, "Access Payment Api", "Use Payment Api to accept payment ", "Active", new Date(), null));
//		todoList.add(new Todos(104L, "Create Login Api", "create Api Login Page", "Active", new Date(), null));
//	}
//
//	public List<Todos> findAll() {
//
//		return todoList;
//	}
//
//	public Todos findOne(Long id) {
//
//		for(Todos todos : todoList) {
//			if(todos.getTaskId().equals(id)) {
//				return todos;
//			}
//			
//		}
//		return new Todos();
//	}
//
//	public String deleteOne(Long id) {
//
//		for(Todos todos : todoList) {
//			if(todos.getTaskId().equals(id)) {
//				todoList.remove(todos);
//				return "Todos deleted successfully! With Id : "+id;
//			}
//		
//		}
//		return "Fail to Delete !";
//	}
//
//	public String update(Long id, Todos newTodos) {
//
//		for(Todos oldTodo : todoList) {
//		if(oldTodo.getTaskId().equals(id)) {
//			oldTodo.setTitle(newTodos.getTitle()!=null?newTodos.getTitle():oldTodo.getTitle());
//			oldTodo.setDescription(newTodos.getDescription()!=null?newTodos.getDescription():oldTodo.getDescription());
//			oldTodo.setCompleted(newTodos.getCompleted()!=null?newTodos.getCompleted():oldTodo.getCompleted());
//			oldTodo.setUpdatedDate(new Date());
//			
//			return "Todos update for id : "+id;
//		}
//		}
//		return "Todos Failed to Update For Id : "+newTodos.getTaskId();
//	}
//
//	public String createTask(Todos todos) {
//
//		todoList.add(todos);
//
//		return "Successfully new task added with id : "+todos.getTaskId();
//	}
//
//}
