package br.com.alura.codechella.clean.application.usecases;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {
    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuarios() {
        return this.repositorio.listarTodos();
    }
}
