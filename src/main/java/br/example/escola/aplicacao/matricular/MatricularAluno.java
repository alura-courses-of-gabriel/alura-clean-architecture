package br.example.escola.aplicacao.matricular;

import br.example.escola.dominio.aluno.Aluno;
import br.example.escola.dominio.aluno.FabricaDeAluno;
import br.example.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorioDeAlunos;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAlunos) {
        this.repositorioDeAlunos = repositorioDeAlunos;
    }

    public void executar(MatricularAlunoDTO alunoDTO) {
        Aluno aluno = alunoDTO.criarAluno();
        this.repositorioDeAlunos.matricular(aluno);
    }
}
