package br.pucpcaldas.banco.persistencia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pucpcaldas.banco.controle.DadosDaConta;
import br.pucpcaldas.banco.dominio.Banco;
import br.pucpcaldas.banco.dominio.Cliente;
import br.pucpcaldas.banco.dominio.Conta;

public class TestaDadosDaContas {

	private static DadosDaConta dados;
	private static Conta conta1, conta2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// dados = new DadosDaContaEmBancoDeDados();
		dados = new DadosDaContaComHibernate();

		Banco banco = new Banco(1, "nubank", 123);
		Cliente cliente1 = new Cliente(1, "conta1", "456");
		
		conta1 = new Conta(1, 50.5, "456.789.123-89", banco, cliente1);
		conta2 = new Conta(2, 60.5, "456.789.123-89", banco, cliente1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dados.fecha();
	}

	@Test
	public void adiciona_InsereUmContaNoBancoDeDados() {
		// Arranjo
		Conta umconta1 = conta1;

		// Acao
		dados.adiciona(umconta1);

		// Assercao
		Conta outroconta1 = dados.listaPor(1);
		assertConta(umconta1, outroconta1);
	}

	@Test
	public void atualiza_AtualizaUmContaNoBancoDeDados() {
		// Arranjo
		Conta umconta1 = conta1;
		// Acao
		dados.adiciona(umconta1);
		umconta1.setNumeroDaConta(123);
		umconta1.setSaldo(50.6);
		dados.atualiza(umconta1);

		// Assercao
		Conta outroconta1 = dados.listaPor(1);
		assertConta(umconta1, outroconta1);
	}

	@Test
	public void remove_RemoveUmContaNoBancoDeDados() {
		// Arranjo
		Conta umconta1 = conta1;
		
		// Acao
		dados.adiciona(umconta1);
		dados.remove(umconta1);

		// Assercao
		Conta outroconta1 = dados.listaPor(1);
		// assertConta(Conta.Nulo, outroconta1);
	}

	@Test
	public void lista_RetornaNuloParaUmContaQueNaoExiste() {
		// Arranjo

		// Acao
		Conta umconta1 = dados.listaPor(-1);

		// Assercao

		// assertConta(Conta.Nulo, umconta1);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dados.remove(conta1);
		dados.remove(conta2);
	}

	private void assertConta(Conta ContaAntes, Conta ContaDepois) {
		assertEquals(ContaAntes.getNumeroDaConta(), ContaDepois.getNumeroDaConta());
		// assertEquals(ContaAntes.getCPF(), ContaDepois.getCPF(), "134.124.789-80");
	}

}