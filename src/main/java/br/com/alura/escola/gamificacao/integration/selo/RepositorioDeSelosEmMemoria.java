package br.com.alura.escola.gamificacao.integration.selo;

import br.com.alura.escola.shared.domain.CPF;
import br.com.alura.escola.gamificacao.domain.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.domain.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return this.selos
                .stream()
                .filter(selo -> selo.getCpfDoALuno().equals(cpf))
                .collect(Collectors.toList());
    }
}
