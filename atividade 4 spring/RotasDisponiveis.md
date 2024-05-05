API de Gerenciamento de Alunos

Esta API foi desenvolvida utilizando o framework Spring Boot para fornecer operações básicas de gerenciamento de alunos, endereços e notas. O banco de dados H2 foi utilizado para armazenar os dados de forma simples e eficiente. Abaixo estão as instruções sobre como usar esta API:

Banco de Dados H2
O H2 Database é um banco de dados relacional escrito em Java que pode ser executado em modo de memória ou em modo de arquivo. Neste projeto, o H2 está sendo utilizado para armazenar os dados dos alunos, endereços e notas de forma leve e integrada à aplicação Spring Boot.

Rotas Disponíveis
Endereços
GET /enderecos/{id} : Retorna os detalhes do endereço com o ID especificado.
POST /enderecos : Cria um novo endereço associado ao aluno com ID 1.
PUT /enderecos/{id} : Atualiza os dados do endereço com o ID especificado com base no JSON fornecido.
DELETE /enderecos/{id} : Exclui o endereço com o ID especificado.

Notas
GET /notas/{id} : Retorna os detalhes da nota com o ID especificado.
POST /notas : Cria uma nova nota associada ao aluno com ID 1.
PUT /notas/{id} : Atualiza os dados da nota com o ID especificado com base no JSON fornecido.
DELETE /notas/{id} : Exclui a nota com o ID especificado.

Alunos
GET /alunos/InfoCompleta/{id} : Retorna todas as informações incluindo notas e endereços do aluno com o ID especificado.
GET /alunos/{id} : Retorna os detalhes do aluno com o ID especificado.
POST /alunos : Cria um novo aluno.
PUT /alunos/{id} : Atualiza os dados do aluno com o ID especificado com base no JSON fornecido.
DELETE /alunos/{id} : Exclui o aluno com o ID especificado.

Requisições
Para fazer uma requisição, utilize um cliente HTTP ou uma ferramenta como insomnia ou Postman.
