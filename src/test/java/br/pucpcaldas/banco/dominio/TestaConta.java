package br.pucpcaldas.banco.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestaConta {

	private static Banco nubank;
	private static Banco bancoDoBrasil;

	@BeforeClass
	public static void configuraTeste() {
		nubank = new Banco(260, "Nubank", 0001);
		bancoDoBrasil = new Banco(30, "Banco do Brasil", 4567);
	}

	@Test(expected = IllegalArgumentException.class)
	public void criaUmaContaComNumeroNegativo() {
		@SuppressWarnings("unused")
		Conta conta = new Conta(-1, 0, "poupança", nubank);
	}

	@Test(expected = IllegalArgumentException.class)
	public void depositar_deveRetonarUmaExcessaoQuandoQuantidadeIgualAZero() {
		Conta conta = new Conta(-1, 0, "poupança", nubank);

		conta.depositar(0);
	}

	@Test
	public void removeItem_DeveRemoverOItemRelacionadoAoProduto() {
		Pedido pedido = new Pedido(1);

		pedido.incluiItem(caneta, 3);

		pedido.removeItem(caneta);

		assertEquals(0.0, pedido.calculaTotal(), 0.01);
	}

	@Test
	public void removeItem_DeveRemoverOItemRelacionadoAoProdutoComDoisItens() {
		Pedido pedido = new Pedido(1);

		pedido.incluiItem(caneta, 3);
		pedido.incluiItem(lapis, 1);

		pedido.removeItem(caneta);

		assertEquals(1.00, pedido.calculaTotal(), 0.01);
	}

	@Test(expected = RuntimeException.class)
	public void calculafrete_DeveRetornarUmExcecaoParaUmPedidoVazio() {
		Pedido pedido = new Pedido(1);

		pedido.calculaFrete();
	}

	@Test
	public void calculafrete_DeveRetornarZeroParaPedidoComValorMenorOuIgualA200() {
		Pedido pedido = new Pedido(1);

		pedido.incluiItem(caneta, 10);

		assertEquals(0.0, pedido.calculaFrete(), 0.01);
	}

	@Test
	public void calculafrete_DeveRetornar10ParaPedidoComValorMenorOuIgualA500() {
		Pedido pedido = new Pedido(1);

		pedido.incluiItem(caneta, 200);

		assertEquals(10.0, pedido.calculaFrete(), 0.01);
	}

	@Test
	public void calculafrete_DeveRetornar12ParaPedidoComValorMaiorQue500() {
		Pedido pedido = new Pedido(1);

		pedido.incluiItem(caneta, 300);
		pedido.incluiItem(lapis, 100);

		assertEquals(12.0, pedido.calculaFrete(), 0.01);
	}

}

