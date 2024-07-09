# Java Records

* Um Record, nada mais é que um tipo de classe que armazena dados.
É a mesma ideia de construção similar a um `JavaBean`, possui **construtor**, **atributos** e **métodos acessores**.
Porém, ao invés de possibilitar qualquer alteração a classe é `imutável`. Também possui os métodos **equals**, **hashCode** e **toString()**.
* Records estão disponíveis a partir do `Java 14`.
* Usualmente são utilizados para substituir **DTOs** (`Data Transfer Objects`).

### Exemplo

A declaração de um Record é simplificada, os atributos são passados como parâmetro, não sendo necessário a declaração de
métodos `getters` e `setters`, uma vez que os dados são **imutáveis**.

```java
    // Declaração
    public record User(String name, String password) { }

    // Instanciação
    User user = new User("admin", "senha");
```

Por não possuir `getters` o acesso aos atributos é ligeiramente diferente: 

```java
    String name = user.name();
```