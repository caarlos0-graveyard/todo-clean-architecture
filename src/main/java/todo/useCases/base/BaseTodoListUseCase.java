package todo.useCases.base;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.utils.BaseUseCase;

import java.util.List;

public abstract class BaseTodoListUseCase extends BaseUseCase<Todo> {
    public BaseTodoListUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
        super(persistenceAdapter);
    }

    public abstract List<Todo> exec();
}
