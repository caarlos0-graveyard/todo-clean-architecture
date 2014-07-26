package todo.useCases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.entities.Todo;

public class EditTodoUseCaseTest extends BaseTodoUseCaseTest<EditTodoUseCase> {
	@Before
	public void init() {
		feature = new EditTodoUseCase(adapter);
	}

	@Test
	public void testEditNullTodo() throws Exception {
		exception.expect(InvalidTodoException.class);
		feature.exec(null);
	}

	@Test
	public void testInvalidTodo() throws Exception {
		exception.expect(InvalidTodoException.class);
		feature.exec(adapter.persist(builder.build()));
	}

	@Test
	public void testNullContentTodo() throws Exception {
		exception.expect(InvalidTodoException.class);
		feature.exec(adapter.persist(builder.content(null).build()));
	}

	@Test
	public void testWithEmptyContent() throws Exception {
		exception.expect(InvalidTodoException.class);
		feature.exec(adapter.persist(builder.content("").build()));
	}

	@Test
	public void testWithSpacesInContent() throws Exception {
		exception.expect(InvalidTodoException.class);
		feature.exec(adapter.persist(builder.content("    ").build()));
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
		return feature.exec(adapter.persist(builder.content("Changed content")
				.build()));
	}
}
