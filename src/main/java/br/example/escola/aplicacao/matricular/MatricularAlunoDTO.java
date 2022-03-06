package br.example.escola.aplicacao.matricular;

import br.example.escola.dominio.aluno.Aluno;
import br.example.escola.dominio.aluno.FabricaDeAluno;

public record MatricularAlunoDTO(String nome, String cpf, String email){

    public Aluno criarAluno() {
        return new FabricaDeAluno()
                .comNome(this.nome)
                .comCpf(this.cpf)
                .comEmail(this.email)
                .construir();
    }
}
