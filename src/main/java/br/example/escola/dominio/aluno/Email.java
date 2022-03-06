package br.example.escola.dominio.aluno;

public class Email {
    private String endereco;
    private final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public Email(String endereco){

        validarEndereco(endereco);

        this.endereco = endereco;
    }

    private void validarEndereco(String endereco) {
        if (endereco == null || !endereco.matches(this.regex)){
            throw new IllegalArgumentException("Email inválido");
        }
    }

    public String getEndereco() {
        return endereco;
    }
}