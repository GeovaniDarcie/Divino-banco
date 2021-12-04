package br.pucpcaldas.banco.persistencia;

import org.hibernate.Session;

import br.pucpcaldas.banco.controle.DadosDoBanco;
import br.pucpcaldas.banco.dominio.Banco;

public class DadosDoBancoComHibernate implements DadosDoBanco {
	private Session session;

	public DadosDoBancoComHibernate(Session session) {
		this.session = session;
	}

	public DadosDoBancoComHibernate() {
		session = HibernateUtil.getSessionFactory().openSession();
	}

	public void adiciona(Banco banco) {
		session.beginTransaction();
		session.save(banco);
		session.getTransaction().commit();
	}

	public void atualiza(Banco banco) {
		session.beginTransaction();
		session.update(banco);
		session.getTransaction().commit();
	}

	public void remove(Banco banco) {
		session.beginTransaction();
		session.delete(banco);
		session.getTransaction().commit();
	}

	public Banco listaPor(int codigo) {
		Banco Banco = session.find(Banco.class, codigo);
		return Banco;
	}

	public void fecha() {
		session.close();
	}
}
