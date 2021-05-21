package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.integration.aluno.AlunosRepositoryEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        AlunosRepositoryEmMemoria repositorio = new AlunosRepositoryEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatriculaAlunoDTO dados = new MatriculaAlunoDTO("nome", "176.599.950-22",
                "nome@email.com");
        useCase.executa(dados);

        Aluno alunoRetornado = repositorio.buscarPorCPF(new CPF("176.599.950-22"));

        assertEquals("nome", alunoRetornado.getNome());
        assertEquals("176.599.950-22", alunoRetornado.getCpf().getNumero());
        assertEquals("nome@email.com", alunoRetornado.getEmail().getEndereco());
    }
}