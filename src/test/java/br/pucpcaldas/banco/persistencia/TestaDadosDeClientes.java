package br.pucpcaldas.banco.persistencia;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.pucpcaldas.banco.controle.DadosDeClientes;
import br.pucpcaldas.banco.dominio.Cliente;

public class TestaDadosDeClientes {

	private static DadosDeClientes dados;
	private static Cliente geovani, luis;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// dados = new DadosDeClientesEmBancoDeDados();
		dados = new DadosDeClientesComHibernate();
		
		geovani = new Cliente(1, "Geovani", "456.789.123-89");
		luis = new Cliente(2, "Luis", "456.789.123-89");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dados.fecha();
	}

	@Test
	public void adiciona_InsereUmClienteNoBancoDeDados() {
		// Arranjo
		Cliente umgeovani = geovani;

		// Acao
		dados.adiciona(umgeovani);

		// Assercao
		Cliente outrogeovani = dados.listaPor(1);
		assertCliente(umgeovani, outrogeovani);
	}

	@Test
	public void atualiza_AtualizaUmClienteNoBancoDeDados() {
		// Arranjo
		Cliente umgeovani = geovani;
		// Acao
		dados.adiciona(umgeovani);
		umgeovani.setNome("geovani Azul");
		umgeovani.setCPF("134.124.789-80");
		dados.atualiza(umgeovani);

		// Assercao
		Cliente outrogeovani = dados.listaPor(1);
		assertCliente(umgeovani, outrogeovani);
	}

	@Test
	public void remove_RemoveUmClienteNoBancoDeDados() {
		// Arranjo
		Cliente umgeovani = geovani;
		
		// Acao
		dados.adiciona(umgeovani);
		dados.remove(umgeovani);

		// Assercao
		Cliente outrogeovani = dados.listaPor(1);
		assertCliente(Cliente.Nulo, outrogeovani);
	}

	@Test
	public void lista_RetornaNuloParaUmClienteQueNaoExiste() {
		// Arranjo

		// Acao
		Cliente umgeovani = dados.listaPor(-1);

		// Assercao

		assertCliente(Cliente.Nulo, umgeovani);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		dados.remove(geovani);
		dados.remove(luis);
	}

	private void assertCliente(Cliente ClienteAntes, Cliente ClienteDepois) {
		assertEquals(ClienteAntes.getCodigo(), ClienteDepois.getCodigo());
		assertEquals(ClienteAntes.getNome(), ClienteDepois.getNome());
		// assertEquals(ClienteAntes.getCPF(), ClienteDepois.getCPF(), "134.124.789-80");
	}

}