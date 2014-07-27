package todo.models;

public class Todo {
	private String text;
	private boolean done;
	private boolean deleted;

	public Todo(String text) {
		this.text = text;
	}

	public Todo(String text, boolean done) {
		this.text = text;
		this.done = done;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getText() {
		return text;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
