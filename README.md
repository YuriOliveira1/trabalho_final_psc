
# Trabalho Prático: Programação de Soluções Computacionais



## Tecnologias

- Java


# Estrutura do Trabalho

## 1. Proposta: 

Nossa proposta é voltado para doações de cabelo, maquiagem, lenços e dinheiro para uma organização que auxilia mulheres com câncer, principalmente de mama. Após a quimioterapia, muitas mulheres enfrentam a perda de cabelo, o que pode afetar significativamente sua autoestima. Nosso objetivo é fornecer apoio e recursos para ajudá-las a enfrentar essa fase com mais confiança e dignidade.

A ideia foi sugerida pela mãe do integrante Yuri de Oliveira, que trabalhou em uma clínica chamada OncoMinas, localizada em Extrema-MG. OncoMinas é uma clínica oncológica que atende diversos pacientes com câncer. Uma das campanhas realizadas por essa clínica foi a "Campanha Laço Rosa", cujo principal objetivo era receber doações de cabelo, lenços e maquiagem para aumentar a autoestima das mulheres em tratamento

## 2. Solicitando os Requisitos Funcionais

Para solicitar os Requisitos Funcionais de nossa proposta, utilizamos o ChatGPT como ferramenta de auxílio. No meu primeiro prompt, detalhei a proposta do nosso projeto, explicando a ideia principal: desenvolver um software para gerenciar doações. Com base nisso, o ChatGPT gerou diversas funções que poderiam ser incorporadas ao nosso software. Após analisar as sugestões, identifiquei que algumas funcionalidades estavam faltando, como a capacidade de armazenar dados em arquivos TXT e gerar pequenos relatórios.

Para adequar melhor o software ao que está sendo planejado e solicitado, solicitei um segundo prompt para corrigir e melhorar as requisições. Com essa nova solicitação, percebi que as sugestões estavam mais alinhadas com nossas necessidades. Decidi então fazer alguns ajustes finais, removendo funcionalidades que, em minha visão, não são necessárias no momento, como o cadastro de usuários e beneficiários, pois no projeto de referência que estamos utilizando, essas informações serão organizadas de uma forma diferente, que será explicada em um vídeo.

### 2.1. Requisitos Funcionais com IA:

- **Cadastro de Doações:** O sistema deve ser capaz de registrar diferentes tipos de doações, tais como maquiagem, cabelo, lenços e dinheiro. Além disso, ele deve permitir que o usuário insira especificações detalhadas para cada doação, como tipo, quantidade, data da doação, cores, Nome/Apelido(Apenas para uma  breve Identificação).
- **Armazenar as Doações:** As informações das doações devem ser armazenadas em um arquivo de texto (TXT), proporcionando um controle e organização mais eficazes das doações realizadas.
- **Gerador de Relatorio:** O sistema deve incluir uma opção para gerar relatórios que exibam a quantidade de cada tipo de item doado, como maquiagem, cabelo, dinheiro e lenços. Esses relatórios devem ser acessíveis ao usuário para proporcionar uma visão clara e detalhada das contribuições feitas
- **Tratamento de Exeções:** Para garantir o bom funcionamento do software, é crucial que os desenvolvedores realizem todos os tratamentos de exceções para garantir um bom software.

### 2.2. Prompts Usados:

- [Primeiro Prompt](https://docs.google.com/document/d/1Gl26gusF3mFw10VtmvV4dn3VEUjwsQNi4nP8vTXB3kU/edit?usp=sharing)
- [Segundo Prompt](https://docs.google.com/document/d/1VLhJtMMzkSgRy0ryF72P3VVOF68CP-fIE2KJ9Tmxnmo/edit?usp=sharing)
- [Terceiro Prompt](https://docs.google.com/document/d/1o729OxRmQf2MTi7RLdPO8rRgJph8U7Zfiz2lwwGpUBI/edit?usp=sharing)

### 2.3. Adição de mais Funcionalidades:

- **Cadastro de Doações:** O sistema deve ser capaz de registrar diferentes tipos de doações, tais como maquiagem, cabelo, lenços e dinheiro. Além disso, ele deve permitir que o usuário insira especificações detalhadas para cada doação, como tipo, quantidade, data da doação, cores, Nome/Apelido(Apenas para uma  breve Identificação).
- **Cadastro de Doações de Dinheiro:** O sistema deve ser capaz de registrar uma doação de dinheiro, especificações como nome da conta, valores e data da transação devem ser registradas e armazenadas.
- **Envio de Cartas:** Será possivel enviar cartas de apoio para enviar para as pessoas que seram beneficiadas, o sistema deve ser capaz de registras essas cartas com seu texto e escritor.
- **Armazenar as Doações:** As informações das doações devem ser armazenadas em um arquivo de texto (TXT), proporcionando um controle e organização mais eficazes das doações realizadas.
- **Gerador de Relatorio:** O sistema deve incluir uma opção para gerar relatórios que exibam a quantidade de cada tipo de item doado, como maquiagem, cabelo, dinheiro e lenços. Esses relatórios devem ser acessíveis ao usuário para proporcionar uma visão clara e detalhada das contribuições feitas
- **Tratamento de Exeções:** Para garantir o bom funcionamento do software, é crucial que os desenvolvedores realizem todos os tratamentos de exceções para garantir um bom software.

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
- tipo: String - Indica o tipo de doação (cabelo, maquiagem, lenços).

- quantidade: int - Especifica a quantidade doada.

- data: Date - Data em que a doação foi realizada.

- doador: Doador - Referência à classe Doador que realizou a doação.

- sdf: SimpleDateFormat - Indica o pattern utilizado para a data
```

**Métodos:**
```
+ Doacao(quantidade: int, doador: Doador, data: Date) - Construtor da classe Doacao.

+ getTipo(): String - Retorna o tipo da doação.    

+ setTipo(tipo: String): void - Define o tipo da doação.

+ getQuantidade(): int - Retorna a quantidade da doação.

+ setQuantidade(quantidade: int): void - Define a quantidade da doação.

+ getDoador(): Doador - Retorna o doador da doação.

+ setDoador(doador: Doador): void - Define o doador da doação.

+ getData(): Date - Retorna a data da doação.

+ setData(data: Date): void - Define a data da doação.

+ getSdf(): SimpleDateFormat - Retorna o formato de data utilizado.

+ setSdf(sdf: SimpleDateFormat): void - Define o formato de data utilizado.  

```
**Classe Cabelo herda de Doacao:**

**Propriedades:**
```
- corCabelo: String - Armazena a cor do cabelo doado.

- tamanhoCabelo: String - Armazena o tamanho do cabelo doado. 
```
**Métodos:**
```
+ Doacao(quantidade: int, doador: Doador, data: Date) - Construtor da classe `Doacao`.

+ registraDoacao(doacao: Doacao): void - Registra a doação no sistema, incluindo detalhes como quantidade, doador, data, cor e tamanho do cabelo.

+ getCorCabelo(): String - Retorna a cor do cabelo doado.

+ setCorCabelo(corCabelo: String): void - Define a cor do cabelo doado.

+ getTamanhoCabelo(): String - Retorna o tamanho do cabelo doado.

+ setTamanhoCabelo(tamanhoCabelo: String): void -  Define o tamanho do cabelo doado.
```

**Classe Maquiagem herda de Doacao:**

**Propriedades:**
```
- descricaoMaquiagem: String - Armazena a descrição da maquiagem doada (Delineador, Blush, etc.).
```

**Métodos:**
```
+ Maquiagem(quantidade: int, doador: Doador, data: Date, descricaoMaquiagem: String) - Construtor da classe `Maquiagem`.

+ registraDoacao(doacao: Doacao): void - Registra a doação no sistema, incluindo detalhes como quantidade, doador, data e descrição da maquiagem.

+ getDescricaoMaquiagem(): String - Retorna a descrição da maquiagem doada.

+ setDescricaoMaquiagem(descricaoMaquiagem: String): void - Define a descrição da maquiagem doada.
```

**Classe Lenco herda de Doacao:**

**Propriedades:**
```
- corLenco: String - Armazena a cor do lenço doado. 
- estiloLenco: String - Armazena o estilo do lenço doado.
```

**Métodos:**
```
+ Lenco(quantidade: int, doador: Doador, data: Date, corLenco: String, estiloLenco: String) - Construtor da classe `Lenco`.

+ registraDoacao(doacao: Doacao): void - Registra a doação no sistema, incluindo detalhes como quantidade, doador, data, cor e estilo do lenço.

+ getCorLenco(): String - Retorna a cor do lenço doado.

+ setCorLenco(corLenco: String): void - Define a cor do lenço doado.  

+ getEstiloLenco(): String - Retorna o estilo do lenço doado.

+ setEstiloLenco(estiloLenco: String): void - Define o estilo do lenço doado.
```

**Classe DoacaoDinheiro**

**Propriedades:**
```
- valor: float - Especifica o valor da doação em dinheiro.

- data: Date - Data em que a doação foi realizada.

- nomeConta: String - Armazena o nome da conta associada à doação em dinheiro.

- resultado: float - Armazena o total acumulado das doações em dinheiro.

```
**Métodos:**
```
+ DoacaoDinheiro(valor: float, data: Date, nomeConta: String) - Construtor da classe `DoacaoDinheiro`.  

+ registraDoacaoDinheiro(dinheiro: DoacaoDinheiro): void - Registra a doação em dinheiro no sistema, incluindo valor, data e nome da conta.

+ getData(): Date - Retorna a data da doação em dinheiro.

+ setData(data: Date): void - Define a data da doação em dinheiro.

+ getValor(): float - Retorna o valor da doação em dinheiro.

+ setValor(valor: float): void - Define o valor da doação em dinheiro.

+ getNomeConta(): String - Retorna o nome da conta associada à doação em dinheiro. 

+ setNomeConta(nomeConta: String): void - Define o nome da conta associada à doação em dinheiro.

+ getResultado(): float - Retorna o total acumulado das doações em dinheiro.

+ getSdf(): SimpleDateFormat - Retorna o formato de data utilizado. 

```
**Classe Doador**

**Propriedades:**
```
apelido: String - Apelido do doador.

contato: String - Número de contato do doador.
```
**Métodos:**
```
 + Doador(apelido: String, contato: String) - Construtor da classe `Doador`.

 + cadastrarDoador(doador: Doador): void - Registra um novo doador no sistema, caso não exista um doador com o mesmo apelido e contato.

 + verificaDoadorExistente(apelido: String, contato: String): boolean | Verifica se um doador com o mesmo apelido e contato já está cadastrado no sistema.

 + toString(): String - Retorna o apelido do doador. 

 + getApelido(): String - Retorna o apelido do doador.

 + setApelido(apelido: String): void - Define o apelido do doador.

 + getContato(): String - Retorna as informações de contato do doador.

 + setContato(contato: String): void - Define as informações de contato do doador.
```

**Classe CartaDeApoio**

**Propriedades:**
```
- nomeEscritor: String - Armazena o nome do escritor da carta de apoio

- textoDaCarta: String - Armazena o texto da carta de apoio.
```

**Métodos:**
```
+ CartaDeApoio(nomeEscritor: String, textoDaCarta: String) - Construtor da classe `CartaDeApoio`. 

+ registarCarta(nomeEscrito: String, textoDaCarta: String): void - Registra a carta de apoio no sistema, incluindo o nome do escritor e o texto da carta.

+ getNomeEscritor(): String - Retorna o nome do escritor da carta de apoio.

 + setNomeEscritor(nomeEscritor: String): void - Define o nome do escritor da carta de apoio. 

 + getTextoDaCarta(): String - Retorna o texto da carta de apoio. 

 + setTextoDaCarta(textoDaCarta: String): void - Define o texto da carta de apoio.
```
**Classe Relatorio**

**Propriedades:**
```
- dataRelatorio: String - Armazena a data em que o relatório foi gerado.

- tipoRelatorio: String - Armazena o tipo de relatório gerado.
```
**Métodos:**
```
+ Relatorio(dataRelatorio: String, tipoRelatorio: String) - Construtor da classe `Relatorio`.

+ gerarRelatorio(): void - Gera o relatório com informações sobre a quantidade de doações, quantidade de doadores e dinheiro arrecadado.

+ quantidadeDoacoes(): int - Retorna a quantidade de doações registradas no sistema

+ quantidadeDoadores(): int - Retorna a quantidade de doadores registrados no sistema.

+ getDataRelatorio(): String - Retorna a data em que o relatório foi gerado.

+ setDataRelatorio(dataRelatorio: String): void - Define a data em que o relatório foi gerado.  

+ getTipoRelatorio(): String - Retorna o tipo de relatório gerado. 

+ setTipoRelatorio(tipoRelatorio: String): void - Define o tipo de relatório gerado.    
```
**Classe SistemaGestaoDoacoes**

**Propriedades:**
```
- listaDoacoes: ArrayList\<Doacao\> - Armazena a lista de doações realizadas.

- listaDoacaoDinheiro: ArrayList\<DoacaoDinheiro\> - Armazena a lista de doações em dinheiro realizadas.

- listaDoadores: ArrayList\<Doador\> - Armazena a lista de doadores cadastrados.
```
**Métodos:**
```
+ SistemaGestaoDoacoes() - Construtor da classe `SistemaGestaoDoacoes`.  

+ adicionarDoacao(doacao: Doacao): void - Adiciona uma doação à lista de doações.

+ adicionarDoacaoDinheiro(doacao: DoacaoDinheiro): void - Adiciona uma doação em dinheiro à lista de doações em dinheiro

+ adicionarDoadores(doador: Doador): void - Adiciona um doador à lista de doadores. 

+ contador(): void - Exibe o contador com informações sobre as doações e doadores.

+ getListaDoacoes(): ArrayList\<Doacao\> - Retorna a lista de doações.

+ setListaDoacoes(listaDoacoes: ArrayList\<Doacao\>): void - Define a lista de doações.

+ getListaDoacaoDinheiro(): ArrayList\<DoacaoDinheiro\> - Retorna a lista de doações em dinheiro.

+ setListaDoacaoDinheiro(listaDoacaoDinheiro: ArrayList\<DoacaoDinheiro\>): void - Define a lista de doações em dinheiro.

+ getListaDoadores(): ArrayList\<Doador\> - Retorna a lista de doadores.

+ setListaDoadores(listaDoadores: ArrayList\<Doador\>): void - Define a lista de doadores.  
```

**Classe Arquivos**

**Propriedades:**
```
- ARQUIVO_DOACOES: String - Armazena o nome do arquivo de doações.

- ARQUIVO_DOADORES: String - Armazena o nome do arquivo de doadores. 

- ARQUIVO_CARTAS: String - Armazena o nome do arquivo de cartas de apoio.
```

### 4.2. Relações entre as Classes:

1. **SistemaGestaoDoacoes:**
   - Contém três listas: `listaDoacoes`, `listaDoacaoDinheiro` e `listaDoadores`.
   - `listaDoacoes` armazena objetos do tipo `Doacao`.
   - `listaDoacaoDinheiro` armazena objetos do tipo `DoacaoDinheiro`.
   - `listaDoadores` armazena objetos do tipo `Doador`.

2. **Relatorio:**
   - Utiliza objetos da classe `DoacaoDinheiro`.
   - Utiliza objetos da classe `Doacao`.
   - Contém atributos `dataRelatorio` e `tipoRelatorio`.

3. **DoacaoDinheiro:**
   - Herda da classe `Doacao`.
   - Contém atributos `valor`, `data`, `nomeConta` e `resultado` (este último é estático).

4. **Doacao:**
   - Contém os atributos `tipo`, `quantidade`, `doador` e `data`.

5. **Doador:**
   - Contém os atributos `apelido` e `contato`.

6. **Cabelo:**
   - Herda da classe `Doacao`.
   - Contém os atributos `corCabelo` e `tamanhoCabelo`.

7. **Maquiagem:**
   - Herda da classe `Doacao`.
   - Contém o atributo `descricaoMaquiagem`.

8. **Lenco:**
   - Herda da classe `Doacao`.
   - Contém os atributos `corLenco` e `estiloLenco`.

9. **CartaDeApoio:**
   - Contém os atributos `nomeEscritor` e `textoDaCarta`.
     

## 5. Estratégia de Programação com IA:

Na parte de utilização de uma estratégia específica, acabei optando por utilizar todas as que estavam ao meu alcance e atendiam às minhas necessidades. No início, utilizei o GPT para me ajudar a entender as diferenças entre FileWriter e PrintWriter e qual seria a melhor opção para a minha necessidade. Também fiz mais perguntas sobre a utilização do append e a combinação entre FileWriter e PrintWriter. Outra pergunta que fiz foi sobre o uso da classe Date para trabalhar com datas. Após isso, pedi mais explicações e exemplos sobre o uso de diferentes tipos de patterns que eu poderia implementar no meu programa.

Acabei utilizando o GPT mais no início do desenvolvimento do meu programa, pois foi quando surgiram mais dúvidas em relação à leitura de arquivos, utilização de datas e algumas tomadas de decisões para determinar qual abordagem seria mais adequada e eficiente para cada situação. No momento atual do desenvolvimento, estou utilizando o GPT para a correção de métodos, verificando se haverá algum problema com o buffer do Scanner ou se há algo que poderia ser um erro óbvio. Após passar por essa verificação, realizo meus próprios testes.

Aprofundando um pouco nos conhecimentos e ideias, acabei estudando sobre Generics. Tive a ideia de armazenar certos objetos em uma lista e pensei em utilizá-la, mas não foi necessário. Também aprendi a utilizar o final para organizar os arquivos que precisava. Outra coisa que aprendi de forma bastante prática foram as Exceptions e como eu poderia criar as minhas próprias Exceptions.



