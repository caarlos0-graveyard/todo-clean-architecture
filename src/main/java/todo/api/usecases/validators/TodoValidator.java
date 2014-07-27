package todo.api.usecases.validators;

import todo.api.exceptions.InvalidTodoException;
import todo.api.models.Todo;

public class TodoValidator {
	public void validate(Todo todo) {
		if (todo == null)
			throw new InvalidTodoException();
		validate(todo.getText());
	}

	public void validate(String text) {
		if (text == null || text.trim().isEmpty())
			throw new InvalidTodoException();
	}
}
