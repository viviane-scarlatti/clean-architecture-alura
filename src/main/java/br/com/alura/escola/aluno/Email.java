package br.com.alura.escola.aluno;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
