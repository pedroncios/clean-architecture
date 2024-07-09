A `inversão de controle` é um princípio de design que complementa a `injeção de dependência`.

Ele sugere que a responsabilidade pela configuração e gerenciamento das dependências de um objeto seja invertida, 
ou seja, delegada a um componente externo (geralmente um contêiner de IoC) em vez de ser realizada internamente pelo próprio objeto.

Em vez de os objetos serem responsáveis por criar e gerenciar suas próprias dependências, eles delegam essa responsabilidade a um mecanismo externo. Isso permite uma maior flexibilidade e desacoplamento entre os componentes, pois as dependências podem ser facilmente substituídas ou configuradas sem alterar o código dos objetos dependentes.

Os objetos são configurados e gerenciados externamente por meio de arquivos de configuração ou anotações, permitindo uma configuração mais flexível e uma fácil substituição de dependências.

