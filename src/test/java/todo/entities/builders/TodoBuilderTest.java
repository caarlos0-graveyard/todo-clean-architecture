package todo.entities.builders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.entities.Todo;

public class TodoBuilderTest {
	private TodoBuider builder;
	private static String CONTENT = "Buy Milk";

	@Before
	public void init() {
		builder = Todo.Builder();
	}

	@Test
	public void testBuildEmptyTodo() throws Exception {
		Todo todo = builder.build();
		assertThat(todo, notNullValue());
	}

	@Test
	public void testBuildWithDescription() throws Exception {
		Todo todo = builder
				.content(CONTENT)
				.build();
		assertThat(todo.getContent(), equalTo(CONTENT));
	}

	@Test
	public void testBuildDone() throws Exception {
		Todo todo = builder
				.done()
				.build();
		assertThat(todo.isDone(), equalTo(true));
	}

	@Test
	public void testBuildDoneTodoWithDescription() throws Exception {
		Todo todo = builder
				.done()
				.content(CONTENT)
				.build();
		assertThat(todo.isDone(), equalTo(true));
		assertThat(todo.getContent(), equalTo(CONTENT));
	}

	@Test
	public void testBuildUndonneByDefault() throws Exception {
		Todo todo = builder.build();
		assertThat(todo.isDone(), equalTo(false));
	}

	@Test
	public void testIdShouldBeNull() throws Exception {
		Todo todo = builder.build();
		assertThat(todo.getId(), nullValue());
	}

	@Test
	public void testCreatedAtShouldBeNull() throws Exception {
		Todo todo = builder.build();
		assertThat(todo.getCreatedAt(), nullValue());
	}

	@Test
	public void testUpdatedAtShouldBeNull() throws Exception {
		Todo todo = builder.build();
		assertThat(todo.getUpdatedAt(), nullValue());
	}
}
