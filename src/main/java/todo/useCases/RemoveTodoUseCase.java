package todo.useCases;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.base.BaseTodoUseCase;

public class RemoveTodoUseCase extends BaseTodoUseCase {
	public RemoveTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
		super(persistenceAdapter);
	}

	@Override
	public Todo exec(Todo todo) {
		validate(todo);
		todo.setRemoved(true);
		return todo;
	}

	@Override
	protected Todo validate(Todo todo) {
		return validatePersisted(super.validate(todo));
	}
}
