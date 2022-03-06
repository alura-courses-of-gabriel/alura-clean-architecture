package br.example.escola;

import br.example.escola.aplicacao.matricular.MatricularAluno;
import br.example.escola.aplicacao.matricular.MatricularAlunoDTO;
import br.example.escola.infraestrutura.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoPorLinhaComando {
    public static void main(String[] args) {

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());

        matricular.executar(new MatricularAlunoDTO("Fulano da Silva", "123.456.780-99", "fulano@email.com"));

    }
}
