package todo.useCases;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.base.BaseTodoUseCase;

public class ToggleTodoUseCase extends BaseTodoUseCase {
	public ToggleTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
		super(persistenceAdapter);
	}

	@Override
	public Todo exec(Todo todo) {
		validate(todo).toggle();
		return persistenceAdapter.persist(todo);
	}

	@Override
	protected Todo validate(Todo todo) {
		return validatePersisted(super.validate(todo));
	}
}
