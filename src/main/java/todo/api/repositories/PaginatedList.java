package todo.api.repositories;

import java.util.List;

public class PaginatedList<T> {
	private List<T> result;
	private int page = 1;
	private int totalPages = 1;
	private int pageSize = 10;

	public PaginatedList(List<T> result, int page) {
		this.result = result;
		this.page = page;
	}

	public List<T> getResult() {
		return result;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}
}
