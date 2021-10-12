package br.pucpcaldas.banco.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Implementa casos de testes para a classe <code>TestaBanco</code>.
 */
public class TestaBanco {

    @Test
    public void testeConstrutor_DeveCriarUmBancoValido() {
        Banco caneta = new Banco(1, "caneta", 1.50);
        
        assertEquals(1, caneta.getCodigo());
        assertEquals("caneta", caneta.getNome());
        assertEquals(1.50, caneta.getAgencia(), 0.001);
    }
}
