package br.com.alura.escola.academico.integration.indicacao;

import br.com.alura.escola.academico.domain.indicacao.NotificacaoAdapter;
import br.com.alura.escola.academico.domain.aluno.Aluno;

public class Notificacao implements NotificacaoAdapter {
    @Override
    public void enviarEmailPara(Aluno indicado) {
        // TODO: lógica de envio de emails com a lib Java Mail
    }
}
