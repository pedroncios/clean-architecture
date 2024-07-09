# Vale a pena utilizar arquitetura CLEAN?

Embora a clean architecture ofereça muitos benefícios, `aplicá-la integralmente pode ser excessivamente complexo` e rígido para algumas áreas do sistema que requerem maior flexibilidade e rapidez no desenvolvimento, como a interface de usuário ou a integração com serviços de terceiros.

Desta forma, aplicando arquitetura apenas nos módulos críticos, (Neste exemplo: gestão de ingressos e programação de shows),
podemos aproveitar os benefícios da clean architecture, como `testabilidade` e `separação de preocupações`, mantendo a flexibilidade 
em outras áreas menos críticas. Isso equilibra a `necessidade de um código bem estruturado` com a `agilidade necessária` em um ambiente de festival.