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
    private int agencia;
    
    public static Banco Nulo = new Banco(0, "", 0);
    /**
     * Método construtor.
     * 
     * @param codigo    código do banco
     * @param nome      nome do banco
     * @param agencia   número da agência do banco
     */
    public Banco(int codigo, String nome, int agencia) {
        this.codigo = codigo;
        this.nome = nome;
        this.agencia = agencia;
    }

    public Banco() {}

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
     * Atualiza o código do banco
     * 
     * @return código do banco
     * 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * Atualiza o nome do banco
     * 
     * @return nome do banco
     * 
    */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a agência do banco
     * 
     * @return agência do banco
     * 
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * Atualiza a agência do banco
     * 
     * @return agência do banco
     * 
     */
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    @Override
    public String toString() {
        return String.format("Banco=%03d#, nome=%s, agência=%.2f", this.codigo, 
            this.nome, this.agencia);
    }
    
}