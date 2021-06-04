package br.com.alura.escola.academico.domain.aluno;

import br.com.alura.escola.shared.domain.evento.Ouvinte;
import br.com.alura.escola.shared.domain.evento.Evento;

import java.time.format.DateTimeFormatter;

// Ouvinte de Evento
public class LogDeAlunoMatriculado extends Ouvinte {

    public void reageAo(Evento evento) {
        String momentoFormatado = evento.momentoDoEvento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
                ((AlunoMatriculado) evento).getCpfDoAluno(),
                momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
