package br.com.alura.escola.gamificacao.domain.selo;

import br.com.alura.escola.academico.domain.aluno.CPF;

public class Selo {

    private CPF cpfDoALuno;
    private String nomeDoSelo;

    public Selo(CPF cpfDoALuno, String nomeDoSelo) {
        this.cpfDoALuno = cpfDoALuno;
        this.nomeDoSelo = nomeDoSelo;
    }

    public CPF getCpfDoALuno() {
        return cpfDoALuno;
    }

    public String getNomeDoSelo() {
        return nomeDoSelo;
    }
}
