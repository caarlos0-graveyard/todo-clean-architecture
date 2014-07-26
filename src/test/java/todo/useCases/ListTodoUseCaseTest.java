package todo.useCases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import todo.entities.Todo;

public class ListTodoUseCaseTest extends BaseTodoUseCaseTest<ListTodoUseCase> {
	@Before
	public void init() {
		feature = new ListTodoUseCase(adapter);
	}

	@Test
	public void testWithNothingSavedShouldReturnEmpty() throws Exception {
		assertThat(feature.exec().size(), equalTo(0));
	}

	@Test
	public void testWithItensShouldReturnAll() throws Exception {
		adapter.persist(builder.content("Refactor").done().build());
		adapter.persist(builder.content("Write more tests").build());
		adapter.persist(builder.content("Study Clean Architecture").build());
		assertThat(feature.exec().size(), equalTo(3));
	}

	@Test
	public void testReturnUpdatedList() throws Exception {
		Todo todo = adapter.persist(builder.content("Refactor").done().build());
		todo.toggle();
		todo = adapter.update(todo);
		List<Todo> todos = feature.exec();
		assertThat(todos.size(), equalTo(1));
		assertThat(todos.get(0), equalTo(todo));
	}
}
