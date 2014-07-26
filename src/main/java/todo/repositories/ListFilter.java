package todo.repositories;

public class ListFilter<T> {

	private String query;
	private int page = 1;

	public ListFilter<T> query(String query) {
		this.query = query;
		return this;
	}

	public ListFilter<T> page(int page) {
		this.page = page;
		return this;
	}

	public ListFilter<T> build() {
		return this;
	}

	public int getPage() {
		return page;
	}
}
