package todo.impl.endpoints;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import todo.api.models.Todo;
import todo.api.repositories.PaginatedList;
import todo.impl.service.TodoService;

@Path("/rest/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodosResource {
	@EJB
	private TodoService service;

	@GET
	public PaginatedList<Todo> list() {
		return service.list();
	}

}
