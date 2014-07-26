package todo.usecases;

import static java.util.stream.IntStream.range;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import todo.doubles.TodoRepositoryMock;
import todo.models.Todo;
import todo.repositories.PaginatedList;
import todo.repositories.ListFilter;

public class ListTodoUseCaseTest {

	private ListTodosUseCase interactor;
	private TodoRepositoryMock repository;

	@Before
	public void init() {
		interactor = new ListTodosUseCase();
		repository = new TodoRepositoryMock();
		interactor.setRepository(repository);
	}

	@Test
	public void testListTodosWhenEmpty() throws Exception {
		repository.setList(new ArrayList<Todo>());

		PaginatedList<Todo> todos = interactor.list();

		assertThat(todos.getResult().size(), equalTo(0));
		assertThat(todos.getTotalPages(), equalTo(1));
		assertThat(todos.getCurrentPage(), equalTo(1));
		assertThat(todos.getPageSize(), equalTo(10));
	}

	@Test
	public void testQueryTodos() throws Exception {
		repository.setList(generateTodos(20));
		ListFilter<Todo> filter = new ListFilter<Todo>()
				.query("Item 1")
				.build();

		PaginatedList<Todo> todos = interactor.list(filter);

		assertThat(todos.getCurrentPage(), equalTo(1));
		assertThat(todos.getPageSize(), equalTo(10));
	}
	
	@Test
	public void testSpecificPage() throws Exception {
		repository.setList(generateTodos(20));
		ListFilter<Todo> filter = new ListFilter<Todo>()
				.page(2)
				.build();

		PaginatedList<Todo> todos = interactor.list(filter);

		assertThat(todos.getCurrentPage(), equalTo(2));
		assertThat(todos.getPageSize(), equalTo(10));
	}

	// @Test
	// public void testListWithThreePagesGettingPageTwo() throws Exception {
	// repository.setList(generateTodos(25));
	//
	// PaginatedList<Todo> todos = interactor.list();
	//
	// assertThat(todos.getResult().size(), equalTo(25));
	// assertThat(todos.getTotalPages(), equalTo(3));
	// assertThat(todos.getCurrentPage(), equalTo(1));
	// assertThat(todos.getPageSize(), equalTo(10));
	// }

	private List<Todo> generateTodos(int amount) {
		List<Todo> todos = new ArrayList<>();
		range(0, amount)
				.forEach(index -> todos.add(generateTodo(index)));
		return todos;
	}

	private Todo generateTodo(int index) {
		return new Todo("Item " + index, index % 2 == 0);
	}
}
