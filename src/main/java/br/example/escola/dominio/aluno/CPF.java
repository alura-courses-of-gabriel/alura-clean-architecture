package br.example.escola.dominio.aluno;

public class CPF {
    private String digitos;

    public CPF(String digitos) {

        validarDigitos(digitos);

        this.digitos = digitos;
    }

    private void validarDigitos(String digitos) {
        if (digitos == null || !digitos.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$")){
            throw new IllegalArgumentException("escola.CPF inválido");
        }
    }

    public String getDigitos() {
        return digitos;
    }
}
