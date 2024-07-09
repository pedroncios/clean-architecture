package br.com.alura.codechella.clean.infra.controller;

import br.com.alura.codechella.clean.application.usecases.AlterarUsuario;
import br.com.alura.codechella.clean.application.usecases.CriarUsuario;
import br.com.alura.codechella.clean.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.clean.application.usecases.ListarUsuarios;
import br.com.alura.codechella.clean.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AlterarUsuario alterarUsuario;
    private final ExcluirUsuario excluirUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AlterarUsuario alterarUsuario, ExcluirUsuario excluirUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alterarUsuario = alterarUsuario;
        this.excluirUsuario = excluirUsuario;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuarioSalvo = this.criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDTO> listarTodosUsuarios() {
        return this.listarUsuarios.obterTodosUsuarios().stream()
                .map(u -> new UsuarioDTO(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{cpf}")
    public UsuarioDTO atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDTO dto) {
        Usuario atualizado = this.alterarUsuario.alteraDadosUsuario(cpf, new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        this.excluirUsuario.excluirUsuario(cpf);
    }
}
