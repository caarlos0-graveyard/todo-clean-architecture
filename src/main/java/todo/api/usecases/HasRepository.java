package todo.api.usecases;

import todo.api.repositories.TodoRepository;

public interface HasRepository {
	void setRepository(TodoRepository repository);
}
