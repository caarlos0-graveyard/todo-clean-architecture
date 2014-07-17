package todo.useCases;

import org.junit.Before;
import org.junit.Test;
import todo.entities.Todo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ToggleTodoUseCaseTest extends BaseTodoUseCaseTest<ToggleTodoUseCase> {

    @Before
    public void init() {
        feature = new ToggleTodoUseCase(persistenceAdapter);
    }

    @Test
    public void testToggleUnsavedTodo() throws Exception {
        exception.expect(UnsavedTodoException.class);
        feature.exec(builder.content("Sample").build());
    }

    @Test
    public void testToggleNull() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(null);
    }

    @Test
    public void testDo() throws Exception {
        Todo todo = builder.content("Sample").build();
        todo.setId(1L);
        todo = feature.exec(todo);
        assertThat(todo.isDone(), equalTo(true));
    }

    @Test
    public void testUndo() throws Exception {
        Todo todo = builder.content("Sample").done().build();
        todo.setId(1L);
        todo = feature.exec(todo);
        assertThat(todo.isDone(), equalTo(false));
    }
}
