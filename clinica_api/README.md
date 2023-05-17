
# API De clinica

API desenvolvida simulando o ambiente de uma clínica médica

## Entidades

<details>
  <summary>Paciente</summary>
  <br>
  A classe Paciente representa a entidade "paciente" no sistema.

## Estrutura da Entidade

A tabela "paciente" possui os seguintes campos:

| Campo           | Tipo de Dado | Descrição                      |
|-----------------|--------------|--------------------------------|
| id              | Long         | Identificador único do paciente|
| nome            | String       | Nome do paciente               |
| cpf             | String       | CPF do paciente                |
| telefone        | String       | Telefone do paciente           |
| email           | String       | Endereço de e-mail do paciente |
| endereco        | String       | Endereço do paciente           |
| cidade          | String       | Cidade do paciente             |
| estado          | String       | Estado do paciente             |
| data_nascimento | Date         | Data de nascimento do paciente |
| data_cadastro   | Date         | Data de cadastro do paciente   |

## Anotações

- A classe Paciente está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@ToString` gera automaticamente o método `toString()` para representação em formato de string da classe.
- A anotação `@Table(name = "paciente")` define o nome da tabela no banco de dados como "paciente".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- Os campos "nome" e "cpf" estão anotados com `@Column(nullable = false)` para indicar que são campos obrigatórios e não podem ser nulos.
- O campo "data_cadastro" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
</details>

<details>
  <summary>Médico</summary>
  <br>
  A classe Medico representa a entidade "medico" no sistema.

## Estrutura da Entidade

A tabela "medico" possui os seguintes campos:

| Campo          | Tipo de Dado | Descrição                      |
|----------------|--------------|--------------------------------|
| id             | Long         | Identificador único do médico  |
| nome           | String       | Nome do médico                 |
| telefone       | String       | Telefone do médico             |
| email          | String       | Endereço de e-mail do médico   |
| crm            | String       | CRM (Cadastro de Registro Médico) do médico |
| especialidade  | String       | Especialidade do médico        |
| data_cadastro  | Date         | Data de cadastro do médico     |

## Anotações

- A classe Medico está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@ToString` gera automaticamente o método `toString()` para representação em formato de string da classe.
- A anotação `@Table(name = "medico")` define o nome da tabela no banco de dados como "medico".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "nome" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- O campo "data_cadastro" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.

</details>

<details>
  <summary>Consulta</summary>
  <br>
  A classe Consulta representa a entidade "consulta" no sistema.

## Estrutura da Entidade

A tabela "consulta" possui os seguintes campos:

| Campo           | Tipo de Dado        | Descrição                            |
|-----------------|---------------------|--------------------------------------|
| id              | Long                | Identificador único da consulta       |
| data_consulta   | LocalDateTime      | Data e hora da consulta               |
| observacoes     | String              | Observações da consulta               |
| paciente        | Paciente            | Referência ao paciente associado      |
| medico          | Medico              | Referência ao médico responsável      |

## Anotações

- A classe Consulta está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@Table(name = "consulta")` define o nome da tabela no banco de dados como "consulta".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "data_consulta" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- A classe Consulta possui um relacionamento de muitos para um com a classe Paciente, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_paciente", nullable = false)`.
- A classe Consulta possui um relacionamento de muitos para um com a classe Medico, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_medico", nullable = false)`.

</details>

<details>
  <summary>Exame</summary>
  <br>
  A classe Exame representa a entidade "exame" no sistema.

## Estrutura da Entidade

A tabela "exame" possui os seguintes campos:

| Campo        | Tipo de Dado        | Descrição                            |
|--------------|---------------------|--------------------------------------|
| id           | Long                | Identificador único do exame         |
| data_exame   | LocalDateTime      | Data e hora do exame                 |
| tipo_exame   | String              | Tipo de exame realizado              |
| resultado    | String              | Resultado do exame                   |
| paciente     | Paciente            | Referência ao paciente associado     |
| medico       | Medico              | Referência ao médico responsável     |

## Anotações

- A classe Exame está anotada com `@Entity` para mapeamento do JPA (Java Persistence API).
- A anotação `@NoArgsConstructor` gera um construtor padrão sem argumentos.
- Os atributos estão anotados com `@Getter` e `@Setter` para gerar os métodos getters e setters automaticamente.
- A anotação `@Table(name = "exame")` define o nome da tabela no banco de dados como "exame".
- O campo "id" está anotado com `@Id` e `@GeneratedValue` para gerar automaticamente o valor do identificador.
- O campo "data_exame" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- O campo "tipo_exame" está anotado com `@Column(nullable = false)` para indicar que é um campo obrigatório e não pode ser nulo.
- A classe Exame possui um relacionamento de muitos para um com a classe Paciente, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_paciente", nullable = false)`.
- A classe Exame possui um relacionamento de muitos para um com a classe Medico, representado pela anotação `@ManyToOne` e `@JoinColumn(name = "id_medico", nullable = false)`.

</details>

## API Endpoints
<details>
  <summary>Paciente</summary>
  <br>
  
O `PacienteController` é responsável por lidar com as requisições relacionadas aos pacientes.

## Métodos

- `getAll()`: Retorna todos os pacientes cadastrados.
  - Método HTTP: GET
  - Path: `/paciente/all`
  - Parâmetros: Nenhum.

- `getById(id)`: Retorna um paciente pelo ID.
  - Método HTTP: GET
  - Path: `/paciente/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do paciente a ser retornado.

- `add(paciente)`: Adiciona um novo paciente.
  - Método HTTP: POST
  - Path: `/paciente/add`
  - Parâmetros: `paciente` (corpo da requisição) - Objeto Paciente a ser adicionado.

- `update(paciente)`: Atualiza um paciente existente.
  - Método HTTP: PUT
  - Path: `/paciente/edit`
  - Parâmetros: `paciente` (corpo da requisição) - Objeto Paciente atualizado.

- `delete(id)`: Deleta um paciente pelo ID.
  - Método HTTP: DELETE
  - Path: `/paciente/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do paciente a ser deletado.

- `getConsultas(id)`: Retorna todas as consultas associadas a um paciente pelo ID.
  - Método HTTP: GET
  - Path: `/paciente/{id}/consultas`
  - Parâmetros: `id` (caminho da requisição) - ID do paciente.

- `getExames(id)`: Retorna todos os exames associados a um paciente pelo ID.
  - Método HTTP: GET
  - Path: `/paciente/{id}/exames`
  - Parâmetros: `id` (caminho da requisição) - ID do paciente.
</details>

<details>
  <summary>Médico</summary>
  <br>
  O `MedicoController` é responsável por lidar com as requisições relacionadas aos médicos.

## Métodos

- `getAll()`: Retorna todos os médicos cadastrados.
  - Método HTTP: GET
  - Path: `/medico/all`
  - Parâmetros: Nenhum.

- `add(medico)`: Adiciona um novo médico.
  - Método HTTP: POST
  - Path: `/medico/add`
  - Parâmetros: `medico` (corpo da requisição) - Objeto Medico a ser adicionado.

- `update(medico)`: Atualiza um médico existente.
  - Método HTTP: PUT
  - Path: `/medico/edit`
  - Parâmetros: `medico` (corpo da requisição) - Objeto Medico atualizado.

- `delete(id)`: Deleta um médico pelo ID.
  - Método HTTP: DELETE
  - Path: `/medico/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do médico a ser deletado.

- `getById(id)`: Retorna um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do médico a ser retornado.

- `getExames(id)`: Retorna os exames associados a um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}/exames`
  - Parâmetros: `id` (caminho da requisição) - ID do médico.

- `getConsultas(id)`: Retorna as consultas associadas a um médico pelo ID.
  - Método HTTP: GET
  - Path: `/medico/{id}/consultas`
  - Parâmetros: `id` (caminho da requisição) - ID do médico.

</details>

<details>
  <summary>Consulta</summary>
  <br>
  
O `ConsultaController` é responsável por lidar com as requisições relacionadas às consultas.

## Métodos

- `getAll()`: Retorna todas as consultas cadastradas.
  - Método HTTP: GET
  - Path: `/consulta/all`
  - Parâmetros: Nenhum.

- `add(consulta)`: Adiciona uma nova consulta.
  - Método HTTP: POST
  - Path: `/consulta/add`
  - Parâmetros: `consulta` (corpo da requisição) - Objeto Consulta a ser adicionado.

- `update(consulta)`: Atualiza uma consulta existente.
  - Método HTTP: PUT
  - Path: `/consulta/edit`
  - Parâmetros: `consulta` (corpo da requisição) - Objeto Consulta atualizado.

- `delete(id)`: Deleta uma consulta pelo ID.
  - Método HTTP: DELETE
  - Path: `/consulta/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID da consulta a ser deletada.

- `getById(id)`: Retorna uma consulta pelo ID.
  - Método HTTP: GET
  - Path: `/consulta/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID da consulta a ser retornada.


</details>

<details>
  <summary>Exame</summary>
  <br>
  O `ExameController` é responsável por lidar com as requisições relacionadas aos exames.

## Métodos

- `add(exame)`: Adiciona um novo exame.
  - Método HTTP: POST
  - Path: `/exame/add`
  - Parâmetros: `exame` (corpo da requisição) - Objeto Exame a ser adicionado.

- `update(exame)`: Atualiza um exame existente.
  - Método HTTP: PUT
  - Path: `/exame/edit`
  - Parâmetros: `exame` (corpo da requisição) - Objeto Exame atualizado.

- `delete(id)`: Deleta um exame pelo ID.
  - Método HTTP: DELETE
  - Path: `/exame/delete/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do exame a ser deletado.

- `getById(id)`: Retorna um exame pelo ID.
  - Método HTTP: GET
  - Path: `/exame/{id}`
  - Parâmetros: `id` (caminho da requisição) - ID do exame a ser retornado.

- `getAll()`: Retorna todos os exames cadastrados.
  - Método HTTP: GET
  - Path: `/exame/all`
  - Parâmetros: Nenhum.
</details>
