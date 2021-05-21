package br.com.alura.escola.integration.aluno;

import br.com.alura.escola.domain.aluno.Aluno;
import br.com.alura.escola.domain.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.domain.aluno.CPF;
import br.com.alura.escola.domain.aluno.RepositorioDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class AlunosRepositoryEmMemoria implements RepositorioDeAlunos {

    private  List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().getNumero().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
