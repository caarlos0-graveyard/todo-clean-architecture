package todo.entities.builders;

import todo.entities.Todo;

public class TodoBuider {
	private final Todo todo;

	public TodoBuider() {
		this.todo = new Todo();
	}

	public Todo build() {
		return todo;
	}

	public TodoBuider content(String content) {
		todo.setContent(content);
		return this;
	}

	public TodoBuider done() {
		todo.setDone(true);
		return this;
	}
}
