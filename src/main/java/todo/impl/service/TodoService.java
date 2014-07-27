package todo.impl.service;

import static java.util.Arrays.asList;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import todo.api.models.Todo;
import todo.api.repositories.ListFilter;
import todo.api.repositories.PaginatedList;
import todo.api.usecases.AddTodoUseCase;
import todo.api.usecases.DeleteTodoUseCase;
import todo.api.usecases.EditTodoUseCase;
import todo.api.usecases.ListTodosUseCase;
import todo.api.usecases.ToggleTodoUseCase;
import todo.impl.repository.JPATodoRepository;

@Stateless
public class TodoService {

	@Inject
	private JPATodoRepository repository;

	@Inject
	private ListTodosUseCase lister;

	@Inject
	private AddTodoUseCase adder;

	@Inject
	private ToggleTodoUseCase toggler;

	@Inject
	private EditTodoUseCase editor;

	@Inject
	private DeleteTodoUseCase deleter;

	@PostConstruct
	public void postConstruct() {
		asList(lister, adder, toggler, editor, deleter)
				.stream()
				.forEach(interactor -> interactor.setRepository(repository));
	}

	public Todo create(String text) {
		return adder.create(text);
	}

	public Todo toggle(Todo todo) {
		return toggler.toggle(todo);
	}

	public Todo remove(Todo todo) {
		return deleter.remove(todo);
	}

	public PaginatedList<Todo> list() {
		return lister.list();
	}

	public PaginatedList<Todo> list(ListFilter<Todo> filter) {
		return lister.list(filter);
	}
}
