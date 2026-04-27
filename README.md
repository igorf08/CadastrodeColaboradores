# 🚀 Sistema de Cadastro de Colaboradores

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0202?style=for-the-badge&logo=flyway&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![H2](https://img.shields.io/badge/H2-005C84?style=for-the-badge&logo=databricks&logoColor=white)

Esta é uma aplicação back-end robusta desenvolvida com **Spring Boot**, focada no gerenciamento de colaboradores e suas atividades organizacionais. O projeto foi construído seguindo princípios de **arquitetura em camadas** e boas práticas de desenvolvimento de software, servindo como um exemplo prático de integração entre Java, bancos de dados relacionais e containerização.

## 📋 Visão Geral

O sistema permite gerenciar o ciclo de vida de colaboradores dentro de uma organização, associando-os a atividades específicas. Foi desenhado para ser escalável e fácil de manter, utilizando migrações de banco de dados para garantir a integridade da estrutura em diferentes ambientes.

### Funcionalidades Principais
- **Gestão de Colaboradores:** CRUD completo com validações de nome, idade e e-mail.
- **Vínculo de Atividades:** Atribuição dinâmica de atividades a colaboradores (Relacionamento 1:N).
- **Versionamento de Dados:** Controle total do esquema do banco de dados via Flyway.
- **Ambiente Isolado:** Configuração pronta para execução via Docker.

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3.x
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 (In-memory para testes/dev) e suporte a SQL ANSI.
* **Migrações:** Flyway Migration.
* **Gerenciador de Dependências:** Maven.
* **Containerização:** Docker.

## 🏗️ Arquitetura e Design

O projeto adota o padrão **Controller-Service-Repository**, garantindo a separação de responsabilidades:

1.  **Camada de Controller:** Exposição de endpoints REST e tratamento de DTOs.
2.  **Camada de Service:** Concentração das regras de negócio e validações.
3.  **Camada de Repository:** Abstração da persistência de dados.
4.  **Camada de Domain/Entity:** Mapeamento objeto-relacional (ORM) das entidades de negócio.

### Modelo de Dados
* **Colaborador:** `id`, `nome`, `idade`, `email`, `função`, `modelo contratacao`.
* **Atividade:** `id`, `título`, `descrição`.
* **Relacionamento:** Um colaborador possui uma atividade, enquanto uma atividade pode ser compartilhada por vários colaboradores.

## 🚀 Como Executar o Projeto

### Pré-requisitos
* JDK 17 ou superior.
* Maven instalado.
* Docker (opcional).

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/igorf08/CadastrodeColaboradores.git](https://github.com/igorf08/CadastrodeColaboradores.git)
    cd CadastrodeColaboradores
    ```

2.  **Compile e instale as dependências:**
    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a API:**
    A aplicação estará disponível em `http://localhost:8080`.
    *O console do banco H2 pode ser acessado em `/h2-console`.*
