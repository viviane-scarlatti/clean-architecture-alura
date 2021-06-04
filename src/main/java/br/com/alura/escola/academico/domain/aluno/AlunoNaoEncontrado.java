package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.CPF;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF: " + cpf.getNumero());
    }
}
