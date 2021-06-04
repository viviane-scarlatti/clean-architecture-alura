package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.shared.domain.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.domain.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.domain.aluno.Aluno;
import br.com.alura.escola.shared.domain.CPF;
import br.com.alura.escola.academico.integration.aluno.AlunosRepositoryEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        AlunosRepositoryEmMemoria repositorio = new AlunosRepositoryEmMemoria();
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repositorio, publicadorDeEventos);

        MatriculaAlunoDTO dados = new MatriculaAlunoDTO("nome", "176.599.950-22",
                "nome@email.com");
        useCase.executa(dados);

        Aluno alunoRetornado = repositorio.buscarPorCPF(new CPF("176.599.950-22"));

        assertEquals("nome", alunoRetornado.getNome());
        assertEquals("176.599.950-22", alunoRetornado.getCpf().getNumero());
        assertEquals("nome@email.com", alunoRetornado.getEmail().getEndereco());
    }
}
