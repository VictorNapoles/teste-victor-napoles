# Desafio Técnico - Analista Java - Victor de Nápoles dos Santos

O desafio proposto foi criar um webservice que colete informações de livros da Saraiva e que forneça essas informações por
meio de um serviço.

## Sistema operacional

Linux Ubuntu

## Tecnologias utilizadas

* Java 8
* Maven 3
* Spring boot
* Spring data
* Spring mvc
* PostgreSQL

## Passos para executar a aplicação

Obs.: Necessário ter o Java 8 e o Maven instalado.

### Passo 1

Instale o PostgreSQL.

```
$ sudo apt-get update
$ sudo apt-get install postgresql postgresql-contrib
```

### Passo 2

Altere a senha do usuário default do PostgreSQL.

```
$ sudo -u postgres psql

     postgres=> alter user postgres password 'postgres';
     postgres=> \q
	 
```

### Passo 3

Instale o Git.

```
$ sudo apt-get update
$ sudo apt-get install git
```

### Passo 4

Clone o repositório do GitHub.

```
git clone https://github.com/VictorNapoles/teste-victor-napoles.git
```

### Passo 5

Acesse o diretório da aplicação e execute o build no Maven.

```
cd teste-victor-napoles
mvn clean install spring-boot:run
```
