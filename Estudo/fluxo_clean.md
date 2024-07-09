# Exemplo de fluxo

O `Controller` seria o garçom, que recebe seu pedido (requisição HTTP) e o anota (processa os parâmetros de entrada).

O `Use Case Input Port` seria o cardápio, que lista os pratos disponíveis (serviços oferecidos pela aplicação).

O `Use Case Interactor` seria o cozinheiro, que prepara o seu pedido (lógica de negócios) usando os ingredientes (dados) do estoque (Output Ports).

O `Use Case Output Port` seria a forma como o cozinheiro entrega o prato pronto, como em um prato ou em uma embalagem para viagem (saída de dados).

O `Presenter` seria o garçom que apresenta o prato para você, de forma organizada e bonita (formata os resultados para a interface do usuário).

> Assim, o garçom (Controller) recebe seu pedido, consulta o cardápio (Use Case Input Port), o cozinheiro (Use Case Interactor) prepara o prato e o garçom (Presenter) te entrega.

A Clean Architecture, como nesse exemplo, separa as responsabilidades, deixando o código mais organizado e fácil de entender e modificar.