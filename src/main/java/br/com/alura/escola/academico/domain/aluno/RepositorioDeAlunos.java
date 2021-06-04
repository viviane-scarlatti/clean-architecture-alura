package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.CPF;

import java.util.List;

public interface RepositorioDeAlunos {
    void matricular(Aluno aluno);
    Aluno buscarPorCPF(CPF cpf);
    List<Aluno> listarTodosAlunosMatriculados();
}
