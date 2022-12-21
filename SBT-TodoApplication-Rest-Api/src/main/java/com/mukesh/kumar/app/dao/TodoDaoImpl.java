package com.mukesh.kumar.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mukesh.kumar.app.model.Todos;

@Repository
public class TodoDaoImpl implements TodoDao {

	private Logger log = LoggerFactory.getLogger(TodoDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Todos> findAllTodos() {

		List<Todos> todoList = new ArrayList<>();

		try {
			log.info("TodoDaoImpl : executed findAllTodos()");

			String queryString = "SELECT * FROM TBL_TODOS";

			todoList = jdbcTemplate.query(queryString, BeanPropertyRowMapper.newInstance(Todos.class));

			return todoList;
		} catch (Exception e) {
			log.info("TodoDaoImpl : error in findAllTodos()", e.getCause());
		}
		return todoList;
	}

	@Override
	public Todos findOneTodo(Long id) {

		Todos todo = new Todos();

		try {
			log.info("TodoDaoImpl : executed findOneTodo()");

			String queryString = "SELECT * FROM TBL_TODOS WHERE TASK_ID=?";

			todo = jdbcTemplate.queryForObject(queryString, BeanPropertyRowMapper.newInstance(Todos.class), id);

			return todo;
		} catch (Exception e) {
			log.info("TodoDaoImpl : error in findOneTodo()", e.getCause());
		}
		return todo;
	}

	@Override
	public Todos deleteTodo(Long id) {

		Todos todo = findOneTodo(id);

		try {
			log.info("TodoDaoImpl : executed deleteTodo()");

			String queryString = "DELETE FROM TBL_TODOS WHERE TASK_ID=?";
			if (todo.getTaskId() != null) {

				int status = jdbcTemplate.update(queryString);
			
				if(status>0) {
					return todo;
				}else {
					return new Todos();
				}
			}

		} catch (Exception e) {
			log.info("TodoDaoImpl : error in deleteTodo()", e.getCause());
		}
		return todo;
	}

	@Override
	public Todos createTodo(Todos todos) {

		Long id = Math.abs(new Random().nextLong());
		todos.setTaskId(Long.valueOf(String.valueOf(id).substring(1, 4)));

		try {
			log.info("TodoDaoImpl : executed createTodo()");

			String queryString = "insert into tbl_Todos(TASK_ID, TITLE, DESCRIPTION, COMPLETED, ASSIGNED_DATE) values(?,?,?,?,sysdate)";
			int status = jdbcTemplate.update(queryString, todos.getTaskId(), todos.getTitle(), todos.getDescription(),
					todos.getCompleted());

			if (status > 0) {
				log.info("TodoDaoImpl : " + todos + " new resource created in db!");
				return todos;
			} else {
				log.info("TodoDaoImpl : " + todos + " unable to create in db!");
			}
		} catch (Exception e) {
			log.info("TodoDaoImpl : error in createTodo()", e.getCause());
		}
		return new Todos();
	}

	@Override
	public Todos updateTodo(Long id, Todos todos) {
		try {
			log.info("TodoDaoImpl : executed createTodo()");
			todos.setTaskId(id);
			
			String queryString = "update tbl_Todos set TITLE=?, DESCRIPTION=?, COMPLETED=?, ASSIGNED_DATE=sysdate where TASK_ID=?";
			int status = jdbcTemplate.update(queryString, todos.getTitle(), todos.getDescription(),
					todos.getCompleted(), id);

			if (status > 0) {
				log.info("TodoDaoImpl : " + todos + " new resource created in db!");
				return findOneTodo(id);
			} else {
				log.info("TodoDaoImpl : " + todos + " unable to create in db!");
			}
		} catch (Exception e) {
			log.info("TodoDaoImpl : error in createTodo()", e.getCause());
		}
		return new Todos();
	}

}
