## Microserviço para Cotação de Dolar no BCB

### 1. User Story

*"Como um cliente do Dollar's Quote eu gostaria de obter a cotação do dólar comercial para compra e venda em uma determinada data."*

- **Ator:** Cliente do Microserviço Dollar's Quote
- **Ação:** Consultar a cotação do dólar comercial em uma determinada data
- **Objetivo:** Obter a cotação do dólar comercial para compra e venda


### 2. Critérios de Aceitação

**2.1.** O Cliente não pode obter a cotação se não informar uma data correta no formato yyyyMMdd (Ex.: 20200310).

**2.2.** Deve retornar a cotação de compra, venda e hora da cotação. O Valor de compra ou venda deve ser maior que 0.0.

**2.3.** Caso não encontre uma cotação uma mensagem deve informar o cliente

### 3. Cenários de Testes

**3.1.** Verificar a operação se a data não for informada

**3.1.1.** Caso de Teste

Prioridade de teste: Alta
Resumo do Teste: Enviar uma solicitação GET (REST) não informando a data de cotação
Resultados Esperados: Obtenção de uma mensagem de error (404)

**3.2.** Verifique a operação se a data estiver no formato incorreto

**3.2.1.** Caso de Teste

**Prioridade de teste:** Alta

**Resumo do Teste:** Enviar uma solicitação GET (REST) usando um formato incorreto

**Resultados Esperados:** Obtenção de uma mensagem de error (404)

**3.3.** Verifique se a cotação do Dólar é retornada

**3.3.1.** Caso de Teste

**Prioridade de teste:** Alta

**Resumo do Teste:** Enviar uma consulta passando a data para a obtenção da cotação

**Resultados Esperados:** Obtenção da cotação do dólar para Compra, Venda, Data e Hora da Cotação. O Valor de compra ou venda deve ser maior que 0.

### 4. Swagger API

[https://app.swaggerhub.com/apis/marcelo-soares-souza/dollarquote/1.0](https://app.swaggerhub.com/apis/marcelo-soares-souza/dollarquote/1.0)

### 5. Tecnologias

Debian GNU/Linux 10, Java 8 (GraalVM 20.0.0), Quarkus, Panache (ORM), PostgreSQL, Docker, Docker-Compose, Jaeger, Grafana, Prometheus e etc.

### 6. Executando

**6.1.** Pré Requisito (Varíaveis de Ambiente e Banco de Dados PostgreSQL)

export DB_URL="jdbc:tracing:postgresql://localhost:5432/devel"

export DB_USER=devel

export DB_PASSWORD=devel

docker run -p 5432:5432 --name postgres -e POSTGRES_DB=devel -e POSTGRES_USER=$DB_USER -e POSTGRES_PASSWORD=$DB_PASSWORD -d postgres

**6.2.** Teste (Necessita Docker)

mvn test

**6.3.** Ambiente Devel

mvn compile compile quarkus:dev

OBS: Exemplo de URL (GET): http://localhost:8080/quote/20200312

**6.4.** Produção Completo (Aplicação, Banco de Dados, Jaeger, Grana, Prometheus

docker-compose up --build --force-recreate
