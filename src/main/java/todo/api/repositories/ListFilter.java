package todo.api.repositories;

public class ListFilter<T> {

	private String query;
	private int page = 1;
	private int pageSize = 10;

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

	public String getQuery() {
		return query;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getOffset() {
		return getPage() * getPageSize();
	}
}
