package todo.usecases;

import todo.models.Todo;
import todo.repositories.TodoRepository;
import todo.usecases.validators.TodoValidator;

public class DeleteTodoUseCase {
	private TodoRepository repository;
	private TodoValidator validator = new TodoValidator();

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo remove(Todo todo) {
		validator.validate(todo);
		todo.setDeleted(true);
		return repository.save(todo);
	}

}
