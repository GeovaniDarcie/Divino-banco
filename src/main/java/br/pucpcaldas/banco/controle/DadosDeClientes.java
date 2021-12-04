package br.pucpcaldas.banco.controle;

import br.pucpcaldas.banco.dominio.Cliente;

public interface DadosDeClientes {
	void adiciona(Cliente cliente);
	void atualiza(Cliente cliente);
	void remove(Cliente cliente);
	Cliente listaPor(int codigo);
	void fecha();
}
