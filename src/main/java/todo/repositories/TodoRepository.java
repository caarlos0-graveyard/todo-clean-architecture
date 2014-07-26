package todo.repositories;

import todo.models.Todo;

public interface TodoRepository {
	Todo save(Todo todo);

	PaginatedList<Todo> list(ListFilter<Todo> filter);
}
