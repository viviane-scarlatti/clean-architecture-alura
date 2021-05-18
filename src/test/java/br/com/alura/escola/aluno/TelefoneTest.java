package br.com.alura.escola.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {

    @Test
    void testNaoDeveriaCriarTelefoneComDDDsInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null, "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("", "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1", "123456789"));
    }
}
