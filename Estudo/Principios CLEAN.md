# Princípios Arquitetura CLEAN

Quais eram os cinco problemas que **Uncle Bob** gostaria de resolver com essa arquitetura?

## Independente de Framework

Na nossa aplicação, poderíamos pegar o pacote `application` e `domain` e jogar para outro framework?

Sim, pois todo o nosso domínio, regras de negócio e interfaces estão protegidos. Então, podemos literalmente eliminar tudo de framework e usar essa aplicação inteira em outro framework qualquer, porque temos código Java puro.

## Testabilidade

Além disso, nossa aplicação é testável? Sim, as `regras de negócio` podem ser facilmente testadas, pois o isolamento do `domínio`
permite de forma simples a criação de `testes unitários`. Por exemplo, no teste do CPF para conferir se lançaria uma exceção se tentássemos cadastrar um usuário com o CPF indevido.

Com essa arquitetura, conseguimos fazer uma aplicação altamente testável, com testes unitários - `independente de ter que subir um ambiente gigantesco para fazê-lo`.

## Independente de UI

Ela também está independente do tipo de `interface gráfica`? Sim. 
Não importa se a pessoa terá uma aplicação web ou mobile, na hora que ela se conectar com a nossa aplicação, o nosso `domínio` e as nossas `regras` estão isentas de interface gráfica.

## Independente de BD

Está independente de banco de dados? Sim, através da implementação de novos `repositorios` é possível manipular e persistir os dados, tanto gravar em um banco relacional quanto em um arquivo ou memória. E, caso quiséssemos fazer outra implementação para um banco NoSQL, seria possível fazê-lo também.

## Independente de Agentes Externos

Por fim, queremos saber se está independente de qualquer `agente externo`? Sim. Os pacotes de `domain` e `application` estão independentes. Não importa se vamos fazer um deploy na AWS, se vamos usar a Kubernetes ou Docker.