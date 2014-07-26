package todo.useCases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.entities.Todo;

public class RemoveTodoUseCaseTest extends
		BaseTodoUseCaseTest<RemoveTodoUseCase> {

	@Before
	public void init() {
		feature = new RemoveTodoUseCase(adapter);
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
		Todo todo = feature.exec(adapter.persist(builder.content("Sample")
				.build()));
		assertThat(todo.isRemoved(), equalTo(true));
	}

	@Test
	public void testRemoveTwoTimes() throws Exception {
		Todo todo = feature.exec(adapter.persist(builder.content("Sample")
				.build()));
		assertThat(feature.exec(todo).isRemoved(), equalTo(true));
	}
}
