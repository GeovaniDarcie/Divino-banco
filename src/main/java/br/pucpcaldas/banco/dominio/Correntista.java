package br.pucpcaldas.banco.dominio;

import java.util.ArrayList;
import java.util.Collection;

/** 
 * Um objeto classe <code>Correntista</code> representa as informações de um
 * Correntista.
 * 
 * @author Geovani Darcie
 * @Version 1.0
 * 
*/
public class Correntista {
    private int codigo;
    private String nome;
    private String CPF;
    private Collection<Conta> contas;
    

    /**
     * Método construtor.
     * 
     * @param codigo    código do Correntista
     * @param nome      nome do Correntista
     * @param CPF   número da agência do Correntista
     */
    public Correntista(int codigo, String nome, String CPF) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.contas = new ArrayList<Conta>();
    }

    /**
     * Abre uma conta para o Correntista
     * 
     */
    public void abrirConta(Conta conta) {
        if (this.CPF != "") {
            this.contas.add(conta);
        }
    }

    /**
     * Retorna todas as contas do Correntista
     * 
     * @return conta do Correntista
     * 
     */
    public Collection<Conta> getConta() {
        return contas;
    }

    /**
     * Retorna o código do Correntista
     * 
     * @return código do Correntista
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o nome do Correntista
     * 
     * @return nome do Correntista
     * 
    */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a CPF do Correntista
     * 
     * @return CPF do Correntista
     * 
     */
    public String getCPF() {
        return CPF;
    }
    
    @Override
    public String toString() {
        return String.format("Código=%03d#, nome=%s, CPF=%.2f", this.codigo, 
            this.nome, this.CPF);
    }
    
}