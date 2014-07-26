package todo.usecases;

import todo.models.Todo;
import todo.repositories.PaginatedList;
import todo.repositories.ListFilter;
import todo.repositories.TodoRepository;

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
