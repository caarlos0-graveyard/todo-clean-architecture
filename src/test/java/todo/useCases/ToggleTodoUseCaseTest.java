package todo.useCases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.entities.Todo;

public class ToggleTodoUseCaseTest extends
		BaseTodoUseCaseTest<ToggleTodoUseCase> {

	@Before
	public void init() {
		feature = new ToggleTodoUseCase(adapter);
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
		Todo todo = feature.exec(adapter.persist(builder.content("Sample")
				.build()));
		assertThat(todo.isDone(), equalTo(true));
	}

	@Test
	public void testUndo() throws Exception {
		Todo todo = feature.exec(adapter.persist(builder.done()
				.content("Sample").build()));
		assertThat(todo.isDone(), equalTo(false));
	}
}
