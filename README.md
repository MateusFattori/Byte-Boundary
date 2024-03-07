# Byte-Boundary

## Documentos

`GET` /documentos

Lista todos os documentos cadastradas no sistema.

`200` sucesso

---

`GET` /documentos{maritimo}

Retorna os detalhes de uma documeto com o filtro `maritimo` informado.

`GET` /documentos{aerio}

Retorna os detalhes de uma documeto com o filtro `aerio` informado.

**códigos de status**

`200` sucesso
`404` filtro não encontrado

---

`GET` /categoria/{id}

Retorna os detalhes de uma documento com o `id` informado.

**códigos de status**

`200` sucesso
`404` id não encontrado

---

 **Schema**

```js
{
    "id": 1,
    "documento": "Exportação",
    "aerio": "",
    "maritimo" : ""
}

```
---

Dupla

Mateus Fattori RM: 97904
Pedro Baraldi RM: 98060
 
 ---
