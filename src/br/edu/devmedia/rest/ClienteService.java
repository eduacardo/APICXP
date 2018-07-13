package br.edu.devmedia.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.ClienteDAO;

import br.edu.devmedia.entidade.Cliente;


@Path("/clientes")
public class ClienteService {

	private ClienteDAO clienteDAO;

	@PostConstruct
	private void init() {
		clienteDAO = new ClienteDAO();
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listarClientes() {
		List<Cliente> lista = null;
		try {
			lista = clienteDAO.listarClientes();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return lista;
	}
	
	
	@POST
	@Path("/buscaPorCpf")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(String cpf) {
		System.out.println(cpf);
		Cliente cliente = null;
		try {
			cliente = clienteDAO.buscaPorCpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@POST
	@Path("/get")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(@PathParam("cli_id") int idCliente) {
		
		
		Cliente cliente = null;
		try {
			cliente = clienteDAO.buscarClientePorId(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
		
	}

}
