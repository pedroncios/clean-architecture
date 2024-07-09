package br.com.alura.codechella.clean.infra.gateways;

import br.com.alura.codechella.clean.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;
import br.com.alura.codechella.clean.infra.persistance.UsuarioEntity;
import br.com.alura.codechella.clean.infra.persistance.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = this.mapper.toEntity(usuario);
        this.repositorio.save(entity);
        return this.mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.repositorio.findAll().stream()
                .map(u -> mapper.toDomain(u))
                .collect(Collectors.toList());
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        UsuarioEntity entity = this.repositorio.findByCpf(cpf);
        if(entity != null) {
            var atualizado = this.mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            this.repositorio.save(atualizado);
            return this.mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        UsuarioEntity entity = this.repositorio.findByCpf(cpf);
        this.repositorio.deleteById(entity.getId());
    }
}
