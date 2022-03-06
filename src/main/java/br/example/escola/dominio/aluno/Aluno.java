package br.example.escola.dominio.aluno;

import java.util.List;

public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones;
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(Telefone telefone) {
        this.telefones.add(telefone);
    }

    public void adicionarTelefone(String ddd, String numero) {
        Telefone telefone = new Telefone(ddd, numero);
        this.adicionarTelefone(telefone);
    }

    public String getCpf() {
        return this.cpf.getDigitos();
    }

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return this.telefones;
    }
}
