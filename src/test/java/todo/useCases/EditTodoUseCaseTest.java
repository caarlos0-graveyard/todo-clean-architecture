package todo.useCases;

import org.junit.Before;
import org.junit.Test;
import todo.entities.Todo;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditTodoUseCaseTest extends BaseTodoUseCaseTest<EditTodoUseCase> {
    @Before
    public void init() {
        feature = new EditTodoUseCase(persistenceAdapter);
    }

    @Test
    public void testEditNullTodo() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(null);
    }

    @Test
    public void testInvalidTodo() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(persistenceAdapter.persist(builder.build()));
    }

    @Test
    public void testUnsavedTodo() throws Exception {
        exception.expect(UnsavedTodoException.class);
        feature.exec(builder.content("Sample").build());
    }

    @Test
    public void testValidTodo() throws Exception {
        Todo todo = createTodo();
        assertThat(todo, notNullValue());
        assertThat(todo.getId(), equalTo(1L));
    }

    @Test
    public void testUpdatedAtChange() throws Exception {
        Todo todo = createTodo();
        assertThat(todo.getUpdatedAt(), notNullValue());
    }

    private Todo createTodo() {
        return feature.exec(persistenceAdapter.persist(builder.content("Changed content").build()));
    }
}

