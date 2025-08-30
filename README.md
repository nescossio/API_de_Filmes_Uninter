# API_de_Filmes_Uninter
O intuito deste repositório é armazenar o projeto (atividade prática) da disciplina de Desenvolvimento Web - Back End da Faculdade Uninter.

# **Projeto - API de Filmes**
A Filmes API é uma API REST desenvolvida em Spring Boot, que permite gerenciar uma lista de filmes utilizando um banco de dados H2 em memória. A API suporta operações de criação, leitura, atualização e remoção (CRUD) de filmes, oferecendo endpoints para testes via Postman.

---

# **Guia de uso passo a passo da Filmes API**

Este guia mostra como testar todos os métodos do CRUD da Filmes API na ordem correta, usando o Postman.

---

## **1️⃣ Preparar o ambiente**

1. Certifique-se de que a aplicação Spring Boot está **rodando**.
2. Acesse o **H2 Console** se quiser acompanhar os dados:

   ```
   http://localhost:8080/h2-console
   ```

   * JDBC URL: `jdbc:h2:mem:filmes`
   * User: `sa`
   * Password: (em branco)
3. Abra o **Postman** e crie uma coleção chamada **Filmes API**.

---

## **2️⃣ Criar filmes (POST)**

**Objetivo:** Inserir filmes para testar os demais métodos.

1. Endpoint: `POST http://localhost:8080/filmes`
2. Headers: `Content-Type: application/json`
3. Body (exemplo de um filme):

```json
{
    "id": "1",
    "titulo": "O Senhor dos Anéis",
    "descricao": "A sociedade do anel inicia a jornada para destruir o Um Anel.",
    "anoLancamento": 2001,
    "genero": "Fantasia"
}
```

4. Clique em **Send**.
5. Repita para outros filmes (IDs diferentes).
   💡 **Dica:** Inlclua 2-3 filmes para iniciar.

---

## **3️⃣ Listar todos os filmes (GET)**

**Objetivo:** Verificar que os filmes foram criados.

1. Endpoint: `GET http://localhost:8080/filmes`
2. Clique em **Send**.
3. Verifique se todos os filmes criados aparecem no JSON de resposta.
   💡 Isso confirma que o POST funcionou.

---

## **4️⃣ Buscar um filme por ID (GET)**

**Objetivo:** Testar a busca individual.

1. Escolha um ID de filme que você criou (ex: `1`).
2. Endpoint: `GET http://localhost:8080/filmes/1`
3. Clique em **Send**.
4. Confirme que a resposta contém apenas aquele filme.
5. Teste também um ID inexistente (ex: `999`) para ver o retorno `404 Not Found`.

---

## **5️⃣ Atualizar um filme (PUT)**

**Objetivo:** Alterar informações de um filme existente.

1. Escolha um ID de filme existente (ex: `1`).
2. Endpoint: `PUT http://localhost:8080/filmes/1`
3. Headers: `Content-Type: application/json`
4. Body (exemplo de atualização):

```json
{
    "titulo": "O Senhor dos Anéis - A Sociedade do Anel",
    "descricao": "Atualização da descrição do filme.",
    "anoLancamento": 2001,
    "genero": "Fantasia"
}
```

5. Clique em **Send**.
6. Confirme que o JSON de resposta mostra o filme atualizado.
7. Tente atualizar um ID que não existe para testar `404 Not Found`.

---

## **6️⃣ Deletar um filme (DELETE)**

**Objetivo:** Remover filmes da base de dados.

1. Escolha um ID de filme existente (ex: `3`).
2. Endpoint: `DELETE http://localhost:8080/filmes/1`
3. Clique em **Send**.
4. O status retornado deve ser `204 No Content`.
5. Tente buscar (`GET`) o mesmo ID e confirme que retorna `404 Not Found`.

---

## **💡 Ordem recomendada resumida**

1. **POST** – Criar filmes (1 ou mais)
2. **GET** – Listar todos
3. **GET /{id}** – Buscar filme individual
4. **PUT /{id}** – Atualizar filme
5. **DELETE /{id}** – Remover filme
6. **GET** – Conferir lista final


