package br.pucpcaldas.banco.persistencia;

import org.hibernate.Session;

import br.pucpcaldas.banco.controle.DadosDeClientes;
import br.pucpcaldas.banco.dominio.Cliente;

public class DadosDeClientesComHibernate implements DadosDeClientes {
	private Session session;

	public DadosDeClientesComHibernate(Session session) {
		this.session = session;
	}

	public DadosDeClientesComHibernate() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void adiciona(Cliente cliente) {
		session.beginTransaction();
		session.save(cliente);
		session.getTransaction().commit();
	}

	public void atualiza(Cliente cliente) {
		session.beginTransaction();
		session.update(cliente);
		session.getTransaction().commit();
	}

	public void remove(Cliente cliente) {
		session.beginTransaction();
		session.delete(cliente);
		session.getTransaction().commit();
	}

	public Cliente listaPor(int codigo) {
		Cliente cliente = session.find(Cliente.class, codigo);
		if (cliente == null) cliente = Cliente.Nulo;
		return cliente;
	}

	public void fecha() {
		session.close();
	}
}
