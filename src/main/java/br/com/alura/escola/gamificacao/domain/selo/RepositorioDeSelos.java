package br.com.alura.escola.gamificacao.domain.selo;

import br.com.alura.escola.shared.domain.CPF;

import java.util.List;

public interface RepositorioDeSelos {

    void adicionar(Selo selo);
    List<Selo> selosDoAlunoDeCPF(CPF cpf);
}
