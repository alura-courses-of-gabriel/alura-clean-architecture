package br.example.escola.dominio;

import br.example.escola.dominio.aluno.CPF;

public class AlunoNaoEncontradoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getDigitos());
    }
}
