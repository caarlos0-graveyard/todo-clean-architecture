package todo.usecases;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import todo.doubles.TodoRepositorySpy;
import todo.exceptions.InvalidTodoException;
import todo.models.Todo;

public class DeleteTodoUseCaseTest {
	private DeleteTodoUseCase interactor;
	private TodoRepositorySpy repository;

	@Before
	public void init() {
		interactor = new DeleteTodoUseCase();
		repository = new TodoRepositorySpy();
		interactor.setRepository(repository);
	}

	@Test(expected = InvalidTodoException.class)
	public void testDeleteNullTodo() throws Exception {
		interactor.remove(null);
	}

	@Test
	public void testDeleteTodo() throws Exception {
		Todo todo = interactor.remove(new Todo("Example"));
		assertThat(todo, notNullValue());
		assertThat(todo.isDeleted(), equalTo(true));
		assertThat(repository.hasSaved(), equalTo(true));
	}
	
	@Test
	public void testDeletedAlreadyDeletedTodo() throws Exception {
		Todo examle = new Todo("Example");
		examle.setDeleted(true);
		Todo todo = interactor.remove(examle);
		assertThat(todo, notNullValue());
		assertThat(todo.isDeleted(), equalTo(true));
		assertThat(repository.hasSaved(), equalTo(true));
	}
}
