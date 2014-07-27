package todo.api.doubles;

import todo.api.models.Todo;
import todo.api.repositories.ListFilter;
import todo.api.repositories.PaginatedList;
import todo.api.repositories.TodoRepository;

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
