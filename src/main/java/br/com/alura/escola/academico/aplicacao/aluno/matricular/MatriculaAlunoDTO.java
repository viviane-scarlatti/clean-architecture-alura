package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.shared.domain.CPF;
import br.com.alura.escola.academico.domain.aluno.Email;

public class MatriculaAlunoDTO {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatriculaAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}
