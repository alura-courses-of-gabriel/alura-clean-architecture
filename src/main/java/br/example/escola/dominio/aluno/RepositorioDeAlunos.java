package br.example.escola.dominio.aluno;

import java.util.List;

public interface RepositorioDeAlunos {
    void matricular(Aluno aluno);
    Aluno buscarAlunoPorCPF(CPF cpf);
    List<Aluno> listarTodosAlunosMatriculados();
}
