package todo.useCases;

import org.junit.Before;
import org.junit.Test;
import todo.entities.Todo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveTodoUseCaseTest extends BaseTodoUseCaseTest<RemoveTodoUseCase> {

    @Before
    public void init() {
        feature = new RemoveTodoUseCase(persistenceAdapter);
    }

    @Test
    public void testRemoveNull() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(null);
    }

    @Test
    public void testRemoveInvalid() throws Exception {
        exception.expect(InvalidTodoException.class);
        feature.exec(builder.build());
    }

    @Test
    public void testRemoveUnsaved() throws Exception {
        exception.expect(UnsavedTodoException.class);
        feature.exec(builder.content("Sample").build());
    }

    @Test
    public void testValid() throws Exception {
        Todo todo = builder.content("Sample").build();
        todo.setId(1L);
        assertThat(feature.exec(todo).isRemoved(), equalTo(true));
    }

    @Test
    public void testRemoveTwoTimes() throws Exception {
        Todo todo = builder.content("Sample").build();
        todo.setId(1L);
        assertThat(feature.exec(feature.exec(todo)).isRemoved(), equalTo(true));
    }
}
