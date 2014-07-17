package todo.useCases;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import todo.entities.Todo;
import todo.entities.builders.TodoBuider;
import todo.persistence.PersistenceAdapter;
import todo.persistence.TodoMemoryPersistenceAdapter;
import todo.utils.BaseUseCase;

public abstract class BaseTodoUseCaseTest<T extends BaseUseCase> {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    protected TodoBuider builder;
    protected PersistenceAdapter<Todo> persistenceAdapter;
    protected T feature;

    @Before
    public void beforeEach() {
        builder = Todo.Builder();
        persistenceAdapter = new TodoMemoryPersistenceAdapter();
    }
}
