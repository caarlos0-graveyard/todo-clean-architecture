package todo.api.models;

public class Todo {
	private String text;
	private boolean done;
	private boolean deleted;
	private Long id;

	public Todo(String text) {
		this.text = text;
	}

	public Todo(String text, boolean done) {
		this.text = text;
		this.done = done;
	}

	public Todo(Long id, String text, boolean done, boolean deleted) {
		this.id = id;
		this.text = text;
		this.done = done;
		this.deleted = deleted;
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

	public Long getId() {
		return id;
	}
}
