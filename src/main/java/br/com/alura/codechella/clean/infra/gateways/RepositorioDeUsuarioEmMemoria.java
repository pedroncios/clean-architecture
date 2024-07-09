package br.com.alura.codechella.clean.infra.gateways;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;

import java.util.*;

public class RepositorioDeUsuarioEmMemoria implements RepositorioDeUsuario {
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        for(Usuario u : this.usuarios) {
            if(u.getCpf().equals(cpf)) {
                u.setCpf(usuario.getCpf());
                u.setNome(usuario.getNome());
                u.setEndereco(usuario.getEndereco());
                u.setNascimento(usuario.getNascimento());
                u.setEmail(usuario.getEmail());

                return u;
            }
        }

        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        this.usuarios.removeIf(usuario -> usuario.getCpf().equals(cpf));
    }
}
