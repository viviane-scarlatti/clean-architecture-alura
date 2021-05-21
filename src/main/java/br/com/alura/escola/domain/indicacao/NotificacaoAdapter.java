package br.com.alura.escola.domain.indicacao;

import br.com.alura.escola.domain.aluno.Aluno;

public interface NotificacaoAdapter {
    void enviarEmailPara(Aluno indicado);
}
