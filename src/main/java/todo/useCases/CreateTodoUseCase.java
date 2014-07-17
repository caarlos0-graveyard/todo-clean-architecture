package todo.useCases;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.base.BaseTodoUseCase;

public class CreateTodoUseCase extends BaseTodoUseCase {

    public CreateTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
        super(persistenceAdapter);
    }

    public Todo exec(Todo todo) {
        return persistenceAdapter.persist(validate(todo));
    }
}
