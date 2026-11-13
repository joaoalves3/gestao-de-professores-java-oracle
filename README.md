# Gestão de Professores — Java + Oracle

Sistema de terminal para cadastrar professores em um banco **Oracle** e calcular o salário de cada um. Projeto desenvolvido no curso de Sistemas de Informação da **FIAP**.

## O que o sistema faz

- **Cadastrar** professor (nome, aulas por semana e valor da hora-aula).
- **Listar** professores com regime de trabalho e salário.
- **Buscar** professor pelo ID.
- **Deletar** professor.
- **Calcular o salário** automaticamente no cadastro:
  - Salário base = valor da hora × aulas por semana × 4,5 semanas
  - DSR (descanso semanal remunerado) = salário base ÷ 6
  - Hora-atividade = 5% de (salário base + DSR)
  - Salário total = base + DSR + hora-atividade
- **Definir o regime:** até 12 aulas = horista; de 13 a 39 = parcial; 40 ou mais = integral.

## Tecnologias

- Java 17+
- Oracle Database e JDBC (`ojdbc11`)
- Maven
- Padrão DAO, `Optional` e `ConnectionFactory`

## Estrutura

```
src/main/java
├── Main.java                 # menu do sistema
├── display/Display.java      # telas de entrada e saída
├── model/Professor.java      # regras de cálculo de salário e regime
├── dao/                      # acesso ao banco (padrão DAO)
└── factory/ConnectionFactory # abre a conexão com o Oracle
sql/script.sql                # criação da tabela e consulta de exemplo
```

## Como rodar

1. Rode o arquivo `sql/script.sql` no SQL Developer para criar a tabela. Se ela já existir, pule o `CREATE TABLE`.
2. Copie `src/main/resources/database.properties.example` para `src/main/resources/database.properties` e preencha seu usuário e sua senha do Oracle. Esse arquivo fica fora do GitHub (está no `.gitignore`).
3. Abra o projeto no IntelliJ e rode a classe `Main`.
