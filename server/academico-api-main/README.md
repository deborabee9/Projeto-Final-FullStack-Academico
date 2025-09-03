# academico-api

Este projeto é uma API desenvolvida em Java utilizando o framework Spring Boot, com o objetivo de gerenciar informações acadêmicas, como alunos e cursos. A aplicação faz parte das atividades da disciplina **Programação Orientada a Objetos II**.

## Endpoints

- **Listar Alunos**: GET {{address}}/academico/alunos
- **Buscar Aluno por ID**: GET {{address}}/academico/alunos/{id}
- **Inserir Aluno**: POST {{address}}/academico/alunos
- **Atualizar Aluno**: PUT {{address}}/academico/alunos/{id}
- **Excluir Aluno**: DELETE {{address}}/academico/alunos/{id}

## Testes

Os testes da aplicação estão localizados no package `requests/`. Este package contém os arquivos necessários para realizar requisições HTTP simuladas, permitindo validar o comportamento da API.
