package br.com.alura.escola.shared.domain.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {

    LocalDateTime momentoDoEvento();
    TipoDeEvento tipoDeEvento();
    Map<String, Object> informacoes();
}
