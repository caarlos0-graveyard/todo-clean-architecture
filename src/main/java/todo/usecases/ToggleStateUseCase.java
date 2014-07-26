package todo.usecases;

import todo.exceptions.InvalidTodoException;
import todo.models.Todo;
import todo.repositories.TodoRepository;

public class ToggleStateUseCase {

	private TodoRepository repository;

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo toggle(Todo todo) {
		if (todo == null)
			throw new InvalidTodoException();
		todo.setDone(!todo.isDone());
		return repository.save(todo);
	}
}
