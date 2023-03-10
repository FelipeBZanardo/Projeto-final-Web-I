# Projeto Final Web I - CRUD de Times de Futebol

CRUD é um acrônimo para as quatro operações básicas de persistência: Create, Read, Update e Delete.
O projeto se trata de um CRUD de Times de Futebol com os seguintes atributos: Nome, País, Data de Fundação e Quantidade de Títulos até o momento.

Toda aplicação foi desenvolvida através dos conceitos de Spring e Spring Boot gerenciado pela estrutura Maven.

## 🚀 Começando

Para iniciar o projeto, basta clonar ou fazer o download do repositório, abrir na sua IDE favorita e dar o play na aplicação.
Após, basta abrir o navegador e acessar a seguinte url: <http://localhost:8080/times

### :computer: Páginas do projeto:

**Para navegar entre as páginas, basta utilizar o menu de opções no topo da tela:**
- **"Times de Futebol: "** mostra a página inicial
- **"Listar Times: "** mostra a página com todos os times cadastrados listados
- **"Cadastrar Time: "** mostra a página de cadastro


#### Página inicial:
          ![Alt ou título da imagem](URL da imagem)
          
#### Página "Cadastrar Time":
          ![Alt ou título da imagem](URL da imagem)
          
#### Página "Listar Times":
          ![Alt ou título da imagem](URL da imagem)
         

## 📋 Dependências Spring Boot

#### Thymeleaf
```
<dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```
#### Spring Data JPA
```
<dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
#### Spring WEB
```
<dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
#### H2 Database
```
<dependency>
           <groupId>com.h2database</groupId>
           <artifactId>h2</artifactId>
           <scope>runtime</scope>
</dependency>
```

## ⚙️ Executando as requisições HTTP

 * Fazer o download da pasta Insomnia
 * Abrir no aplicativo
 * Fazer os testes das Requisições HTTP da aplicação Rest 

### 🔩 Requisições HTTP presentes no projeto

#### Criar Time:
```
http://localhost:8080/rest/times/save
```
#### Buscar todos os Times:
```
http://localhost:8080/rest/times/all
```
#### Buscar Time pelo Id:
```
http://localhost:8080/rest/times/1
```
#### Buscar Times por parte do nome:
```
http://localhost:8080/rest/times/nome/corinthians
```
#### Buscar todos os Times por Ordem de data de Fundação:
```
http://localhost:8080/rest/times/orderByFundacao
```
#### Buscar todos os Times por Ordem de Nome:
```
http://localhost:8080/rest/times/orderByNome
```
#### Buscar todos os Times por Ordem de Títulos:
```
http://localhost:8080/rest/times/orderByTitulos
```
#### Deletar Time pelo Id:
```
http://localhost:8080/rest/times/1
```
#### Editar Time:
```
http://localhost:8080/rest/times/edit?id=1
```

## 🛠️ Construído com

* [Spring Initializer](https://start.spring.io/) - O framework web usado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Thymeleaf](https://www.thymeleaf.org/) - Adicionado nas páginas HTML
    ```
    <html xmlns:th="http://www.thymeleaf.org">
    ```
* [Bootstrap](https://getbootstrap.com/) - Adicionado nas páginas HTML
    ```
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    ```

## ✒️ Autor

[Felipe Zanardo](https://github.com/FelipeBZanardo)
