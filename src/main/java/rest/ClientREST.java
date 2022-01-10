package rest;

import java.util.List;

import bll.ClientManager;
import bo.Client;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("client")
public class ClientREST {
	@GET
	public List<Client> getClient() {
		return ClientManager.selectAll();
	}

	@GET
	@Path("/{id:\\d+}")
	public Client getClientById(@PathParam("id") int id) {
		return ClientManager.selectById(id);
	}

	@POST
	public Client insertClient(@FormParam("content") String content) {
		Client clientToInsert = new Client();
		// TODO code the form treatment
		return ClientManager.insert(clientToInsert);
	}

	@PUT
	@Path("/{id :  \\d+}")
	public Client updateClient(@PathParam("id") int id, @FormParam("content") String content) {
		Client clientToUpdate = ClientManager.selectById(id);
		// TODO code the form treatment
		return ClientManager.update(clientToUpdate);
	}

	@DELETE
	@Path("/{id :  \\d+}")
	public Client deleteClientById(@PathParam("id") int id) {
		return ClientManager.delete(ClientManager.selectById(id));
	}
}
