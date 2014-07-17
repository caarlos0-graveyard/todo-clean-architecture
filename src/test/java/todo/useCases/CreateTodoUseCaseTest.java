package todo.useCases;

import org.junit.Before;
import org.junit.Test;
import todo.entities.Todo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreateTodoUseCaseTest extends BaseTodoUseCaseTest<CreateTodoUseCase> {

    @Before
    public void init() {
        feature = new CreateTodoUseCase(persistenceAdapter);
    }

    @Test
    public void testNullTodo() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(null);
    }

    @Test
    public void testInvalidTodo() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(builder.build());
    }

    @Test
    public void testCreateValidTodo() throws Exception {
        Todo todo = feature.exec(builder.content("Buy milk").build());
        assertThat(todo.getId(), notNullValue());
        assertThat(todo.getCreatedAt(), notNullValue());
        assertThat(todo.getUpdatedAt(), nullValue());
    }
}
