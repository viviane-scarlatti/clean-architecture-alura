package br.com.alura.escola.shared.domain.evento;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {

    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte) {
        this.ouvintes.add(ouvinte);
    }

    public void publicarEvento(Evento evento) {
        this.ouvintes.forEach(ouvinte -> {
            ouvinte.processa(evento);
                });
    }

}
