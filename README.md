
# Trabalho Prático: Programação de Soluções Computacionais



## Tecnologias

- Java
- MySql
- JavaFx
- Maven


## Authors

- [@YuriOliveira1](https://github.com/YuriOliveira1)

# Estrutura do Trabalho

## 1. Proposta: 

Nossa proposta é voltado para doações de cabelo, maquiagem, lenços e dinheiro para uma organização que auxilia mulheres com câncer, principalmente de mama. Após a quimioterapia, muitas mulheres enfrentam a perda de cabelo, o que pode afetar significativamente sua autoestima. Nosso objetivo é fornecer apoio e recursos para ajudá-las a enfrentar essa fase com mais confiança e dignidade.

A ideia foi sugerida pela mãe do integrante Yuri de Oliveira, que trabalhou em uma clínica chamada OncoMinas, localizada em Extrema-MG. OncoMinas é uma clínica oncológica que atende diversos pacientes com câncer. Uma das campanhas realizadas por essa clínica foi a "Campanha Laço Rosa", cujo principal objetivo era receber doações de cabelo, lenços e maquiagem para aumentar a autoestima das mulheres em tratamento

## 2. Solicitando os Requisitos Funcionais

Para solicitar os Requisitos Funcionais de nossa proposta, utilizamos o ChatGPT como ferramenta de auxílio. No meu primeiro prompt, detalhei a proposta do nosso projeto, explicando a ideia principal: desenvolver um software para gerenciar doações. Com base nisso, o ChatGPT gerou diversas funções que poderiam ser incorporadas ao nosso software. Após analisar as sugestões, identifiquei que algumas funcionalidades estavam faltando, como a capacidade de armazenar dados em arquivos TXT e gerar pequenos relatórios.

Para adequar melhor o software ao que está sendo planejado e solicitado, solicitei um segundo prompt para corrigir e melhorar as requisições. Com essa nova solicitação, percebi que as sugestões estavam mais alinhadas com nossas necessidades. Decidi então fazer alguns ajustes finais, removendo funcionalidades que, em minha visão, não são necessárias no momento, como o cadastro de usuários e beneficiários, pois no projeto de referência que estamos utilizando, essas informações serão organizadas de uma forma diferente, que será explicada em um vídeo.

### 2.1. Requisitos Funcionais com IA:

(Requisições Do inicio do projeto)

- **Cadastro de Doações:** O sistema deve ser capaz de registrar diferentes tipos de doações, tais como maquiagem, cabelo, lenços e dinheiro. Além disso, ele deve permitir que o usuário insira especificações detalhadas para cada doação, como tipo, quantidade, data da doação, cores, Nome/Apelido(Apenas para uma  breve Identificação).
- **Armazenar as Doações:** As informações das doações devem ser armazenadas em um arquivo de texto (TXT), proporcionando um controle e organização mais eficazes das doações realizadas.
- **Gerador de Relatorio:** O sistema deve incluir uma opção para gerar relatórios que exibam a quantidade de cada tipo de item doado, como maquiagem, cabelo, dinheiro e lenços. Esses relatórios devem ser acessíveis ao usuário para proporcionar uma visão clara e detalhada das contribuições feitas
- **Tratamento de Exeções:** Para garantir o bom funcionamento do software, é crucial que os desenvolvedores realizem todos os tratamentos de exceções para garantir um bom software.

### 2.2. Prompts Usados:

- [Primeiro Prompt](https://docs.google.com/document/d/1Gl26gusF3mFw10VtmvV4dn3VEUjwsQNi4nP8vTXB3kU/edit?usp=sharing)
- [Segundo Prompt](https://docs.google.com/document/d/1VLhJtMMzkSgRy0ryF72P3VVOF68CP-fIE2KJ9Tmxnmo/edit?usp=sharing)
- [Terceiro Prompt](https://docs.google.com/document/d/1o729OxRmQf2MTi7RLdPO8rRgJph8U7Zfiz2lwwGpUBI/edit?usp=sharing)

## 3. Falando de Críticas 

Após revisar os resultados dos três prompts enviados ao ChatGPT, conclui que a capacidade do modelo em fornecer respostas além do solicitado pode ter efeitos positivos e negativos. Dependendo do contexto, isso pode enriquecer os resultados ou causar perda de tempo ao tentar corrigir excessos.

Ao utilizar o ChatGPT para a criação de requisitos funcionais, observei que o modelo frequentemente sugere funcionalidades que não foram solicitadas. Isso pode enriquecer o projeto com novas ideias, mas também exige um esforço adicional para filtrar o que realmente é necessário. Muitas das funcionalidades geradas acabaram sendo removidas ou substituídas. Além disso, o ChatGPT utiliza exemplos de diversas fontes e os aplica à solicitação. Embora isso possa trazer ideias inovadoras, pode resultar em informações não pertinentes ou não desejadas. Durante o processo, algumas funcionalidades sugeridas pelo modelo, como o tratamento diferenciado para Doações de Dinheiro, o envio de Cartas e todo o sistema de armazenamento e tratamento de exceções, se mostraram úteis e foram incorporadas ao projeto.

Na criação das classes e funções iniciais, parecia que tudo estava correto, mas durante o desenvolvimento do sistema, boa parte do que foi gerado precisou ser reconstruída do zero ou parcialmente. O ChatGPT foi importante para gerar uma boa base para a construção do projeto, ajudando-me também a ter mais ideias de funções ou de como contornar algo confuso que ele gerou, transformando-o em algo bom na minha visão.

Além desses pequenos pontos negativos, observei uma geração de texto interessante por parte do ChatGPT. Ele forneceu uma função de cadastro de login e senha e, ao final, incluiu uma seção sobre segurança da informação dos indivíduos que participam do sistema de doações. Esse tópico é relevante, dado o cenário atual. É crucial entender como um projeto similar funcionaria na prática, onde o anonimato é levado muito a sério para evitar constrangimentos para os envolvidos e prevenir que as doações sejam utilizadas para promoções pessoais ou de organizações específicas.

### 3.1. Novas Críticas

Após ter feito o primeiro esboço e ter feito diversas atualizações o ChatGPT ainda me acompanhou nesse processo, principalmente em maneiras novas de implementar um codigo mais eficiente e tambem consultas em SQL, não tenho dominio total da linguagem então ficou um pouco dificil mas ele me deu alguns comandos e explicou suas funcionalidades,
como não estou usando um FrameWork para injeção de dependencias tive bastante complicações na hora de injetar, e o ChatGPT me deu algumas dicas de como ser mais facil e até mesmo resolveu um problema que estava me pertubando por bastante tempo, aprendi que nome de variaveis e metodos são algo extremamente importante e uma hora voce acaba se perdendo.

## 4. Aprendizados
Desde do inicio do projeto fiz diversas atualizações, desde do começo quando era apenas arquivos txt e csv, nesse inicio aprendi bastante sobre manipulação de arquivos e tratamento de exceções, e a maior dificuldade nesse começo foi a parte de arquivos já que tinha bastante possibilidade e não fazia ideia de qual seria a melhor.

Na outra "grande atualização" do projeto foi implementado o Banco de Dados MySql, aqui aprendi bastante desde de como funciona alguns modelos de projeto um que utilizei foi o DAO, que não tive nenhuma dificuldade para implementar, aprendi diversos comandos SQL para aplicações simples.

Nessa ultima grande atualização foi implementado o JavaFx, que foi uma experiencia um pouco dolorida pelo fato que a configuração no incio foi um pouco confusa e não estava com IDE configurada, mas após os ajustes foi bastante tranquilo, aprendi mais modelos de projeto como MVC e Observer Design Pattern e acabei utilizando os dois nesse projeto, nas atualizações em "tempo real" de alguma informações das tabelas e tambem utilizei o MVC para organizar e estruturar as telas, resolvi utilizar esses designs de projeto já que estava estudando e queria aplicar em algo pessoal, aprendi bastante coisa.

No Incio do projeto eu demorava basntante tempo para resolver ou pensar em algo novo programando, mas quando cheguei onde estou as coisas começaram a ser mais rapidas e problemas que achava complexo hoje está simples ou caso não esteja eu sei aonde procurar a resposta ou pensar em um algoritmo novo para resolver um novo problema.

E o maior aprendizado é sempre manter a organizações e nomes coerentes, isso teria me poupado bastante tempo :)


## 5. Estratégia de Programação com IA:

Na parte de utilização de uma estratégia específica, acabei optando por utilizar todas as que estavam ao meu alcance e atendiam às minhas necessidades. No início, utilizei o GPT para me ajudar a entender as diferenças entre FileWriter e PrintWriter e qual seria a melhor opção para a minha necessidade. Também fiz mais perguntas sobre a utilização do append e a combinação entre FileWriter e PrintWriter. Outra pergunta que fiz foi sobre o uso da classe Date para trabalhar com datas. Após isso, pedi mais explicações e exemplos sobre o uso de diferentes tipos de patterns que eu poderia implementar no meu programa.

Acabei utilizando o GPT mais no início do desenvolvimento do meu programa, pois foi quando surgiram mais dúvidas em relação à leitura de arquivos, utilização de datas e algumas tomadas de decisões para determinar qual abordagem seria mais adequada e eficiente para cada situação. No momento atual do desenvolvimento, estou utilizando o GPT para a correção de métodos, verificando se haverá algum problema com o buffer do Scanner ou se há algo que poderia ser um erro óbvio. Após passar por essa verificação, realizo meus próprios testes.

Aprofundando um pouco nos conhecimentos e ideias, acabei estudando sobre Generics. Tive a ideia de armazenar certos objetos em uma lista e pensei em utilizá-la, mas não foi necessário. Também aprendi a utilizar o final para organizar os arquivos que precisava. Outra coisa que aprendi de forma bastante prática foram as Exceptions e como eu poderia criar as minhas próprias Exceptions.

Utilizamos bastante o GPT para nos informar sobre a melhor escolha para resolver determinados problemas. Um desses problemas que gerou bastante dúvida foi na parte de tratamento de exceções, onde tínhamos vários tipos de exceções e precisávamos utilizar o Scanner logo após. O GPT nos deu uma opção bastante interessante, sugerindo o uso de métodos para tratar, ler e exibir o texto para o usuário em apenas uma linha. Isso não apenas facilitou o tratamento das exceções, mas também simplificou o código e reduziu o número de linhas necessárias.


