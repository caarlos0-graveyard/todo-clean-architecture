package todo.api.repositories;

import todo.api.models.Todo;

public interface TodoRepository {
	Todo save(Todo todo);

	PaginatedList<Todo> list(ListFilter<Todo> filter);
}
