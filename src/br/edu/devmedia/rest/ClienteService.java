package br.edu.devmedia.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.ClienteDAO;
import br.edu.devmedia.dao.NotaDAO;
import br.edu.devmedia.entidade.Cliente;
import br.edu.devmedia.entidade.Nota;

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
		}
		return lista;
	}

	@GET
	@Path("/buscaPorCpf/{dsCpf}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(@PathParam("dsCpf") String cpf) {
		Cliente cliente = null;
		try {
			cliente = clienteDAO.buscaPorCpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@GET
	@Path("/get/{cli_id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarPorId(@PathParam("cli_id") int idCliente) {
		
		Cliente cliente = new Cliente();
		cliente.setDsCpf("04367462633");
		cliente.setDsNome("Eduardo Cardoso");
		cliente.setDtNascimento("19820502");
		
		return cliente;
		
		/*
		Cliente cliente = null;
		try {
			cliente = clienteDAO.buscarClientePorId(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cliente;
		*/
	}

}
