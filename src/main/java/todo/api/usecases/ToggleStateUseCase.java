package todo.api.usecases;

import todo.api.models.Todo;
import todo.api.repositories.TodoRepository;
import todo.api.usecases.validators.TodoValidator;

public class ToggleStateUseCase {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo toggle(Todo todo) {
		validator.validate(todo);
		todo.setDone(!todo.isDone());
		return repository.save(todo);
	}
}
