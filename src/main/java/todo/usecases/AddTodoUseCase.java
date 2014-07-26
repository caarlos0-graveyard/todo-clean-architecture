package todo.usecases;

import todo.exceptions.InvalidTodoException;
import todo.models.Todo;
import todo.repositories.TodoRepository;

public class AddTodoUseCase {
	private TodoRepository repository;

	public void setRepository(TodoRepository repository) {
		this.repository = repository;
	}

	public Todo create(String text) {
		if (text == null || text.trim().isEmpty())
			throw new InvalidTodoException();
		return repository.save(new Todo(text));
	}
}
