package todo.useCases;

import todo.entities.Todo;
import todo.persistence.PersistenceAdapter;
import todo.useCases.base.BaseTodoListUseCase;

import java.util.List;

public class ListTodoUseCase extends BaseTodoListUseCase {

    public ListTodoUseCase(PersistenceAdapter<Todo> persistenceAdapter) {
        super(persistenceAdapter);
    }

    @Override
    public List<Todo> exec() {
        return persistenceAdapter.list();
    }
}
