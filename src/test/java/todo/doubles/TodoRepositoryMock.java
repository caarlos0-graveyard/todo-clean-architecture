package todo.doubles;

import java.util.List;

import todo.models.Todo;
import todo.repositories.ListFilter;
import todo.repositories.PaginatedList;
import todo.repositories.TodoRepository;

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
