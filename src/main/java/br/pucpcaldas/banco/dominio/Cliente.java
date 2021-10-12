package br.pucpcaldas.banco.dominio;

import java.util.ArrayList;
import java.util.Collection;

/** 
 * Um objeto classe <code>Cliente</code> representa as informações de um
 * Cliente.
 * 
 * @author Geovani Darcie
 * @Version 1.0
 * 
*/
public class Cliente {
    private int codigo;
    private String nome;
    private String CPF;
    private Collection<Conta> contas;
    

    /**
     * Método construtor.
     * 
     * @param codigo    código do cliente
     * @param nome      nome do cliente
     * @param CPF   número da agência do cliente
     */
    public Cliente(int codigo, String nome, String CPF) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.contas = new ArrayList<Conta>();
    }

    /**
     * Abre uma conta para o cliente
     * 
     */
    public void abrirConta(Conta conta) {
        if (this.CPF != "") {
            this.contas.add(conta);
        }
    }

    /**
     * Retorna todas as contas do cliente
     * 
     * @return conta do cliente
     * 
     */
    public Collection<Conta> getConta() {
        return contas;
    }

    /**
     * Retorna o código do cliente
     * 
     * @return código do cliente
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o nome do cliente
     * 
     * @return nome do cliente
     * 
    */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a CPF do Cliente
     * 
     * @return CPF do Cliente
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