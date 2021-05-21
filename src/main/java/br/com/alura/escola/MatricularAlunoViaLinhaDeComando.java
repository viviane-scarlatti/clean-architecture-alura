package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatriculaAlunoDTO;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.integration.aluno.AlunosRepositoryEmMemoria;

public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Nome";
        String cpf = "176.599.950-22";
        String email = "aaa@email.com";

        MatricularAluno matricularAluno = new MatricularAluno(new AlunosRepositoryEmMemoria());
        matricularAluno.executa(new MatriculaAlunoDTO(nome, cpf, email));
    }
}