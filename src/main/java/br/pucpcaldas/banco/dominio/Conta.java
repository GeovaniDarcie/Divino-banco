package br.pucpcaldas.banco.dominio;

import java.time.Duration;
import java.util.Calendar;

/** 
 * Um objeto classe <code>Conta</code> representa as informações de uma
 * conta que pertence a um banco.
 * 
 * @author Geovani Darcie
 * @Version 1.0
 * 
*/
public class Conta {
    private int numeroDaConta;
    private double saldo;
    private String tipoDaConta;
    private Calendar dataDaConta;
    private Banco banco;
    

    /**
     * Método construtor.
     * 
     * @param numeroDaConta    número da conta
     * @param saldo    saldo da conta
     * @param tipoDaConta   tipo da conta
     * @param Banco  banco ao qual pertence a conta
     */
    public Conta(int numeroDaConta, double saldo, String tipoDaConta, Banco banco) {
        if (numeroDaConta < 0) {
			throw new IllegalArgumentException("O número da conta precisa ser válido!");
		}
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.tipoDaConta = tipoDaConta;
        this.dataDaConta = Calendar.getInstance();
        this.banco = banco;
    }

    /**
     * Deposita uma quantidade de dinheiro na conta
    */
    public void depositar(double quantidade) {
        if (quantidade <= 0) {
			throw new IllegalArgumentException("A quantidade depositada deve ser maior que zero");
		}
        this.saldo = this.saldo + quantidade;
    }

    /**
     * Paga uma quantidade de dinheiro para um cliente
    */
    public void pagar(int codigoDoCliente, double quantidade) {
        if (this.saldo > 0) {
            this.saldo = this.saldo - quantidade;
        }
    }

    /**
     * Rende juros na conta se for do tipo poupança
    */
    public void rendeJurosNaConta() {
        Calendar calendar2 = Calendar.getInstance();
        int days = (int) Duration.between(this.dataDaConta.toInstant(), calendar2.toInstant()).toDays();

        if (days >= 30 && this.tipoDaConta.toLowerCase() == "poupança" && this.saldo > 0) {
            this.saldo = this.saldo * (35/100);
        }
    }

    /**
     * Retorna o número da conta
     * 
     * @return número da conta
     * 
     */
    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    /**
     * Retorna o saldo da conta
     * 
     * @return saldo da conta
     * 
    */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Retorna o tipoDaConta
     * 
     * @return tipo da conta
     * 
     */
    public String getTipoDaConta() {
        return tipoDaConta;
    }

    /**
     * Retorna o banco relacionado a conta
     * 
     * @return banco
     * 
     */
    public Banco getBanco() {
        return this.banco;
    }

    @Override
    public String toString() {
        return String.format("Número da conta=%03d#, saldo=%s, Tipo de conta=%s", this.numeroDaConta, 
            this.saldo, this.tipoDaConta);
    }
    
}
