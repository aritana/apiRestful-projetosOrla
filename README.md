
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
* Rodar aplicação:
 http://localhost:8080/swagger-ui.html