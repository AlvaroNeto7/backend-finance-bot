# ☕ Backend Finance Bot

API REST desenvolvida com **Java + Spring Boot** para registrar gastos financeiros utilizando linguagem natural.

O objetivo do projeto é permitir que usuários anotem despesas de forma simples e rápida através de mensagens como:

```text
gastei 50 no ifood
```

E receber uma resposta inteligente:

```text
Anotei aqui 👍
💸 Gasto: R$ 50,00 (alimentação)
📊 Total no mês: R$ 120,00
```

---

# 🚀 Sobre o projeto

O **Backend Finance Bot** nasceu da ideia de transformar o tradicional controle financeiro em algo mais natural, simples e próximo da rotina das pessoas.

Ao invés de formulários complexos, o usuário apenas escreve uma frase comum do dia a dia e a aplicação interpreta automaticamente:

* valor do gasto
* categoria
* tipo da transação
* total acumulado no mês

---

# 🧠 Como funciona

Fluxo da aplicação:

```text
Usuário
   ↓
Mensagem natural
   ↓
Spring Boot API
   ↓
Parser de texto
   ↓
Service Layer
   ↓
Banco de Dados
```

Exemplo:

```text
gastei 70 de gasolina
```

Transformado em:

```json
{
  "description": "gasolina",
  "amount": 70.0,
  "type": "EXPENSE",
  "category": "transporte"
}
```

---

# ⚙️ Tecnologias utilizadas

## Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Maven

## Banco de dados

* H2 Database

## Arquitetura

* REST API
* Arquitetura em camadas
* Controller / Service / Repository

---

# ✨ Funcionalidades

✅ Receber mensagens em texto natural
✅ Interpretar gastos automaticamente
✅ Identificar valor da transação
✅ Categorizar despesas
✅ Persistir dados no banco
✅ Calcular total mensal por categoria
✅ Responder com mensagens amigáveis
✅ Integração pronta com frontend React

---

# 🔌 Endpoint principal

## POST `/webhook`

Recebe uma mensagem simples em texto puro.

### Exemplo de request

```text
gastei 30 no ifood
```

### Exemplo de response

```text
Anotei aqui 👍
💸 Gasto: R$ 30,00 (alimentação)
📊 Total no mês: R$ 120,00
```

---

# 🏗️ Estrutura do projeto

```text
src/main/java/com/alvaro/financebot
│
├── controller
│   └── WebhookController.java
│
├── entity
│   └── Transaction.java
│
├── repository
│   └── TransactionRepository.java
│
├── service
│   ├── MessageParserService.java
│   └── TransactionService.java
│
└── FinanceBotApplication.java
```

---

# ▶️ Como executar localmente

## 1. Clone o projeto

```bash
git clone https://github.com/AlvaroNeto7/backend-finance-bot.git
```

---

## 2. Entre na pasta

```bash
cd backend-finance-bot
```

---

## 3. Execute a aplicação

```bash
mvn spring-boot:run
```

---

# 🌐 API local

```text
http://localhost:8081
```

---

# 🗄️ Banco H2

O projeto utiliza H2 Database em memória para simplificar testes e desenvolvimento local.

## Console H2

```text
http://localhost:8081/h2-console
```

### Configuração padrão

```text
JDBC URL: jdbc:h2:mem:financebot
User: sa
Password:
```

---

# 🎨 Frontend do projeto

Aplicação React integrada ao backend:

```text
https://github.com/AlvaroNeto7/finance-bot-front
```

---

# 📈 Próximas evoluções

* [ ] PostgreSQL
* [ ] Login e autenticação JWT
* [ ] Dashboard financeiro
* [ ] Histórico de transações
* [ ] Deploy completo em nuvem
* [ ] Integração com WhatsApp
* [ ] IA para categorização inteligente

---

# 💡 Motivação

Este projeto foi criado com foco em aprendizado prático de desenvolvimento backend moderno utilizando Java e Spring Boot.

A proposta foi sair do tradicional CRUD acadêmico e construir algo próximo de um produto real, integrando backend, frontend e experiência do usuário.

---

# 👨‍💻 Autor

Desenvolvido por **Alvaro Neto** 🚀
