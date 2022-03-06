package br.example.escola.infraestrutura.aluno;

import br.example.escola.dominio.aluno.CifradorDeSenha;

public class CifradorDeSenhaMD5 implements CifradorDeSenha {

    @Override
    public String cifrar(String senha) {
        return senha.replace("a", "b");
    }

    @Override
    public Boolean validarSenha(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrar(senha));
    }
}
