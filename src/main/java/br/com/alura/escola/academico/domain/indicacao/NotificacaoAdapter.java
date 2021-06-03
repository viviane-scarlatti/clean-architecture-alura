package br.com.alura.escola.academico.domain.indicacao;

import br.com.alura.escola.academico.domain.aluno.Aluno;

public interface NotificacaoAdapter {
    void enviarEmailPara(Aluno indicado);
}
