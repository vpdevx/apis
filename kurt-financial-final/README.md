## Pacote `com.kurt_financial.api.models`

Este pacote contém as classes relacionadas aos modelos de dados do projeto.

<details>
  <summary>Classe User</summary>

A classe `User` representa um usuário no sistema.

### Atributos

- `id` (Long): Identificador único do usuário.
- `username` (String): Nome de usuário.
- `email` (String): Endereço de e-mail do usuário.
- `password` (String): Senha do usuário.
- `roles` (Set<Role>): Conjunto de funções (roles) associadas ao usuário.

### Construtores

- `User()`: Construtor padrão sem argumentos.
- `User(username: String, email: String, password: String)`: Construtor que recebe o nome de usuário, e-mail e senha como argumentos.

### Métodos

- `getId(): Long`: Retorna o ID do usuário.
- `setId(id: Long)`: Define o ID do usuário.
- `getUsername(): String`: Retorna o nome de usuário.
- `setUsername(username: String)`: Define o nome de usuário.
- `getEmail(): String`: Retorna o endereço de e-mail.
- `setEmail(email: String)`: Define o endereço de e-mail.
- `getPassword(): String`: Retorna a senha.
- `setPassword(password: String)`: Define a senha.
- `getRoles(): Set<Role>`: Retorna o conjunto de funções associadas ao usuário.
- `setRoles(roles: Set<Role>)`: Define o conjunto de funções associadas ao usuário.
</details>

<details>
  <summary>Classe Role</summary>

A classe `Role` representa uma função (role) no sistema.

### Atributos

- `id` (Integer): Identificador único da função.
- `name` (ERole): Nome da função.

### Construtores

- `Role()`: Construtor padrão sem argumentos.
- `Role(name: ERole)`: Construtor que recebe o nome da função como argumento.

### Métodos

- `getId(): Integer`: Retorna o ID da função.
- `setId(id: Integer)`: Define o ID da função.
- `getName(): ERole`: Retorna o nome da função.
- `setName(name: ERole)`: Define o nome da função.
</details>

<details>
  <summary>Enumeração ERole</summary>

A enumeração `ERole` define os diferentes tipos de funções disponíveis no sistema.

### Valores possíveis

- `ROLE_USER`: Função de usuário padrão.
- `ROLE_MODERATOR`: Função de moderador.
- `ROLE_ADMIN`: Função de administrador.
</details>

<details>
  <summary>Classe Bill</summary>

A classe `Bill` representa uma fatura no sistema.

### Atributos

- `id` (Long): Identificador único da fatura.
- `name` (String): Nome da fatura.
- `value` (Float): Valor da fatura.
- `date` (Date): Data da fatura.
- `user` (User): Usuário associado à fatura.

### Construtores

- `Bill()

</details>

## Pacote `com.kurt_financial.api.repository`

Este pacote contém as classes responsáveis pela camada de acesso a dados (repositórios) do projeto.

### Classe `UserRepository`

O repositório `UserRepository` é responsável por interagir com os dados da entidade `User` no banco de dados.

<details>
  <summary>Métodos</summary>

- `findByUsername(String username): Optional<User>`: Busca um usuário pelo nome de usuário.
- `findById(Long id): Optional<User>`: Busca um usuário pelo ID.
- `existsByUsername(String username): Boolean`: Verifica se um usuário com o nome de usuário fornecido existe.
- `existsByEmail(String email): Boolean`: Verifica se um usuário com o endereço de e-mail fornecido existe.
</details>

### Classe `RoleRepository`

O repositório `RoleRepository` é responsável por interagir com os dados da entidade `Role` no banco de dados.

<details>
  <summary>Métodos</summary>

- `findByName(ERole name): Optional<Role>`: Busca uma função (role) pelo nome.
</details>

### Classe `BillRepository`

O repositório `BillRepository` é responsável por interagir com os dados da entidade `Bill` no banco de dados.

<details>
  <summary>Métodos</summary>

- `findByUserId(Long id): Optional<List<Bill>>`: Busca contas pelo ID do usuário associado.
</details>

## Pacote `com.kurt_financial.api.security`

Este pacote contém a classe `WebSecurityConfig` relacionada à configuração de segurança do projeto.

### Classe `WebSecurityConfig`

A classe `WebSecurityConfig` é responsável por configurar a segurança da aplicação web.

<details>
  <summary>Métodos</summary>

- `authenticationJwtTokenFilter(): AuthTokenFilter`: Cria e retorna uma instância de `AuthTokenFilter`, responsável por filtrar e validar os tokens de autenticação JWT.
- `authenticationProvider(): DaoAuthenticationProvider`: Cria e retorna uma instância de `DaoAuthenticationProvider`, responsável por fornecer autenticação personalizada com base no serviço `UserDetailsService`.
- `authenticationManager(AuthenticationConfiguration authConfig): AuthenticationManager`: Configura o gerenciador de autenticação com base na configuração de autenticação fornecida.
- `passwordEncoder(): PasswordEncoder`: Cria e retorna uma instância de `BCryptPasswordEncoder`, responsável por codificar e validar senhas.
- `filterChain(HttpSecurity http): SecurityFilterChain`: Configura a cadeia de filtros de segurança com base nas configurações de HTTP fornecidas.

</details>

## Pacote `com.kurt_financial.api.security.services`

Este pacote contém classes relacionadas aos serviços de segurança do projeto.

### Classe `UserDetailsImpl`

A classe `UserDetailsImpl` implementa a interface `UserDetails` e representa os detalhes do usuário para fins de autenticação e autorização.

<details>
  <summary>Atributos</summary>

- `id` (Long): Identificador único do usuário.
- `username` (String): Nome de usuário.
- `email` (String): Endereço de e-mail do usuário.
- `password` (String): Senha do usuário.
- `authorities` (Collection<? extends GrantedAuthority>): Coleção de autorizações concedidas ao usuário.
</details>

<details>
  <summary>Construtores</summary>

- `UserDetailsImpl(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities)`: Construtor que recebe o ID, nome de usuário, e-mail, senha e autorizações como argumentos.
- `UserDetailsImpl(String username, String password)`: Construtor que recebe o nome de usuário e senha como argumentos.
</details>

<details>
  <summary>Métodos</summary>

- `getAuthorities(): Collection<? extends GrantedAuthority>`: Retorna as autorizações concedidas ao usuário.
- `getId(): Long`: Retorna o ID do usuário.
- `getEmail(): String`: Retorna o endereço de e-mail do usuário.
- `getPassword(): String`: Retorna a senha do usuário.
- `getUsername(): String`: Retorna o nome de usuário.
- `isAccountNonExpired(): boolean`: Verifica se a conta do usuário está ativa e não expirada.
- `isAccountNonLocked(): boolean`: Verifica se a conta do usuário não está bloqueada.
- `isCredentialsNonExpired(): boolean`: Verifica se as credenciais do usuário não estão expiradas.
- `isEnabled(): boolean`: Verifica se o usuário está habilitado.
- `equals(Object o): boolean`: Verifica se o objeto passado é igual a esta instância `UserDetailsImpl`.
</details>

### Classe `UserDetailsServiceImpl`

A classe `UserDetailsServiceImpl` é responsável por fornecer os detalhes do usuário para o mecanismo de autenticação.

<details>
  <summary>Métodos</summary>

- `loadUserByUsername(String username): UserDetails`: Carrega os detalhes do usuário com base no nome de usuário fornecido.
</details>

### Classe `BillService`

A classe `BillService` é responsável por fornecer serviços relacionados às contas (bills).

<details>
  <summary>Métodos</summary>

- `save(Bill bill): Bill`: Salva uma conta no banco de dados.
- `getByUserId(Long id): Optional<List<Bill>>`: Obtém as contas associadas a um determinado ID de usuário.
- `deleteById(Long id)`: Exclui uma conta com base no ID.
- `update(Bill bill): Bill`: Atualiza uma conta no banco de dados.
</details>

## Pacote `com.kurt_financial.api.security.jwt`

Este pacote contém classes relacionadas à autenticação e autorização usando JWT (JSON Web Token).

### Classe `AuthEntryPointJwt`

A classe `AuthEntryPointJwt` é responsável por lidar com erros de autenticação e autorização. Ela implementa a interface `AuthenticationEntryPoint` do Spring Security.

<details>
  <summary>Métodos</summary>

- `commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException): void`: Intercepta e lida com erros de autenticação e autorização. Gera uma resposta JSON personalizada com informações sobre o erro.
</details>

### Classe `AuthTokenFilter`

A classe `AuthTokenFilter` é um filtro do Spring Security que intercepta as requisições e verifica a presença de um token de autenticação. Se o token for válido, ele é usado para autenticar o usuário.

<details>
  <summary>Métodos</summary>

- `doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain): void`: Intercepta as requisições e verifica a presença de um token de autenticação. Se o token for válido, autentica o usuário.
- `parseJwt(RequestWrapper cachedRequest): String`: Extrai o token JWT do Request.
</details>

### Classe `JwtUtils`

A classe `JwtUtils` é responsável por fornecer métodos utilitários para manipular tokens JWT (JSON Web Tokens).

<details>
  <summary>Métodos</summary>

- `getJwtFromCookies(HttpServletRequest request): String`: Obtém o token JWT de um cookie.
- `getJwtFromRequestBody(RequestWrapper cachedRequest): String`: Obtém o token JWT do Request.
- `generateJwtCookie(UserDetailsImpl userPrincipal): ResponseCookie`: Gera um cookie JWT com base nos detalhes do usuário.
- `getCleanJwtCookie(): ResponseCookie`: Obtém um cookie JWT vazio para limpar o cookie existente.
- `getUserNameFromJwtToken(String token): String`: Extrai o nome de usuário do token JWT.
- `validateJwtToken(String authToken): boolean`: Valida se um token JWT é válido.
- `generateTokenFromUsername(String username): String`: Gera um novo token JWT com base no nome de usuário.
</details>

### Classe `RequestWrapper`

A classe `RequestWrapper` é uma classe de envoltório para a classe `HttpServletRequest`, usada para armazenar o Request em cache, foi utilizada para que a requisição possa ser lida mais de uma vez.

<details>
  <summary>Métodos</summary>

- `getRequestBody(): String`: Obtém o Request como uma string.
</details>

## Pacote `com.kurt_financial.api.payload.request`

Este pacote contém classes de solicitação (request) que definem a estrutura dos dados necessários para realizar determinadas solicitações na API.

### Classe `LoginRequest`

A classe `LoginRequest` é usada para enviar os dados necessários para autenticação de login.

#### Atributos

- `username` (String): Nome de usuário.
- `password` (String): Senha.

### Classe `SignupRequest`

A classe `SignupRequest` é usada para enviar os dados necessários para o registro de um novo usuário.

#### Atributos

- `username` (String): Nome de usuário.
- `email` (String): Endereço de e-mail.
- `role` (Set<String>): Conjunto de funções (roles) do usuário.
- `password` (String): Senha.

## Pacote `com.kurt_financial.api.payload.response`

Este pacote contém classes de resposta (response) que definem a estrutura dos dados retornados pela API.

### Classe `MessageResponse`

A classe `MessageResponse` é usada para retornar uma mensagem de resposta.

#### Atributos

- `message` (String): Mensagem de resposta.

### Classe `UserInfoResponse`

A classe `UserInfoResponse` é usada para retornar informações do usuário.

#### Atributos

- `id` (Long): ID do usuário.
- `username` (String): Nome de usuário.
- `sessionID` (String): ID da sessão do usuário

## Documentação da API

## Autenticação

Exemplo de sessionID
```agsl
"JSESSIONID=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrYWthIiwiaWF0IjoxNjg1MjkwNDIyLCJleHAiOjE2ODUzNzY4MjJ9.h9orH3FXOjBYiFQfz04Ie0exWvwghqlwuWl74851-DMzNxbALrEXn8PXUx42DN-CBdd8tebkcJ-hL7P99HAr5g"
```

### Login

**Endpoint**: `/auth/login`

**Método**: `POST`

Realiza o login do usuário e retorna um token de sessão.

**Request:**

```json
{
    "username": "usuario",
    "password": "senha"
}
```
**Success Response**:

**Código HTTP:: 200 OK**

```json
{
    "id": <user-id>,
    "username": "usuario",
    "sessionID": "<session-id>"
}
```
### Register

**Endpoint**: `/auth/register`

**Método**: POST

Registra um novo usuário.

**Request:**

```json
{
    "username": "usuario",
    "email": "<email>",
    "password": "<senha>",
    "role": ["user"]
}
```
**Success Response**:

**Código HTTP: 200 OK**

```json
{
    "message": "User registered successfully!"
}
```
### Logout

**Endpoint**: `/auth/logout

**Método**: POST

Realiza o logout do usuário e invalida o token de sessão.

**Request**:

```json
{
    "sessionID": "<session-id>"
}
```
**Success Response**:

**Código HTTP: 200 OK**

```json
{
    "message": "You've been signed out!"
}
```

## Contas

> **AVISO**
> A autenticação é necessária para acessar os endpoints protegidos. Para autenticar, inclua o token de sessão no corpo da sessão como `sessionID`.

> **Nota**
> Os endpoints protegidos são acessíveis apenas para usuários com a função (role) `user` e para o usuário autenticado. Por exemplo, o usuário `user1` só pode acessar os endpoints protegidos de `/user/user1/...` e não pode acessar os endpoints protegidos de `/user/user2/...`.
## Endpoints

### Listar todas as contas

Retorna todas as contas de um usuário.

- **Endpoint**: `/user/{username}/bill/all`
- **Método**: POST

**Request:**
```json
{
  "sessionID": "<session-id>"
}
```

**Response:**

- **Código HTTP**: 200 OK

```json
[
  {
    "id": <bill-id>,
    "name": "<bill-name>",
    "value": <value>,
    "date": "<date>"
  },
  {
    "id": <bill-id>,
    "name": "<bill-name>",
    "value": <value>,
    "date": "<date>"
  }
]
```

### Deletar a conta

Deleta uma conta específica de um usuário.

- **Endpoint**: /user/{username}/bill/delete/{id}`
- **Método**: POST

**Request:**

```json
{
  "sessionID": "<session-id>"
}
```

**Response:**

- **Código HTTP**: 200 OK

### Salvar conta

Cria uma nova conta para um usuário.

- **Endpoint**: `/user/{username}/bill/save`
- **Método**: POST

**Request:**
```json
{
  "name": "<bill-name>",
  "value": <value>,
  "date": "<date>",
  "sessionID": "<session-id>"
}
```

**Response:**

- **Código HTTP**: 200 OK

```json
{
  "id": <bill-id>,
  "name": "<bill-name>",
  "value": <value>,
  "date": "<date>"
}
```

### Atualizar conta

Atualiza uma conta existente de um usuário.

- **Endpoint**: /user/{username}/bill/update`
- **Método**: PUT

**Request:**
```json
{
  "id": <bill-id>,
  "name": "<bill-name>",
  "value": <value>,
  "date": "<date>",
  "sessionID": "<session-id>"
}
```

**Response:**

- **Código HTTP**: 200 OK

```json
{
  "id": <bill-id>,
  "name": "<bill-name>",
  "value": <value>,
  "date": "<date>"
}
```
