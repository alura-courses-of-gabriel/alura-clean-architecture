package br.example.escola.dominio.aluno;

public class Telefone {
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        validarDDD(ddd);
        validarNumero(numero);

        this.ddd = ddd;
        this.numero = numero;
    }

    private void validarDDD(String ddd) {
        if (ddd == null || ddd.length() < 2 || ddd.length() > 3) {
            throw new IllegalArgumentException("DDD inválido");
        }
    }

    private void validarNumero(String numero) {
        if (numero == null || numero.length() < 8 || numero.length() > 9) {
            throw new IllegalArgumentException("Numero inválido");
        }
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
