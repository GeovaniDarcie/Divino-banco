package br.pucpcaldas.banco.controle;

import br.pucpcaldas.banco.dominio.Banco;

public interface DadosDoBanco {
	void adiciona(Banco banco);
	void atualiza(Banco banco);
	void remove(Banco banco);
	Banco listaPor(int codigo);
	void fecha();
}
