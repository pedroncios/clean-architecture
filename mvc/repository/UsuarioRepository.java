package br.com.alura.codechella.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.codechella.mvc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
