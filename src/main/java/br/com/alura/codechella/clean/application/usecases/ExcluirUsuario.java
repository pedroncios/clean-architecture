package br.com.alura.codechella.clean.application.usecases;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {
    private final RepositorioDeUsuario repositorioDeUsuario;

    public ExcluirUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public void excluirUsuario(String cpf) {
        this.repositorioDeUsuario.excluirUsuario(cpf);
    }
}
