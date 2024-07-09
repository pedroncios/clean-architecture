package br.com.alura.codechella.clean.application.usecases;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    private final RepositorioDeUsuario repositorioDeUsuario;

    public AlterarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        this.repositorioDeUsuario = repositorioDeUsuario;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return this.repositorioDeUsuario.alteraUsuario(cpf, usuario);
    }
}
