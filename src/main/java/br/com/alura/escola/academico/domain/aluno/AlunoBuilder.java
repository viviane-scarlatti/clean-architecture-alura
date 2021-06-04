package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.CPF;

public class AlunoBuilder {

    private Aluno aluno;

    public AlunoBuilder comCPFNomeEmail(String cpf, String nome, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome,  new Email(email));
        return this;
    }

    public AlunoBuilder comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criarAluno() {
        return this.aluno;
    }

}
