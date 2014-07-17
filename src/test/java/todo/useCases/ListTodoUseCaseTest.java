package todo.useCases;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import todo.entities.Todo;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTodoUseCaseTest extends BaseTodoUseCaseTest<ListTodoUseCase> {
    @Before
    public void init() {
        feature = new ListTodoUseCase(persistenceAdapter);
    }

    @Test
    public void testWithNothingSavedShouldReturnEmpty() throws Exception {
        assertThat(feature.exec().size(), equalTo(0));
    }

    @Test
    public void testWithItensShouldReturnAll() throws Exception {
        persistenceAdapter.persist(builder.content("Buy Milk").done().build());
        persistenceAdapter.persist(builder.content("Write more tests").build());
        persistenceAdapter.persist(builder.content("Study Clean Architecture").build());
        assertThat(feature.exec().size(), equalTo(3));
    }

    @Test
    public void testReturnUpdatedList() throws Exception {
        Todo todo = persistenceAdapter.persist(builder.content("Buy Milk").done().build());
        todo.toggle();
        todo = persistenceAdapter.update(todo);
        List<Todo> todos = feature.exec();
        assertThat(todos.size(), equalTo(1));
        assertThat(todos.get(0), equalTo(todo));
    }
}
