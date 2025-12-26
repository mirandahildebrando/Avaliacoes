# 🌟 Avaliações API - Spring Boot & MongoDB

API RESTful desenvolvida para gerenciamento de avaliações, focada em boas práticas de desenvolvimento, escalabilidade e manutenibilidade.

## 🚀 Tecnologias e Ferramentas
* **Java 17** (Linguagem principal)
* **Spring Boot 3.4.1** (Framework)
* **MongoDB** (Banco de dados NoSQL)
* **Lombok** (Produtividade e código limpo)
* **JUnit 5 & Mockito** (Testes unitários e de integração)
* **Swagger/OpenAPI** (Documentação interativa)
* **Maven** (Gerenciamento de dependências)

## 🛠️ Práticas de Engenharia de Software Aplicadas
* **Arquitetura em Camadas:** Separação clara entre Controller, Service e Repository.
* **DTO Pattern (Data Transfer Object):** Uso de **Java Records** para segurança no tráfego de dados e desacoplamento da entidade de banco.
* **Global Exception Handling:** Tratamento centralizado de erros com `@RestControllerAdvice` para respostas HTTP padronizadas.
* **Bean Validation:** Validação rigorosa de dados de entrada com `@Valid`.
* **Auditoria Automática:** Implementação de `@CreatedDate` para controle de logs temporais via Spring Data Mongo.
* **Testes Automatizados:** * Testes de Unidade (Services) com Mockito.
    * Testes de Camada Web (Controllers) com MockMvc.

## 📋 Como Executar o Projeto
1. Clone o repositório: `git clone https://github.com/seu-usuario/nome-do-projeto.git`
2. Configure sua string de conexão do MongoDB no `application.properties`.
3. Execute o comando: `./mvnw spring-boot:run`
4. Acesse a documentação: `http://localhost:8080/swagger-ui/index.html`
