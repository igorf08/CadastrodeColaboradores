
# Sistema de Cadastro de Colaboradores 

Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetada para cadastrar colaboradores e suas respectivas atividades. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub. O projeto tambem conta com algumas aulas extras sobre banco de dados de uma maneira mais profunda

## Visão Geral do Projeto

Este sistema foi desenvolvido para gerenciar colaboradores e suas atividades. Cada colaborador pode ser atribuído a uma única função, enquanto uma função pode ser associada à vários colaborades. As principais funcionalidades incluem:

Cadastro de colaboradores com nome, idade, email e função.
Atribuição de uma atividade para um colaborador.
Gerenciamento de atividades e dos colaboradores associados à elas.

### Tecnologias Utilizadas

* Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
* Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
* Flyway: Para gerenciamento de migrações do banco de dados.
* JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
* Git: Controle de versão para gerenciamento de mudanças no código.
* Spring Data JPA: Para interação com o banco de dados.
* Maven: Para build e gerenciamento de dependências do projeto.
* Docker: Para build externo do banco de dados
* SQL: Manipulação do banco de dados
  

### Design do Banco de Dados
O esquema do banco de dados segue as seguintes relações:

* Colaborador: Contém atributos como id, nome, idade, email e função.
* Atividade: Contém atributos como id, título e descrição.
* Um colaborador pode ter apenas uma atividade, mas uma atividade pode ser atribuída à vários colaboradores.
  

### Configuração

* Clone o repositório: git clone https://github.com/igorf08/CadastrodeColaboradores.git
* Navegue até o diretório do projeto: cd CadastrodeColaboradores
* Construa o projeto: mvn clean install
* Execute a aplicação: mvn spring-boot:run
* Acesse a aplicação em http://localhost:8080
