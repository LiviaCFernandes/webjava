package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import entity.Usuario;
import persistence.UsuarioDao;

@Path("/usuario")
public class ServiceUsuario {

	@GET
	@Path("/usuarios")
	@Produces (MediaType.APPLICATION_JSON)
	public String listar() {
		try {
			return new Gson().toJson(new UsuarioDao().findAll());
		}catch(Exception ex) {
			return null;
		}
	}
	
	@GET
	@Path("/usuario/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public String listarCodigo(@PathParam("id") String id) {
		try {
			return new Gson().toJson(new UsuarioDao().findByCode(new Integer(id)));
		}catch(Exception ex) {
			return null;
		}
	}
	
	@GET
	@Path("/usuario/{login}/{senha}")
	@Produces (MediaType.APPLICATION_JSON)
	public String listarLogin(@PathParam("login") String login, @PathParam("senha") String senha) {
		Usuario u = new Usuario (null, login, senha);
		try {
			return new Gson().toJson(new UsuarioDao().findByLogin(u));
		}catch(Exception ex) {
			return null;
		}
	}
	
	@POST
	@Path("/usuario/gravar")
	@Produces (MediaType.APPLICATION_JSON)
	@Consumes (MediaType.APPLICATION_JSON)
	public String gravar(String usuario) {
		try {
			Usuario u = new Gson().fromJson(usuario, Usuario.class);
			new UsuarioDao().create(u);
			return new Gson().toJson(u);
		}catch(Exception ex) {
			return null;
		}
	}
	
	
}
