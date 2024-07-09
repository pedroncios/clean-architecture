package br.com.alura.codechella.clean.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarCPFInvalido() {
        IllegalArgumentException exception;
        String erroMessage = "CPF no padrão incorreto";
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("", "nome", LocalDate.parse("1900-01-01"), "teste@teste.com"));
        Assertions.assertEquals(erroMessage, exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("12312312312", "nome", LocalDate.parse("1900-01-01"), "teste@teste.com"));
        Assertions.assertEquals(erroMessage, exception.getMessage());
    }

    @Test
    public void naoDeveCadastrarEmailInvalido() {
        IllegalArgumentException exception;
        String erroMessage = "Email no padrão incorreto";
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.123.123-00", "nome", LocalDate.parse("1900-01-01"), "aaaa"));
        Assertions.assertEquals(erroMessage, exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.123.123-00", "nome", LocalDate.parse("1900-01-01"), "teste@"));
        Assertions.assertEquals(erroMessage, exception.getMessage());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDeDezoitoAnos() {
        IllegalArgumentException exception;
        String erroMessage = "Usuário precisa ter mais de 18 anos";
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario("123.123.123-00", "nome", LocalDate.now().minusYears(17), ""));
        Assertions.assertEquals(erroMessage, exception.getMessage());
        Assertions.assertDoesNotThrow(() -> new Usuario("123.123.123-00", "nome", LocalDate.now().minusYears(18), ""));
    }

    @Test
    public void deveCriarUsuarioUsandoBuilderDeUsuario() {
        Usuario usuario = new BuilderDeUsuario()
            .comNomeCpfNascimento("Josisvaldo", "000.000.000-00", LocalDate.parse("1900-01-01"))
            .incluiEndereco("Rua teste", 123, "Complemento teste", "80000-000")
            .build();

        Assertions.assertEquals("Josisvaldo", usuario.getNome());
        Assertions.assertEquals("000.000.000-00", usuario.getCpf());
        Assertions.assertEquals("1900-01-01", usuario.getNascimento().toString());
        Assertions.assertEquals("Rua teste", usuario.getEndereco().getRua());
        Assertions.assertEquals(123, usuario.getEndereco().getNumero());
        Assertions.assertEquals("Complemento teste", usuario.getEndereco().getComplemento());
        Assertions.assertEquals("80000-000", usuario.getEndereco().getCep());
    }
}
