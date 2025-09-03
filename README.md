# Acadêmico App — (Angular + Spring Boot)

Este monorepo reúne **frontend (Angular)** e **backend (Spring Boot)** sem alterações de estilo.

## Estrutura
- `web/academico-frontend-main` — Aplicação Angular.
- `server/academico-api-main` — API Spring Boot com Maven Wrapper (`mvnw`).

## Requisitos
- Node.js LTS (>=18) e NPM
- Java 17+ (ou a versão indicada no `pom.xml`)
- Maven **não é necessário** (usa o wrapper `mvnw` incluído).

## Instalação e Execução em Desenvolvimento
No diretório raiz do monorepo:
```bash
npm install
npm run dev
```
Isto inicia:
- **Backend** em `http://localhost:8080` (`spring-boot:run`)
- **Frontend** em `http://localhost:4200` (`ng serve` ou script existente)

> Em Windows, rode via Git Bash/WSL ou adapte o script para `mvnw.cmd`.

## Build de Produção
```bash
npm run build:server   # empacota o backend
npm run build:web      # gera build do Angular
```

## Comunicação Frontend → Backend
- Configure o **proxy** do Angular se desejar usar `/api` durante o desenvolvimento.
- Alternativamente, ajuste os `environment.ts` do Angular para apontar para `http://localhost:8080`.

## Observações
- Os estilos do frontend foram **mantidos**.
- Código de cada projeto preservado; a melhoria principal foi a integração e scripts de automação para rodar os dois juntos.
