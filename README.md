
# Orla's projects

This challenge implements a Restful API.

## Como Executar:
___________________________
* Criar database no Postgres e executar postgres:
  * senha: 123
  * nome: orladatabase
* Usando o docker: 
  * docker pull postgres
  * docker run --name orla-postgres -e POSTGRES_PASSWORD=123 -d -p 5432:5432 postgres
  * acessar psql: docker exec -it orla-postgres psql -U postgres
  * criar database: CREATE DATABASE orladatabase;
    * caso queira parar o container: docker stop orla-postgres
    * caso queira iniciar um container já criado: docker start containerId
____________________________
* Testar API: (Ver coleção do Postman no projeto)
* Funcionario
  * Criar funcionario: Post -  http://localhost:8080/api/funcionario
    * Body:
      * {
        "nome": "Ari2",
        "cpf": "123.456.789-00",
        "email": "martin@example.com",
        "salario": "5000.00"
        }
  * Encontrar Funcionario por Id: Get - http://localhost:8080/api/funcionario/id
  * Listar Todos Funcionários: Get -  http://localhost:8080/api/funcionario
  * Deletar Funcionário: Del - http://localhost:8080/api/funcionario/id

* Projeto
  * Criar Projeto: Post - http://localhost:8080/api/projeto
  * Encontrar Projeto por Id: Get - http://localhost:8080/api/projeto/1
  * Listar todos projetos: Get - http://localhost:8080/api/projeto
  * Deletar projeto: Get - http://localhost:8080/api/projeto/1
  * 
* Projeto-Funcionario
  * Vincular um Funcionário a um Projeto: Post - http://localhost:8080/api/projeto-funcionario
    * Body:
      * {
        "idFuncionario": "1",
        "idProjeto": "2"
        }