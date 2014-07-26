package todo.useCases.base;

import java.util.List;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.utils.BaseUseCase;

public abstract class BaseTodoListUseCase extends BaseUseCase<Todo> {
	public BaseTodoListUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
		super(persistenceAdapter);
	}

	public abstract List<Todo> exec();
}
