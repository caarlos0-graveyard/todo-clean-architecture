package todo.doubles;

import todo.models.Todo;
import todo.repositories.ListFilter;
import todo.repositories.PaginatedList;
import todo.repositories.TodoRepository;

public class TodoRepositorySpy implements TodoRepository {
	private boolean hasCreated;

	public boolean hasSaved() {
		return hasCreated;
	}

	@Override
	public Todo save(Todo todo) {
		hasCreated = true;
		return todo;
	}

	@Override
	public PaginatedList<Todo> list(ListFilter<Todo> filter) {
		return null;
	}
}
