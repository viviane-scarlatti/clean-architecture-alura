package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.domain.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.domain.selo.Selo;
import br.com.alura.escola.shared.domain.CPF;
import br.com.alura.escola.shared.domain.evento.Evento;
import br.com.alura.escola.shared.domain.evento.Ouvinte;
import br.com.alura.escola.shared.domain.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "nomeDoSelo");
        repositorioDeSelos.adicionar(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipoDeEvento() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
