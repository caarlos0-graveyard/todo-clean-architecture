package todo.api.doubles;

import java.util.List;

import todo.api.models.Todo;
import todo.api.repositories.ListFilter;
import todo.api.repositories.PaginatedList;
import todo.api.repositories.TodoRepository;

public class TodoRepositoryMock implements TodoRepository {

	private List<Todo> todos;

	@Override
	public Todo save(Todo todo) {
		return null;
	}

	public void setList(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public PaginatedList<Todo> list(ListFilter<Todo> filter) {
		return new PaginatedList<Todo>(todos, filter.getPage());
	}
}
