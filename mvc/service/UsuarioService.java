package br.com.alura.codechella.mvc.service;

import br.com.alura.codechella.mvc.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
