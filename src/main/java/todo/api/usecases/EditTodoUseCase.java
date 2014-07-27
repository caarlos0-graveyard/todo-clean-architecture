package todo.api.usecases;

import todo.api.models.Todo;
import todo.api.repositories.TodoRepository;
import todo.api.usecases.validators.TodoValidator;

public class EditTodoUseCase implements HasRepository {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	@Override
	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public void edit(Todo todo) {
		validator.validate(todo);
		repository.save(todo);
	}

}
