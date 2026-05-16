# 👗 Loja de Roupa API

API REST para gerenciamento de uma loja de roupas — construída com Java 17, Spring Boot e PostgreSQL.

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=flat-square&logo=postgresql)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI_3.0-85EA2D?style=flat-square&logo=swagger)

---

## 📋 Sobre o Projeto

API RESTful desenvolvida para gerenciar o catálogo de produtos de uma loja de roupas. Permite criar, listar, atualizar e remover peças do catálogo, com validação de dados, documentação interativa via Swagger e persistência em banco de dados relacional.

---

## 🚀 Tecnologias

| Tecnologia | Versão | Função |
|---|---|---|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.x | Framework backend |
| Spring Web | — | Camada HTTP / Controllers |
| Spring Data JPA | — | Persistência / ORM |
| Hibernate | — | Implementação JPA |
| PostgreSQL | 16 | Banco de dados |
| SpringDoc OpenAPI | 2.3.0 | Documentação Swagger |
| Lombok | — | Redução de boilerplate |
| Bean Validation | — | Validação de dados |

---

## 📁 Estrutura do Projeto

```
src/
└── main/
    ├── java/loja/roupa/
    │   ├── controllers/     → Camada HTTP — recebe e responde requisições
    │   ├── services/        → Regras de negócio
    │   ├── repositories/    → Comunicação com o banco de dados
    │   ├── models/          → Entidades JPA — representam as tabelas
    │   ├── dtos/            → Objetos de transferência de dados
    │   └── doc/             → Configurações do Swagger
    └── resources/
        └── application.properties
```

---

## 🔗 Endpoints

### Roupas

| Verbo | Rota | Descrição | Status |
|---|---|---|---|
| `GET` | `/Roupas` | Listar todas as roupas | `200 OK` |
| `GET` | `/Roupas/{id}` | Buscar roupa por ID | `200 OK` / `404` |
| `POST` | `/Roupas` | Cadastrar nova roupa | `201 Created` |
| `PUT` | `/Roupas/{id}` | Substituir roupa completa | `200 OK` / `404` |
| `PATCH` | `/Roupas/{id}` | Atualizar campos específicos | `200 OK` / `404` |
| `DELETE` | `/Roupas/{id}` | Remover roupa | `204 No Content` / `404` |

---

## 📦 Exemplo de Requisição

**Cadastrar roupa — `POST /Roupas`**

```json
{
  "nome": "Camiseta Básica",
  "vendedor": "Ana Farias",
  "preco": 49.90,
  "estoque": 5,
  "categoria": "Camiseta"
}
```

**Resposta — `201 Created`**

```json
{
  "id": 1,
  "nome": "Camiseta Básica",
  "vendedor": "Ana Farias",
  "preco": 49.90,
  "estoque": 5,
  "categoria": "Camiseta"
}
```

---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Maven 3.8+](https://maven.apache.org/)
- [PostgreSQL 16](https://www.postgresql.org/)

### 1. Clone o repositório

```bash
git clone https://github.com/ivossgh/lojaroupa.git
cd lojaroupa
```

### 2. Crie o banco de dados

```sql
CREATE DATABASE artificium_db;
```

### 3. Configure o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/artificium_db
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 4. Rode a aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📖 Documentação Interativa

Com a aplicação rodando, acesse o Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

Lá você pode visualizar todos os endpoints, ver os schemas de request/response e testar as requisições diretamente pelo navegador — sem precisar de Postman ou Insomnia.

---

## 🏗️ Arquitetura

A API segue o padrão de camadas do Spring Boot:

```
Cliente HTTP
     │
     ▼
  Controller   → recebe requisição, delega ao Service
     │
     ▼
  Service      → aplica regras de negócio
     │
     ▼
  Repository   → executa operações no banco
     │
     ▼
  PostgreSQL   → persiste os dados
```

Cada camada tem uma responsabilidade única e não conhece os detalhes de implementação das outras — princípio de separação de responsabilidades.

---

## ✅ Funcionalidades

- [x] CRUD completo de roupas
- [x] Validação de dados de entrada
- [x] Status codes HTTP semânticos
- [x] Documentação Swagger / OpenAPI 3.0
- [x] Separação em camadas (Controller / Service / Repository)
- [x] DTOs para controle do contrato da API
- [ ] Autenticação JWT *(em breve)*
- [ ] Paginação e filtros *(em breve)*
- [ ] Relacionamento com categorias e pedidos *(em breve)*

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
