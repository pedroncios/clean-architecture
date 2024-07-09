package br.com.alura.codechella.clean.application.gateways;

import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {
    Usuario cadastrarUsuario(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario alteraUsuario(String cpf, Usuario usuario);
    void excluirUsuario(String cpf);
}
