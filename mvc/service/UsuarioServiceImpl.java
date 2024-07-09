package br.com.alura.codechella.mvc.service;

import br.com.alura.codechella.mvc.model.Usuario;
import br.com.alura.codechella.mvc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class UsuarioServiceImpl implements UsuarioService {
    //@Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}
