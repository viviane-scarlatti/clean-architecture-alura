package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.domain.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.academico.domain.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    private final RepositorioDeAlunos repositorioDeAluno;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorioDeAluno, PublicadorDeEventos publicador) {
        this.repositorioDeAluno = repositorioDeAluno;
        this.publicador = publicador;
    }

    // Pattern: Command
    public void executa(MatriculaAlunoDTO dados) {
        Aluno novoAluno = dados.criarAluno();
        AlunoMatriculado evento = new AlunoMatriculado(novoAluno.getCpf());
        repositorioDeAluno.matricular(novoAluno);
        publicador.publicarEvento(evento);
    }
}
