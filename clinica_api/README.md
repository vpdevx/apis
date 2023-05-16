
# API De clinica

API desenvolvida simulando o ambiente de uma clínica médica

## Entidades

### Paciente

Entidade paciente do banco de dados

#### Estrutura da Entidade

| Campo     | Tipo de Dado | Descrição                      |
|-----------|--------------|--------------------------------|
| id        | Long      | Identificador único da paciente |
| cpf     | String       | CPF do paciente 
| nome      | String       | Nome da paciente               |
| telefone     | String      | Telefone da paciente              |
| email     | String       | Endereço de e-mail             |
| endereco     | String       | Endereço do paciente  
| endereco  | String       | Cidade do paciente 
| endereco  | String       | Estado do paciente 
| data_cadastro | Date         | Data de cadastro do paciente    |
| data_nascimento | Date         | Data de nascimento do paciente    |

#### Relacionamentos

- A tabela paciente possui um relacionamento de um para muitos com a tabela Exame e Consultas.

#### Funcionalidades e Operações

- Criar uma nova entidade.
- Recuperar uma entidade por ID.
- Atualizar os dados de uma entidade existente.
- Excluir uma entidade.
- Listar exames vinculados ao paciente.
- Listar consultas vinculadas ao paciente.




