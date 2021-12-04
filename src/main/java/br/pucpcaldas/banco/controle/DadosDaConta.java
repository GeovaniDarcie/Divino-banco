package br.pucpcaldas.banco.controle;

import br.pucpcaldas.banco.dominio.Conta;

public interface DadosDaConta {
	void adiciona(Conta conta);
	void atualiza(Conta conta);
	void remove(Conta conta);
	Conta listaPor(int codigo);
	void fecha();
}
