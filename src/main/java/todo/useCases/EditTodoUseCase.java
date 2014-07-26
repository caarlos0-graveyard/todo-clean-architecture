package todo.useCases;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.base.BaseTodoUseCase;

public class EditTodoUseCase extends BaseTodoUseCase {
	public EditTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
		super(persistenceAdapter);
	}

	@Override
	public Todo exec(Todo todo) {
		return persistenceAdapter.update(validate(todo));
	}

	@Override
	protected Todo validate(Todo todo) {
		return validatePersisted(super.validate(todo));
	}
}
