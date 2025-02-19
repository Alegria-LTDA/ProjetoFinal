Projeto Final: Armazenamento de Arquivos em Banco de Dados Este projeto, chamado Projeto Final, é uma aplicação Spring Boot que permite criar e armazenar arquivos em um banco de dados MySQL.

Funcionalidades Criar e armazenar arquivos: O projeto oferece a funcionalidade de criar novos arquivos e armazená-los em tabelas do banco de dados. 
Gerenciamento de dados: As tabelas Livro e Editora são usadas para armazenar informações sobre os arquivos, incluindo seus metadados. 
Tecnologias Utilizadas Spring Boot: Framework para desenvolvimento de aplicações Java. 
Spring Data JPA: Para acesso e persistência de dados no banco de dados. 
Spring Data JDBC: Para acesso e persistência de dados no banco de dados usando JDBC. 
Swagger: Para documentação e testes da API REST. 
MySQL: Sistema de gerenciamento de banco de dados relacional. 

Dependências Spring Boot Starter Web: Para desenvolvimento de aplicações web. 
Spring Boot Starter Data JPA: Para integração com JPA. 
Spring Boot Starter Data JDBC: Para integração com JDBC. 
MySQL Connector/J: Para conexão com o banco de dados MySQL. 
Springfox Swagger2: Para documentação da API REST. 

Instalação e Execução Baixe o código fonte: Baixe o código do projeto. 
Configure o banco de dados: Crie um banco de dados chamado projetofinal no MySQL e configure as credenciais de acesso no arquivo application.properties. 
Execute o projeto: Navegue até o diretório raiz do projeto e execute o comando mvn spring-boot:run. 
Exemplo de Uso Para utilizar o projeto, você pode usar a API REST documentada no Swagger.

Próximos Passos Implementar a funcionalidade de recuperação de arquivos armazenados. Implementar a funcionalidade de exclusão de arquivos. Adicionar autenticação e autorização para o acesso à API.

Contato Para dúvidas ou sugestões, entre em contato com fernandosrbastos@gmail.com
