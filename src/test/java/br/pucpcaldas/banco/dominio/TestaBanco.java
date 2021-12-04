package br.pucpcaldas.banco.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Implementa casos de testes para a classe <code>TestaBanco</code>.
 */
public class TestaBanco {

    @Test
    public void testeConstrutor_DeveCriarUmBancoValido() {
        Banco nubank = new Banco(1, "nubank", 150);
        
        assertEquals(1, nubank.getCodigo());
        assertEquals("nubank", nubank.getNome());
        assertEquals(1.50, nubank.getAgencia(), 0.001);
    }
}
