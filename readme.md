**Gerenciador de Arquivos - Aplicação Java com Docker**

Este projeto consiste em uma aplicação web para upload e listagem de arquivos, desenvolvida em Java com Spring Boot. A aplicação foi projetada para rodar em container usando Docker e Docker Compose, seguindo uma lista de requisitos pedidos em uma atividade de computação em nuvem. Essa projeto já se pronto para produção.

**Pré-requisitos**

Antes de começar, certifique-se de que você tem as seguintes ferramentas instaladas em sua máquina:

**-Docker**

**-Docker Compose**

**Como Executar**

Siga os passos abaixo para clonar e executar a aplicação localmente.

**1. Clone o Repositório**
```
git clone https://github.com/Sanchez0604/Atividade-Docker.git
cd Atividade-Docker  
```
**2. Crie o Arquivo de Configuração**
A aplicação utiliza um arquivo .env para gerenciar as variáveis de ambiente, como senhas e configurações do banco de dados.
Crie este arquivo na raiz do projeto:

```touch .env```

Agora, adicione o seguinte conteúdo ao arquivo .env.

**Variáveis de Ambiente para o Banco de Dados PostgreSQL**
```
POSTGRES_DB=<nome do banco>
POSTGRES_USER=<usuario>
POSTGRES_PASSWORD=<senha>
POSTGRES_HOST=db  <- Se quiser mudar o nome do host, será necessário alterar também no docker-compose.yml
POSTGRES_PORT=5432
```
**3. Construa as Imagens e Suba os Containers**
   Com o Docker em execução, execute o seguinte comando na raiz do projeto. Ele irá construir a imagem da aplicação Java (usando o Dockerfile), baixar a imagem do PostgreSQL e iniciar todos os serviços.
   
   ```docker-compose up --build```
   
**4. Acesse a Aplicação**
   Após os containers iniciarem com sucesso, a aplicação estará disponível em seu navegador no seguinte endereço:
   URL: http://localhost/ Você verá uma página html para fazer o upload e listar os arquivos.

**5. Para Parar a Aplicação**
   Para parar todos os containers, pressione Ctrl + C no terminal onde o docker-compose está rodando. Se você iniciou em modo detached, use o comando:
   ```docker-compose down```

**Endpoints da API**

A aplicação expõe os seguintes endpoints:

| Método | Rota | Descrição |
| :--- | :--- | :--- |
| POST | `/upload` | Realiza o upload de um novo arquivo. |
| GET | `/` | Retorna uma lista com todos os arquivos. |
