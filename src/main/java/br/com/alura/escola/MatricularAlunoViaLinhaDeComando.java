package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatriculaAlunoDTO;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.integration.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.domain.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.integration.aluno.AlunosRepositoryEmMemoria;

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Nome";
        String cpf = "176.599.950-22";
        String email = "aaa@email.com";

        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

        MatricularAluno matricularAluno = new MatricularAluno(new AlunosRepositoryEmMemoria(),
                publicadorDeEventos);
        matricularAluno.executa(new MatriculaAlunoDTO(nome, cpf, email));
    }
}
