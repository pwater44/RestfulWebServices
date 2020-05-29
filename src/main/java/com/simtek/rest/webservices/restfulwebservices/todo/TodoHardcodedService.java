package com.simtek.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "Rithwik", "Pay mortgage", new Date(), false));
		todos.add(new Todo(++idCounter, "Rithwik", "Walk Dog", new Date(), false));
		todos.add(new Todo(++idCounter, "Rithwik", "Create a product", new Date(), false));
	}
	
	public List<Todo> findAll() {
		return todos;
	}
	
	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);			
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null) return null;
		if (todos.remove(todo)) {
			return todo;
		}
		return null;
	}
	
	public Todo findById(long id) {
		for (Todo todo: todos) {
			System.out.println("findById = " + id);
			if (todo.getId() == id) {
				System.out.println("description = " + todo.getDescription());
				return todo;
			}
		}
		return null;
	}
	
}
