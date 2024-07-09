# Camada DOMAIN

Classes dentro da camada **Domain** são entidades que `encapsulam o estado e o comportamento da aplicação` (regras de negócio) e são
`independentes` de qualquer detalhe de implementação, como frameworks, databases, etc.
Isso facilita a `testabilidade`, isolando os casos de uso.

Classes da camada Domain `não podem` referenciar classes fora da camada, pois isto vai contra os princípios da arquitetura **CLEAN**.

### Entidades e Objetos de Valor

As `Entidades` encapsulam a lógica de negócios central da aplicação e representam conceitos com identidade própria e ciclo de vida longo.

Por outro lado, os `Value Objects` representam valores que são importantes para o domínio, mas não têm identidade própria sendo usados principalmente para definir tipos imutáveis e semânticos.

* **Entities** precisam ter um campo que sirva de `identificador único`, por exemplo,
uma entidade **Usuario** tem um único atributo CPF que representa o seu identificador. 
* **Entities** são `mutáveis` e **Value Objects** são `imutáveis`.
* A diferença entre uma **Entity** e um **Value Object** é que no **Value Object** `todos os campos juntos servem de identificador` para o objeto.
* As **Entities** são normalmente organizadas em `pacotes separados` dentro da camada **Domain**, 
já os **Value Objects** normalmente ficam `na raiz` da camada **Domain**.