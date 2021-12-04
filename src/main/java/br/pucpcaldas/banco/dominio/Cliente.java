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
    

    public static Cliente Nulo = new Cliente(0, "", "");
    

    /**
     * Método construtor.
     * 
     * @param codigo    código do Cliente
     * @param nome      nome do Cliente
     * @param CPF   número da agência do Cliente
     */
    public Cliente(int codigo, String nome, String CPF) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.contas = new ArrayList<Conta>();
    }

    public Cliente () {}

    /**
     * Abre uma conta para o Cliente
     * 
     */
    public void abrirConta(Conta conta) {
        if (this.CPF != "") {
            this.contas.add(conta);
        }
    }

    /**
     * Retorna todas as contas do Cliente
     * 
     * @return conta do Cliente
     * 
     */
    public Collection<Conta> getConta() {
        return contas;
    }

    /**
     * Retorna o código do Cliente
     * 
     * @return código do Cliente
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Atualiza o código do Cliente
     * 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome do Cliente
     * 
     * @return nome do Cliente
     * 
    */
    public String getNome() {
        return nome;
    }

    /**
     * Atualiza o nome do Cliente
     * 
    */
    public void setNome(String nome) {
        this.nome = nome;
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
    /**
     * Atualiza o CPF do Cliente
     * 
     */
    public void setCPF(String cpf) {
        this.CPF = cpf;
    }
    
    @Override
    public String toString() {
        return String.format("Código=%03d#, nome=%s, CPF=%.2f", this.codigo, 
            this.nome, this.CPF);
    }
    
}