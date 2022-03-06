package br.example.escola.dominio.indicacao;

import br.example.escola.dominio.aluno.Aluno;

import java.time.LocalDateTime;

public class Indicacao {
    private Aluno indicador;
    private Aluno indicado;
    private LocalDateTime data;

    public Indicacao(Aluno indicador, Aluno indicado) {
        this.indicador = indicador;
        this.indicado = indicado;
        this.data = LocalDateTime.now();
    }
}
