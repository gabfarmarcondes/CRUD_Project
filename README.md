# CRUD Project

## Descrição
Projeto de exemplo para implementar operações CRUD (Create, Read, Update, Delete) utilizando Spring Boot.

## Tecnologias Utilizadas

1. **Spring Boot**:
   - `spring-boot-starter-data-jpa`: Para integração com JPA e manipulação de dados.
   - `spring-boot-starter-validation`: Para validação de dados.
   - `spring-boot-starter-web`: Para desenvolvimento de APIs RESTful.
   - `spring-boot-devtools`: Ferramentas de desenvolvimento para maior produtividade.
   - `spring-boot-starter-test`: Para testes unitários e de integração.
   - `spring-boot-maven-plugin`: Para compilar e empacotar a aplicação.

2. **Banco de Dados**:
   - `H2 Database`: Banco de dados em memória para testes e desenvolvimento.
   - `MySQL Connector`: Conectividade com banco de dados MySQL para produção.

3. **Validação de Dados**:
   - `Caelum Stella`: Validação de CPF, CNPJ e outros dados brasileiros.

4. **Lombok**:
   - `Lombok`: Reduz a verbosidade do código Java com geração automática de métodos comuns.
## Estrutura do User

O User é composto pelos seguintes atributos:

    - username: Nome de usuário único para login.
    - firstName: Primeiro nome do usuário.
    - lastName: Último nome do usuário.
    - email: Endereço de e-mail do usuário.
    - password: Senha para autenticação do usuário.
    - cpf: número de identificação no Brasil.
    - Phone
        - ddi: Código do país.
        - ddd: Código da área.
        - phoneNumber: Número do telefone.
## Documentação da API - CRUD

#### Endpoints da API

- **GET /users/findAll**: retorna todos os usuários
- **GET /users/find/{id}**: retorna um usuário pelo seu ID
- **POST /users/create**: cria um usuário
- **PUT /users/update/{id}**: atualiza os dados de um usuário pelo seu ID
- **DELETE /users/delete/{id}**: delete um usuário pelo seu ID


## Documentação da API - Verifications
- **Get /users/check/id/{id}**: Verifica se o ID já existe no banco de dados
- **Get /users/check/email/{email}**: Verifica se o e-mail já existe no banco de dados
- **Get /users/check/username/{username}**: Verifica se o username já existe no banco de dados
- **Get /users/check/cpf/{cpf}**: Verifica se o CPF é válido (Se retornar 200 o CPF foi válido e 201 se o CPF não for válido)

## Uso/Exemplos

Para retornar todos os usuários existentes, envie uma solicitação GET para `http://localhost:8080/users/findAll`.

Para retornar apenas um usuário existente, envie uma solicitação GET para `http://localhost:8080/users/find/{id}`.

Para criar um novo usuário, envie uma solicitação POST para `http://localhost:8080/users/create` com o seguinte corpo:  
```
{
  "username": "johndoe",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe_updated@example.com",
  "password": "password123",
  "cpf": "12345678901",
  "phoneNumber": {
    "ddi": "+55",
    "ddd": "11",
    "phoneNumber": "987654321"
  }

  O CPF digitado tem que ser válido, 
    pois caso contrário irá retornar um Bad Request,
      não criando um Usuário novo

```

Para atualiar os dados de um usuário, envie uma solicitação PUT para `http://localhost:8080/users/update/{id}` com o seguinte corpo:
```
{
  "username": "johndoe",
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe_updated@example.com",
  "password": "NEWpassword1234", // autalização
  "cpf": "12345678901",
  "phoneNumber": {
    "ddi": "+55",
    "ddd": "11",
    "phoneNumber": "987654321"
  }

```

Para deletar um usuário do banco de dados, envie uma solicitação DELETE para `http:localhost:8080/users/delete/{id}`com o seguinte corpo:
```
{
    "id": 1
}
```

Para verificar se já existe um usuário com um ID, envie uma solicitação GET para: `http://localhost:8080/users/check/id/{id}`

Para verificar se já existe um usuário com um username, envie uma solicitação GET para: `http://localhost:8080/users/check/username/{username}` 

Para verificar se já existe um usuário com um e-mail, envie uma solicitação GET para `http://localhost:8080/users/check/email/{email}`

Para verificar se o CPF de um usuário é válido (retornando True), envie uma solicitação GET para `http://localhost:8080/users/check/cpf/{cpf}`


## Rodando localmente

Clone o projeto

```bash
  git clone https://link-para-o-projeto
```

Entre no diretório do projeto

```bash
  cd caminho/para/seu/projeto
```

Compile o projeto

```bash
  mvn clean install
```

Execute o projeto

```bash
  mvn spring-boot:run
```

### Observações:
1. Porta de uso do projeto é a `8080` mas pode mudar a porta no arquivo `application.properties`:
```bash
  server.port=9090(exemplo)
```
2. Verificar se todas as dependências estão com as versões corretas no  `pom.xml`

3. Para configurar para outro banco de dados MySQL, alterar as configurações em `application.properties`: 
```bash
    spring.application.name=CRUD-Project
    spring.datasource.url=jdbc:mysql://localhost:3306/database_user // colocar o url do database
    spring.datasource.username=root // colocar seu username
    spring.datasource.password=n5taalat // colocar sua senha
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update // alterar para create para poder criar as tabelas no banco de dados
    spring.jpa.show-sql: true
    spring.jpa.generate-ddl=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialec
```
## Feedback

Se você tiver algum feedback, sinta-se à vontade para abrir uma [issue](https://github.com/gabfarmarcondes/seu-repositorio/issues) ou mandar um [pull request](https://github.com/gabfarmarcondes/seu-repositorio/pulls).

Obrigado pela atenção.

## 🔗 Links
[![portfolio](https://img.shields.io/badge/github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/gabfarmarcondes)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/gabfariasmarcondes)


