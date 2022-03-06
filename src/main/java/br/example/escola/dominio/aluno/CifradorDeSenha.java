package br.example.escola.dominio.aluno;

public interface CifradorDeSenha {
    String cifrar(String senha);

    Boolean validarSenha(String senhaCifrada, String senha);
}
