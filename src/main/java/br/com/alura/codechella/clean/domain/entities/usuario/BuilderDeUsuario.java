package br.com.alura.codechella.clean.domain.entities.usuario;

import br.com.alura.codechella.clean.domain.Endereco;

import java.time.LocalDate;

/*
 * O Padrão Builder é usado para construir um objeto complexo passo a passo.
 * Ele permite que você produza diferentes tipos e representações de um objeto usando o mesmo código de construção.
 * Geralmente, ele é usado quando o construtor de um objeto tem muitos parâmetros opcionais ou quando a criação de um objeto envolve várias etapas complicadas.
 */

public class BuilderDeUsuario {
    private Usuario usuario;

    public BuilderDeUsuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        this.usuario = new Usuario(cpf, nome, nascimento, "");
        return this;
    }

    public BuilderDeUsuario incluiEndereco(String rua, Integer numero, String complemento, String cep) {
        this.usuario.setEndereco(new Endereco(rua, numero, complemento, cep));
        return this;
    }

    public Usuario build() {
        return this.usuario;
    }
}
