package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.evento.Evento;
import br.com.alura.escola.shared.domain.CPF;
import br.com.alura.escola.shared.domain.evento.TipoDeEvento;

import java.time.LocalDateTime;
import java.util.Map;

public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momentoDoEvento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipoDeEvento() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }
}
