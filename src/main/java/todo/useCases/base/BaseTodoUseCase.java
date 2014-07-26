package todo.useCases.base;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.InvalidTodoException;
import todo.useCases.UnsavedTodoException;
import todo.utils.BaseSingleUseCase;
import todo.utils.Strings;

public abstract class BaseTodoUseCase extends BaseSingleUseCase<Todo> {
	public BaseTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
		super(persistenceAdapter);
	}

	protected Todo validate(Todo todo) {
		if (!isValid(todo))
			throw new InvalidTodoException();
		return todo;
	}

	protected Todo validatePersisted(Todo todo) {
		if (todo.getId() == null)
			throw new UnsavedTodoException();
		return todo;
	}

	private boolean isValid(Todo todo) {
		if (todo == null)
			return false;
		return !Strings.isNullOrEmpty(todo.getContent());
	}
}
