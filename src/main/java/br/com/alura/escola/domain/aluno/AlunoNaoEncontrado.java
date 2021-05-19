package br.com.alura.escola.domain.aluno;

import br.com.alura.escola.domain.aluno.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumero());
    }
}
