package todo.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import todo.entities.Todo;

public class TodoMemoryPersistenceAdapter implements PersistenceAdapter<Todo> {
	private final AtomicLong sequence = new AtomicLong();
	private final List<Todo> todos = new ArrayList<>();

	@Override
	public Todo persist(Todo todo) {
		todo.setId(sequence.addAndGet(1));
		todo.setCreatedAt(new Date());
		todos.add(todo);
		return todo;
	}

	@Override
	public Todo update(Todo todo) {
		todo.setUpdatedAt(new Date());
		updateInList(todo);
		return todo;
	}

	@Override
	public List<Todo> list() {
		return new ArrayList<>(todos);
	}

	private void updateInList(Todo todo) {
		todos.remove(indexOf(todo));
		todos.add(todo);
	}

	private int indexOf(Todo todo) {
		for (int i = 0; i < todos.size(); i++)
			if (todos.get(i).getId().equals(todo.getId()))
				return i;
		return -1;
	}
}
