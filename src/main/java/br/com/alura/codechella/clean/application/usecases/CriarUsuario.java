package br.com.alura.codechella.clean.application.usecases;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;

public class CriarUsuario {
    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return this.repositorio.cadastrarUsuario(usuario);
    }
}
