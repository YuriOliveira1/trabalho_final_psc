
# Trabalho Prático: Programação de Soluções Computacionais



## Tecnologias

- Java


# Estrutura do Trabalho

## 1. Proposta: 

Nossa proposta é voltado para doações de cabelo, maquiagem, lenços e dinheiro para uma organização que auxilia mulheres com câncer, principalmente de mama. Após a quimioterapia, muitas mulheres enfrentam a perda de cabelo, o que pode afetar significativamente sua autoestima. Nosso objetivo é fornecer apoio e recursos para ajudá-las a enfrentar essa fase com mais confiança e dignidade.

A ideia foi sugerida pela mãe do integrante Yuri de Oliveira(Link), que trabalhou em uma clínica chamada OncoMinas, localizada em Extrema-MG. OncoMinas é uma clínica oncológica que atende diversos pacientes com câncer. Uma das campanhas realizadas por essa clínica foi a "Campanha Laço Rosa", cujo principal objetivo era receber doações de cabelo, lenços e maquiagem para aumentar a autoestima das mulheres em tratamento

## 2. Solicitando os Requisitos Funcionais

Para solicitar os Requisitos Funcionais de nossa proposta, utilizamos o ChatGPT como ferramenta de auxílio. No meu primeiro prompt, detalhei a proposta do nosso projeto, explicando a ideia principal: desenvolver um software para gerenciar doações. Com base nisso, o ChatGPT gerou diversas funções que poderiam ser incorporadas ao nosso software. Após analisar as sugestões, identifiquei que algumas funcionalidades estavam faltando, como a capacidade de armazenar dados em arquivos TXT e gerar pequenos relatórios.

Para adequar melhor o software ao que está sendo planejado e solicitado, solicitei um segundo prompt para corrigir e melhorar as requisições. Com essa nova solicitação, percebi que as sugestões estavam mais alinhadas com nossas necessidades. Decidi então fazer alguns ajustes finais, removendo funcionalidades que, em minha visão, não são necessárias no momento, como o cadastro de usuários e beneficiários, pois no projeto de referência que estamos utilizando, essas informações serão organizadas de uma forma diferente, que será explicada em um vídeo.

### 2.1. Requisitos Funcionais:

- **Cadastro de Doações:** O sistema deve ser capaz de registrar diferentes tipos de doações, tais como maquiagem, cabelo, lenços e dinheiro. Além disso, ele deve permitir que o usuário insira especificações detalhadas para cada doação, como tipo, quantidade, data da doação, cores, Nome/Apelido(Apenas para uma  breve Identificação).
- **Armazenar as Doações:** As informações das doações devem ser armazenadas em um arquivo de texto (TXT), proporcionando um controle e organização mais eficazes das doações realizadas.
- **Gerador de Relatorio:** O sistema deve incluir uma opção para gerar relatórios que exibam a quantidade de cada tipo de item doado, como maquiagem, cabelo, dinheiro e lenços. Esses relatórios devem ser acessíveis ao usuário para proporcionar uma visão clara e detalhada das contribuições feitas
- **Tratamento de Exeções:** Para garantir o bom funcionamento do software, é crucial que os desenvolvedores estejam cientes dos possíveis erros e exceções que o código possa gerar. Nesse sentido, é necessário implementar um sistema de logs que registre essas ocorrências em um arquivo de texto (TXT). Isso permitirá uma análise detalhada dos eventos e facilitará a identificação e correção de problemas no software.

### 2.2. Prompts Usados:

- [Primeiro Prompt](https://docs.google.com/document/d/1Gl26gusF3mFw10VtmvV4dn3VEUjwsQNi4nP8vTXB3kU/edit?usp=sharing)
- [Segundo Prompt](https://docs.google.com/document/d/1VLhJtMMzkSgRy0ryF72P3VVOF68CP-fIE2KJ9Tmxnmo/edit?usp=sharing)
- [Terceiro Prompt](https://docs.google.com/document/d/1o729OxRmQf2MTi7RLdPO8rRgJph8U7Zfiz2lwwGpUBI/edit?usp=sharing)

## 3. Falando de Críticas 

Após analisar os resultados dos três prompts que enviei, concluí que, às vezes, o ChatGPT pode fornecer respostas além do solicitado. Isso pode ser uma faca de dois gumes: dependendo do contexto, pode gerar bons resultados ou causar perda de tempo ao tentar corrigir excessos. Outro ponto importante é que, ao gerar requisitos funcionais, o modelo frequentemente utiliza exemplos de diversas fontes, aplicando-os à sua requisição sem que isso tenha sido explicitamente solicitado.

Na criação das classes e das funções iniciais, parecia estar tudo certo, mas no decorrer do desenvolvimento do sistema, boa parte do que ele gerou tive que reconstruir do zero ou parcialmente. O GPT foi importante para gerar uma boa base para a construção do projeto, ajudando-me também a ter mais ideias de funções ou de como contornar algo confuso que ele gerou, transformando em algo bom na minha visão.


Além desses pequenos pontos negativos, observei também uma geração de texto interessante por parte do GPT. Ele me forneceu uma função de cadastro de login e senha e, ao final, incluiu uma seção sobre segurança da informação dos indivíduos que participam do sistema de doações. Achei esse tópico relevante para comentar, dado o cenário atual. É crucial entender como um projeto similar funcionaria na prática, onde o anonimato é levado muito a sério para evitar constrangimentos para os envolvidos e prevenir que as doações sejam utilizadas para promoções pessoais ou de organizações específicas.


## 4. Diagrama de Classes

O sistema de Gestão de Doações é composto por várias classes que interagem para facilitar o cadastro, armazenamento, gestão e geração de relatórios de doações de itens e dinheiro. A seguir, descrevemos cada classe, suas propriedades, métodos e como elas se relacionam.

### 4.1. Prompts Usados:

**Classes Principais:**

**Classe Doacao:**

**Propriedades:**
```
tipo: String - Indica o tipo de doação (cabelo, maquiagem, lenços).

quantidade: int - Especifica a quantidade doada.

data: Date - Data em que a doação foi realizada.

doador: Doador - Referência à classe Doador que realizou a doação.
```

**Métodos:**
```
registrarDoacao() - Registra a doação no sistema.

```
**Classe DoacaoDinheiro**

**Propriedades:**
```
valor: float - Especifica o valor da doação em dinheiro.

data: Date - Data em que a doação foi realizada.

doador: Doador - Referência à classe Doador que realizou a doação.

```
**Métodos:**
```
registrarDoacaoDinheiro() - Registra a doação em dinheiro no sistema.

converterParaItem() - Converte a doação em dinheiro para doações de itens.

```
**Classe Doador**

**Propriedades:**
```
apelido: String - Apelido do doador.

contato: String - Número de contato do doador.
```
**Métodos:**
```
cadastrarDoador() - Cadastra um novo doador no sistema.
```
**Classe Relatorio**

**Propriedades:**
```
dataInicio: Date - Data de início do período do relatório.

dataFim: Date - Data de fim do período do relatório.

tipoRelatorio: String - Tipo de relatório (geral, por tipo de doação, financeiro).
```
**Métodos:**
```
gerarRelatorioGeral() - Gera um relatório geral de todas as doações.
```
**Classe SistemaGestaoDoacoes**

**Propriedades:**
```
listaDoacoes: List<Doacao> - Lista de todas as doações registradas.

listaDoacoesDinheiro: List<DoacaoDinheiro> - Lista de todas as doações em dinheiro registradas.

listaDoadores: List<Doador> - Lista de todos os doadores cadastrados.
```
**Métodos:**
```
adicionarDoacao(Doacao) - Adiciona uma nova doação ao sistema.

adicionarDoacaoDinheiro(DoacaoDinheiro) - Adiciona uma nova doação em dinheiro ao sistema.

adicionarDoador(Doador) - Adiciona um novo doador ao sistema.

buscarDoacoesPorTipo(String) - Busca doações filtradas por tipo.
```
### 4.2. Relações entre as Classes:

- A classe Doacao tem uma associação com a classe Doador, onde cada doação é vinculada a um doador específico.

- A classe DoacaoDinheiro também tem uma associação com a classe Doador.

- A classe SistemaGestaoDoacoes possui agregações das classes Doacao, DoacaoDinheiro e Doador, mantendo listas de todas as doações e doadores.

- A classe Relatorio depende da classe SistemaGestaoDoacoes para acessar as listas de doações e gerar relatórios baseados nos dados.

## 5. Estratégia de Programação com IA:

Na parte de utilização de uma estratégia específica, acabei optando por utilizar todas as que estavam ao meu alcance e atendiam às minhas necessidades. No início, utilizei o GPT para me ajudar a entender as diferenças entre FileWriter e PrintWriter e qual seria a melhor opção para a minha necessidade. Também fiz mais perguntas sobre a utilização do append e a combinação entre FileWriter e PrintWriter. Outra pergunta que fiz foi sobre o uso da classe Date para trabalhar com datas. Após isso, pedi mais explicações e exemplos sobre o uso de diferentes tipos de patterns que eu poderia implementar no meu programa.

Acabei utilizando o GPT mais no início do desenvolvimento do meu programa, pois foi quando surgiram mais dúvidas em relação à leitura de arquivos, utilização de datas e algumas tomadas de decisões para determinar qual abordagem seria mais adequada e eficiente para cada situação. No momento atual do desenvolvimento, estou utilizando o GPT para a correção de métodos, verificando se haverá algum problema com o buffer do Scanner ou se há algo que poderia ser um erro óbvio. Após passar por essa verificação, realizo meus próprios testes.

Aprofundando um pouco nos conhecimentos e ideias, acabei estudando sobre Generics. Tive a ideia de armazenar certos objetos em uma lista e pensei em utilizá-la, mas não foi necessário. Também aprendi a utilizar o final para organizar os arquivos que precisava. Outra coisa que aprendi de forma bastante prática foram as Exceptions e como eu poderia criar as minhas próprias Exceptions.
