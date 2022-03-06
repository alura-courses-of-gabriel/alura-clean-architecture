package br.example.escola.aplicacao.indicacao;

import br.example.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
