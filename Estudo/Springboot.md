# Spring boot

No Spring, os componentes da aplicação são geralmente gerenciados pelo contêiner Spring.

Para que um objeto seja gerenciado pelo Spring, ele deve ser marcado com uma anotação que o identifique como um componente Spring.
As anotações mais comuns para isso são `@Component`, `@Service`, `@Repository` e `@Controller`, 
dependendo do tipo de componente que está sendo definido.

Uma vez que os componentes da aplicação estão sendo gerenciados pelo Spring, é possível injetar dependências neles usando anotações. 
A anotação mais comum para realizar a injeção de dependência é `@Autowired`. 
Quando um componente é marcado com `@Autowired`, o Spring procura automaticamente uma instância adequada do tipo de dependência e a injeta no componente.

Para que o Spring reconheça e gerencie os componentes da aplicação, é necessário configurar o escaneamento de componentes no arquivo 
de configuração do Spring (`geralmente um arquivo XML ou uma classe de configuração Java`), exatamente como a implementação da classe 
`UsuarioConfig` utilizando a anotação `@Configuration` e também anotando os métodos com a anotação `@Bean`, utilizada para definir 
métodos que produzem instâncias de objetos que serão gerenciados pelo contêiner Spring.

### Beans

* O Spring utiliza `Beans` para injetar as dependências quando sobe a aplicação.
* Para isto é necessário utilizar a annotation `@Bean`.

No caso desta aplicação, temos um ponto de entrada do Spring no `UsuarioController` (`/usuarios`)
que necessita de uma instância do `CriarUsuario`:

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    public UsuarioController(CriarUsuario criarUsuario) {
        this.criarUsuario = criarUsuario;
    }

    //...
}
```
Logo, é necessário criar um **Bean** para o `CriarUsuario`, dessa forma o Spring consegue injetar a instância quando precisar:

```java
@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }
}
```

Como o `CriarUsuario` também precisa de uma instância externa (`RepositorioDeUsuario`), também é necessário um **Bean** para ele:

```java
@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }
}
```