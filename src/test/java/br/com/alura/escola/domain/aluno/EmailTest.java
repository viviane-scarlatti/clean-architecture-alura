package br.com.alura.escola.domain.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void testNaoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinválido"));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
    }

    //TODO: teste do caminho feliz
}