# Gateways

Os pacotes denominados `gateways` podem ser encontrados tanto no pacote de aplicação `application` quanto no pacote de infraestrutura `infra`. Embora ambos os tipos de gateways sirvam para lidar com interações externas ao núcleo da aplicação, eles têm propósitos e responsabilidades ligeiramente diferentes.

### Gateways APPLICATION

Os gateways no pacote de **aplicação** são responsáveis por definir `interfaces abstratas` ou contratos para interações externas necessárias para que os casos de uso (use cases) sejam executados.

Eles representam a maneira como os casos de uso interagem com o mundo externo e são definidos em termos de operações de alto nível que o sistema precisa realizar.

> Por exemplo, um **gateway de repositório** no pacote de aplicação pode definir uma interface `RepositorioDeUsuario` com métodos como `listarTodos`, `cadastrarUsuario`, `excluirUsuario` etc.
> Essa interface representa a maneira como os casos de uso interagem com o **armazenamento de dados**, mas não especifica a **implementação concreta** dessas operações.

### Gateways INFRA

Os gateways no pacote de **infraestrutura** são responsáveis por `implementar os contratos definidos` pelos gateways no pacote de aplicação. Eles fornecem **implementações concretas** para as operações definidas nas interfaces de gateway, utilizando tecnologias específicas de infraestrutura, como **acesso a bancos de dados**, **comunicação de rede** etc.

> Continuando com o exemplo anterior, no pacote de infraestrutura, poderíamos ter uma **implementação concreta** de `RepositorioDeUsuario`, usando `JDBC`, `JPA`, `Hibernate` ou qualquer outro framework de persistência.
> Essa implementação específica é responsável por traduzir as operações de alto nível definidas na interface de gateway em chamadas concretas para o banco de dados, como fizemos com a classe `RepositorioDeUsuarioJpa`.

### Resumo

Os gateways no pacote de `aplicação` definem **contratos abstratos para interações externas**, enquanto os gateways no pacote de `infraestrutura` fornecem **implementações concretas desses contratos** usando tecnologias específicas de infraestrutura.

Essa separação de responsabilidades e níveis de abstração permite que **a lógica de negócios da aplicação permaneça independente de detalhes de implementação** e facilite a substituição ou modificação das tecnologias de infraestrutura no futuro.