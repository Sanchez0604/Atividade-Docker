Gerenciador de Arquivos - Aplicação Java com DockerEste projeto consiste em uma aplicação web completa para upload e listagem de arquivos, desenvolvida em Java com Spring Boot. A aplicação é totalmente containerizada usando Docker e Docker Compose, seguindo uma arquitetura robusta e pronta para produção.Pré-requisitosAntes de começar, certifique-se de que você tem as seguintes ferramentas instaladas em sua máquina:DockerDocker ComposeComo ExecutarSiga os passos abaixo para clonar e executar a aplicação localmente.1. Clone o Repositóriogit clone https://github.com/Sanchez0604/Atividade-Docker.git
cd Atividade-Docker

2. Crie o Arquivo de ConfiguraçãoA aplicação utiliza um arquivo .env para gerenciar as variáveis de ambiente, como senhas e configurações do banco de dados. Crie este arquivo na raiz do projeto:# Crie o arquivo .env
   touch .env

Agora, adicione o seguinte conteúdo ao arquivo .env.# Variáveis de Ambiente para o Banco de Dados PostgreSQL
POSTGRES_DB=<nome do banco>
POSTGRES_USER=<usuario>
POSTGRES_PASSWORD=<senha>
POSTGRES_HOST=db
POSTGRES_PORT=5432

3. Construa as Imagens e Suba os ContainersCom o Docker em execução, execute o seguinte comando na raiz do projeto. Ele irá construir a imagem da aplicação Java (usando o Dockerfile), baixar a imagem do PostgreSQL e iniciar todos os serviços.docker-compose up --build

4. Acesse a AplicaçãoApós os containers iniciarem com sucesso, a aplicação estará disponível em seu navegador no seguinte endereço:URL: http://localhost:8080Você verá uma página html para fazer o upload e listar os arquivos.5. Para Parar a AplicaçãoPara parar todos os containers, pressione Ctrl + C no terminal onde o docker-compose está rodando. Se você iniciou em modo detached, use o comando:docker-compose down

Endpoints da APIA aplicação expõe os seguintes endpoints:MétodoRotaDescriçãoPOST/uploadRealiza o upload de um novo arquivo.GET/Retorna uma lista com todos os arquivos.