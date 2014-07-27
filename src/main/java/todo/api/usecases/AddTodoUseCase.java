package todo.api.usecases;

import todo.api.models.Todo;
import todo.api.repositories.TodoRepository;
import todo.api.usecases.validators.TodoValidator;

public class AddTodoUseCase {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo create(String text) {
		validator.validate(text);
		return repository.save(new Todo(text));
	}
}
