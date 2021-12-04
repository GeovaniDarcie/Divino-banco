package br.pucpcaldas.banco.persistencia;

import org.hibernate.Session;

import br.pucpcaldas.banco.controle.DadosDaConta;
import br.pucpcaldas.banco.dominio.Conta;

public class DadosDaContaComHibernate implements DadosDaConta {
	private Session session;

	public DadosDaContaComHibernate(Session session) {
		this.session = session;
	}

	public DadosDaContaComHibernate() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void adiciona(Conta conta) {
		session.beginTransaction();
		session.save(conta);
		session.getTransaction().commit();
	}

	public void atualiza(Conta conta) {
		session.beginTransaction();
		session.update(conta);
		session.getTransaction().commit();
	}

	public void remove(Conta conta) {
		session.beginTransaction();
		session.delete(conta);
		session.getTransaction().commit();
	}

	public Conta listaPor(int codigo) {
		Conta Conta = session.find(Conta.class, codigo);
		return Conta;
	}

	public void fecha() {
		session.close();
	}
}
