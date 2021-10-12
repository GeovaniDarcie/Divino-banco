package br.pucpcaldas.banco.dominio;

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

	@Test(expected = IllegalArgumentException.class)
	public void pagar_DeveRetonarUmaExcessaoParaContaIgualANull() {
        Conta conta1 = new Conta(366, 50, "poupança", nubank);
		conta1.pagar(null, 100);
		conta1.pagar(null, 200);
	}

    @Test
	public void pagar_deveTerUmaContaValida() {
		Conta conta1 = new Conta(366, 50, "poupança", nubank);

		Conta conta2 = new Conta(366, 50, "corrente", bancoDoBrasil);
		Conta conta3 = new Conta(366, 70, "poupança", bancoDoBrasil);

		conta1.pagar(conta2, 100);
		conta1.pagar(conta3, 200);
	}
}

