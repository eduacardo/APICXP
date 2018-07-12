package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.devmedia.config.BDConfig;
import br.edu.devmedia.entidade.Cliente;

public class ClienteDAO {

	public List<Cliente> listarClientes() throws Exception {

		List<Cliente> lista = new ArrayList<>();

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM tb_cliente";

		PreparedStatement statement = conexao.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setId(rs.getInt("CLI_ID"));
			cliente.setDsNome(rs.getString("CLI_NOME"));
			cliente.setDsCpf(rs.getString("CLI_CPF"));
			cliente.setDtNascimento(rs.getString("CLI_DATA_NASCIMENTO"));

			lista.add(cliente);
		}

		return lista;
	}

	public Cliente buscarClientePorId(int idCliente) throws Exception {

		Cliente cliente = null;

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM tb_cliente WHERE CLI_ID = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idCliente);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("CLI_ID"));
			cliente.setDsNome(rs.getString("CLI_NOME"));
			cliente.setDsCpf(rs.getString("CLI_CPF"));
			cliente.setDtNascimento(rs.getString("CLI_DATA_NASCIMENTO"));
		}

		return cliente;
	}

	public Cliente buscaPorCpf(String cpf) throws Exception {

		Cliente cliente = null;

		Connection conexao = BDConfig.getConnection();

		String sql = "SELECT * FROM tb_cliente WHERE CLI_CPF = ?";

		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setString(1, cpf);
		ResultSet rs = statement.executeQuery();

		if (rs.next()) {
			cliente = new Cliente();
			cliente.setId(rs.getInt("CLI_ID"));
			cliente.setDsNome(rs.getString("CLI_NOME"));
			cliente.setDsCpf(rs.getString("CLI_CPF"));
			cliente.setDtNascimento(rs.getString("CLI_DATA_NASCIMENTO"));
		}

		return cliente;
	}

}
