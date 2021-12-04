package br.pucpcaldas.banco.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.pucpcaldas.banco.controle.DadosDeClientes;
import br.pucpcaldas.banco.dominio.Cliente;

public class DadosDeClientesEmBancoDeDados implements DadosDeClientes {
	private Connection _conexao;

	public DadosDeClientesEmBancoDeDados(Connection conexao) {
		this._conexao = conexao;
	}

	public DadosDeClientesEmBancoDeDados() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			this._conexao = DriverManager.getConnection("jdbc:hsqldb:file:data/dbContas", "SA", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Cliente cliente) {
		String sql = "INSERT INTO ClienteS" + " (codigo, nome, cpf)" + " VALUES(?, ?, ?)";

		try {
			PreparedStatement ins = _conexao.prepareStatement(sql);
			ins.setInt(1, cliente.getCodigo());
			ins.setString(2, cliente.getNome());
			ins.setString(3, cliente.getCPF());
			ins.execute();
			ins.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void atualiza(Cliente cliente) {
		String sql = "UPDATE Clientcs" + " SET nome 	= ? " + "	,cpf	 	= ? " + " WHERE codigo 	= ?";

		try {
			PreparedStatement upd = _conexao.prepareStatement(sql);
			upd.setString(1, cliente.getNome());
			upd.setString(2, cliente.getCPF());
			upd.setInt(3, cliente.getCodigo());
			upd.execute();
			upd.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Cliente cliente) {
		String sql = "DELETE FROM Clientes" + " WHERE codigo = ?";
		try {
			PreparedStatement del = _conexao.prepareStatement(sql);
			del.setInt(1, cliente.getCodigo());
			del.execute();
			del.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Cliente listaPor(int codigo) {
		String sql = "SELECT p.codigo, p.nome, p.cpf" + " FROM Clientes p " + " WHERE p.codigo = ?";

		Cliente umCliente = null;

		try {
			PreparedStatement sel = _conexao.prepareStatement(sql);
			sel.setInt(1, codigo);
			ResultSet rs = sel.executeQuery();
			while (rs.next()) {
				umCliente = new Cliente(rs.getInt("codigo"), rs.getString("nome"), rs.getString("cpf"));
			}
			sel.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return umCliente;
	}

	public void fecha() {
		try {
			Statement comando = _conexao.createStatement();
			comando.execute("SHUTDOWN");
			_conexao.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}