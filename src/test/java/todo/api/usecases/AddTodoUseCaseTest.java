package todo.api.usecases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import todo.api.doubles.TodoRepositorySpy;
import todo.api.exceptions.InvalidTodoException;
import todo.api.models.Todo;
import todo.api.usecases.AddTodoUseCase;

@RunWith(Enclosed.class)
public class AddTodoUseCaseTest {

	public static class WithInvalidInput {
		private AddTodoUseCase interactor = new AddTodoUseCase();

		@Test(expected = InvalidTodoException.class)
		public void testAddEmptyTodo() throws Exception {
			interactor.create("");
		}

		@Test(expected = InvalidTodoException.class)
		public void testAddTodoFilledWithSpaces() throws Exception {
			interactor.create("      ");
		}

		@Test(expected = InvalidTodoException.class)
		public void testAddNullTodo() throws Exception {
			interactor.create(null);
		}
	}

	public static class WithValidInput {
		@Test
		public void testAddValidTodo() throws Exception {
			AddTodoUseCase interactor = new AddTodoUseCase();
			TodoRepositorySpy adapter = new TodoRepositorySpy();
			interactor.setRepository(adapter);

			Todo todo = interactor.create("Stury Clean Architecture");

			assertThat(todo, notNullValue());
			assertThat(todo.getText(), equalTo("Stury Clean Architecture"));
			assertThat(todo.isDone(), equalTo(false));
			assertThat(adapter.hasSaved(), equalTo(true));
		}
	}
}
