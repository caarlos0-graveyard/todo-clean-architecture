package todo.api.usecases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.api.doubles.TodoRepositorySpy;
import todo.api.exceptions.InvalidTodoException;
import todo.api.models.Todo;
import todo.api.usecases.ToggleStateUseCase;

public class ToggleTodoUseCaseTest {
	private TodoRepositorySpy repository;
	private ToggleStateUseCase interactor;

	@Before
	public void init() {
		interactor = new ToggleStateUseCase();
		repository = new TodoRepositorySpy();
		interactor.setRepository(repository);
	}

	@Test(expected = InvalidTodoException.class)
	public void testToggleNullTodo() throws Exception {
		interactor.toggle(null);
	}

	@Test
	public void testToggleUndoneTodo() throws Exception {
		Todo todo = interactor.toggle(new Todo("Test this"));

		assertThat(todo, notNullValue());
		assertThat(todo.isDone(), equalTo(true));
		assertThat(repository.hasSaved(), equalTo(true));
	}

	@Test
	public void testToggleDoneTodo() throws Exception {
		Todo todo = interactor.toggle(new Todo("Test this", true));

		assertThat(todo, notNullValue());
		assertThat(todo.isDone(), equalTo(false));
		assertThat(repository.hasSaved(), equalTo(true));
	}
}
