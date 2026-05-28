# 📚 Livraria App

Sistema de gerenciamento de biblioteca desenvolvido em Java utilizando Programação Orientada a Objetos (POO), menus interativos e estrutura em camadas.

O projeto permite realizar o gerenciamento de:

- Livros
- Autores
- Clientes
- Empréstimos

Tudo através de um sistema de console organizado em menus.

---

# 🚀 Funcionalidades

## 📖 Livros
- Cadastro de livros
- Listagem de livros
- Controle de disponibilidade
- Associação com autores

## ✍️ Autores
- Cadastro de autores
- Listagem de autores

## 👤 Clientes
- Cadastro de clientes
- Listagem de clientes

## 📄 Empréstimos
- Realização de empréstimos
- Controle de devoluções
- Histórico de empréstimos

---

# 🏗️ Estrutura do Projeto

```bash
src/
├── dao/
│   ├── AutorDao.java
│   ├── BancoDados.java
│   ├── ClienteDao.java
│   ├── Dao.java
│   ├── EmprestimoDao.java
│   └── LivroDao.java
│
├── menu/
│   ├── IMenu.java
│   ├── MenuAutor.java
│   ├── MenuCliente.java
│   ├── MenuEmprestimos.java
│   ├── MenuLivro.java
│   └── MenuPrincipal.java
│
├── model/
│   ├── Autor.java
│   ├── Biblioteca.java
│   ├── Cliente.java
│   ├── Emprestimo.java
│   └── Livro.java
│
└── Main.java
```

---

# 🧱 Arquitetura do Projeto

## 📂 DAO
Responsável pela manipulação e gerenciamento dos dados da aplicação.

## 📂 MENU
Responsável pela interação com o usuário através do console.

## 📂 MODEL
Contém as entidades principais do sistema.

---

# 💻 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos (POO)
- Collections Framework
- Scanner
- LocalDate / LocalDateTime

---

# ▶️ Como Executar

## ✅ Pré-requisitos

- Java 17+ instalado
- IntelliJ IDEA, Eclipse ou VS Code

---

## 📥 Clonar Repositório

```bash
git clone https://github.com/seu-usuario/livraria-app.git
```

---

## 📂 Acessar Projeto

```bash
cd livraria-app
```

---

## ⚙️ Compilar

```bash
javac Main.java
```

---

## ▶️ Executar

```bash
java Main
```

---

# 📚 Conceitos Aplicados

- Classes e Objetos
- Encapsulamento
- Herança e composição
- Organização em camadas
- Manipulação de listas
- Menus interativos
- Relacionamento entre entidades
- Entrada de dados com Scanner

---

# 🚀 Melhorias Futuras

- [ ] Persistência em banco de dados
- [ ] API REST com Spring Boot
- [ ] Interface gráfica
- [ ] Login de usuários
- [ ] Relatórios
- [ ] Busca avançada
- [ ] Exportação de dados

---

# 👨‍💻 Autor
Ueder Carlos Costa Caetano
- [LinkedIn](https://www.linkedin.com/in/uedercosta/)
- [GitHub](https://github.com/uederdev)
Projeto desenvolvido para estudos e prática em Java.
