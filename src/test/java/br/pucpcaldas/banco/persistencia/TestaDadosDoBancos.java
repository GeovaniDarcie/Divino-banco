
package br.pucpcaldas.banco.persistencia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pucpcaldas.banco.controle.DadosDoBanco;
import br.pucpcaldas.banco.dominio.Banco;

public class TestaDadosDoBancos {
    private static DadosDoBanco dados;
	private static Banco itau, nubank;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// dados = new DadosDeBancosEmBancoDeDados();
		dados = new DadosDoBancoComHibernate();
		
		itau = new Banco(1, "Itau", 456);
		nubank = new Banco(2, "Nubank", 123);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dados.fecha();
	}

	@Test
	public void adiciona_InsereUmBancoNoBancoDeDados() {
		// Arranjo
		Banco umitau = itau;

		// Acao
		dados.adiciona(umitau);

		// Assercao
		Banco outroitau = dados.listaPor(1);
		assertBanco(umitau, outroitau);
	}

	@Test
	public void atualiza_AtualizaUmBancoNoBancoDeDados() {
		// Arranjo
		Banco umitau = itau;
		// Acao
		dados.adiciona(umitau);
		umitau.setNome("itau Azul");
		umitau.setAgencia(456);
		dados.atualiza(umitau);

		// Assercao
		Banco outroitau = dados.listaPor(1);
		assertBanco(umitau, outroitau);
	}

	@Test
	public void remove_RemoveUmBancoNoBancoDeDados() {
		// Arranjo
		Banco umitau = itau;
		
		// Acao
		dados.adiciona(umitau);
		dados.remove(umitau);

		// Assercao
		//Banco outroitau = dados.listaPor(1);
		// assertBanco(Banco.Nulo, outroitau);
	}

	@Test
	public void lista_RetornaNuloParaUmBancoQueNaoExiste() {
		// Arranjo

		// Acao
		Banco umitau = dados.listaPor(-1);

		// Assercao

		// assertBanco(Banco.Nulo, umitau);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dados.remove(itau);
		dados.remove(nubank);
	}

	private void assertBanco(Banco BancoAntes, Banco BancoDepois) {
		assertEquals(BancoAntes.getCodigo(), BancoDepois.getCodigo());
		assertEquals(BancoAntes.getNome(), BancoDepois.getNome());
		// assertEquals(BancoAntes.getCPF(), BancoDepois.getCPF(), "134.124.789-80");
	}
}
