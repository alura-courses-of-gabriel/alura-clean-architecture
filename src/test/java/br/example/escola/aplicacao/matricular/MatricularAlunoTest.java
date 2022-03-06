package br.example.escola.aplicacao.matricular;

import br.example.escola.dominio.aluno.Aluno;
import br.example.escola.dominio.aluno.CPF;
import br.example.escola.infraestrutura.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatricularAlunoTest {

    @Test
    public void alunoMatriculadoDeveSerPersistido() {
        RepositorioDeAlunosEmMemoria repositorioDeAlunos = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorioDeAlunos);
        MatricularAlunoDTO alunoDTO = new MatricularAlunoDTO("Fulado", "000.000.000-00", "email@email.com");

        useCase.executar(alunoDTO);

        Aluno alunoEncontrado = repositorioDeAlunos.buscarAlunoPorCPF(new CPF(alunoDTO.cpf()));
        Assertions.assertEquals(alunoDTO.cpf(), alunoEncontrado.getCpf());
        Assertions.assertEquals(alunoDTO.nome(), alunoEncontrado.getNome());
        Assertions.assertEquals(alunoDTO.email(), alunoEncontrado.getEmail());


    }

}