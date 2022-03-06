package br.example.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class FabricaDeAluno {
    private String nome;
    private String cpf;
    private String email;
    private List<Telefone> telefones;

    public FabricaDeAluno() {
        this.telefones = new ArrayList<>();
    }

    public FabricaDeAluno comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FabricaDeAluno comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public FabricaDeAluno comEmail(String email) {
        this.email = email;
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
        return this;
    }

    public Aluno construir() {
        Aluno aluno = new Aluno(new CPF(this.cpf), this.nome, new Email(this.email));
        this.telefones.forEach(aluno::adicionarTelefone);
        return aluno;
    }

}
