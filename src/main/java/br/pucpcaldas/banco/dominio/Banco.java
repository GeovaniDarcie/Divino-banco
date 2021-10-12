package br.pucpcaldas.banco.dominio;
/** 
 * Um objeto classe <code>Banco</code> representa as informações de um
 * banco.
 * 
 * @author Geovani Darcie
 * @Version 1.0
 * 
*/
public class Banco {
    private int codigo;
    private String nome;
    private double agencia;
    

    /**
     * Método construtor.
     * 
     * @param codigo    código do banco
     * @param nome      nome do banco
     * @param agencia   número da agência do banco
     */
    public Banco(int codigo, String nome, double agencia) {
        this.codigo = codigo;
        this.nome = nome;
        this.agencia = agencia;
    }

    /**
     * Retorna o código do banco
     * 
     * @return código do banco
     * 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o nome do banco
     * 
     * @return nome do banco
     * 
    */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a agência do banco
     * 
     * @return agência do banco
     * 
     */
    public double getAgencia() {
        return agencia;
    }
    
    @Override
    public String toString() {
        return String.format("Banco=%03d#, nome=%s, agência=%.2f", this.codigo, 
            this.nome, this.agencia);
    }
    
}