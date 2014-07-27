package todo.api.usecases;

import todo.api.models.Todo;
import todo.api.repositories.ListFilter;
import todo.api.repositories.PaginatedList;
import todo.api.repositories.TodoRepository;

public class ListTodosUseCase {

	private TodoRepository repository;

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public PaginatedList<Todo> list() {
		return repository.list(new ListFilter<Todo>());
	}

	public PaginatedList<Todo> list(ListFilter<Todo> filter) {
		return repository.list(filter);
	}

}
