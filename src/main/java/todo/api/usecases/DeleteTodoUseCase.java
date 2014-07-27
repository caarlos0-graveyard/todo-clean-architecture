package todo.api.usecases;

import todo.api.models.Todo;
import todo.api.repositories.TodoRepository;
import todo.api.usecases.validators.TodoValidator;

public class DeleteTodoUseCase implements HasRepository {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	@Override
	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo remove(Todo todo) {
		validator.validate(todo);
		todo.setDeleted(true);
		return repository.save(todo);
	}

}
