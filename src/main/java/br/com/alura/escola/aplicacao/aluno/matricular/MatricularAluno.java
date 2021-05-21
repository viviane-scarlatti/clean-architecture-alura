package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorioDeAluno;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAluno) {
        this.repositorioDeAluno = repositorioDeAluno;
    }

    // Pattern: Command
    public void executa(MatriculaAlunoDTO dados) {
        Aluno novoAluno = dados.criarAluno();
        repositorioDeAluno.matricular(novoAluno);
    }
}
