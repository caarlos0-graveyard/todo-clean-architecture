package todo.impl.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import todo.api.models.Todo;
import todo.api.repositories.ListFilter;
import todo.api.repositories.PaginatedList;
import todo.api.repositories.TodoRepository;
import todo.impl.entities.QTodoEntity;
import todo.impl.entities.TodoEntity;

import com.mysema.query.jpa.impl.JPAQuery;

public class JPATodoRepository implements TodoRepository {
	private static final QTodoEntity todos = QTodoEntity.todoEntity;

	@Inject
	private EntityManager em;

	@Override
	public Todo save(Todo todo) {
		TodoEntity entity = convert(todo);
		if (entity.getId() == null)
			return persist(entity);
		return update(entity);
	}

	private Todo update(TodoEntity entity) {
		return convert(em.merge(entity));
	}

	private Todo persist(TodoEntity entity) {
		em.persist(entity);
		return convert(entity);
	}

	@Override
	public PaginatedList<Todo> list(ListFilter<Todo> filter) {
		JPAQuery query = filter(baseQuery(filter), filter);
		return new PaginatedList<>(mapResults(query), filter.getPage());
	}

	private List<Todo> mapResults(JPAQuery query) {
		return query
				.list(todos)
				.stream()
				.map(todo -> convert(todo))
				.collect(Collectors.toList());
	}

	private JPAQuery filter(JPAQuery query, ListFilter<Todo> filter) {
		if (filter.getQuery() != null)
			query.where(todos.text.like(filter.getQuery()));
		return query;
	}

	private JPAQuery baseQuery(ListFilter<Todo> filter) {
		return new JPAQuery(em)
				.from(todos)
				.where(todos.deleted.isFalse())
				.orderBy(todos.done.desc(), todos.text.asc())
				.limit(filter.getPageSize())
				.offset(filter.getOffset());
	}

	private Todo convert(TodoEntity entity) {
		return new Todo(entity.getId(), entity.getText(), entity.isDone(),
				entity.isDeleted());
	}

	private TodoEntity convert(Todo todo) {
		return new TodoEntity(todo.getId(), todo.getText(), todo.isDone(),
				todo.isDeleted());
	}
}
