package br.example.escola.infraestrutura.aluno;

import br.example.escola.dominio.AlunoNaoEncontradoException;
import br.example.escola.dominio.aluno.Aluno;
import br.example.escola.dominio.aluno.CPF;
import br.example.escola.dominio.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados;

    public RepositorioDeAlunosEmMemoria() {
        this.matriculados = new ArrayList<>();
    }

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        return matriculados
                .stream()
                .filter(aluno -> aluno.getCpf().equals(cpf.getDigitos()))
                .findFirst().get();
//                .orElse(() -> throw new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
