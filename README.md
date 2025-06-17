# desafio-backend

Este projeto utiliza o MySQL como database, execute o script que se encontra no caminho:
```
SQL/execute.sql
```

Este projeto utiliza o framework quarkus, para inicia-lo utilize o comando:

```
./mvnw compile quarkus:dev
```

## ENDPOINTS

Criar Pauta:
> **POST**   /pauta/criar
> 
> {
>   "nome": String,
>   "descricao": String
> }

Pauta Iniciar Votação:
> **POST**   /pauta/{idPauta}/abrir-votacao?minutos=

Resultado da Votação da Pauta:
> **GET**   /pauta/{idPauta}/resultado 

Votar na Pauta:
> **POST**  /usuario/votar/pauta/{{idPauta}}
> 
> {
    "idUsuario": Long,
    "voto": String ("SIM", "NAO")
}


