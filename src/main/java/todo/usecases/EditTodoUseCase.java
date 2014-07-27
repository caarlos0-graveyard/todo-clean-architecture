package todo.usecases;

import todo.models.Todo;
import todo.repositories.TodoRepository;
import todo.usecases.validators.TodoValidator;

public class EditTodoUseCase {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public void edit(Todo todo) {
		validator.validate(todo);
		repository.save(todo);
	}

}
