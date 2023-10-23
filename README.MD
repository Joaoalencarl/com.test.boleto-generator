# Meu Projeto Java e React com Vite

Este é um projeto de exemplo que demonstra como criar uma aplicação web com um backend Java e um frontend React com Vite.

## Pré-requisitos

Antes de começar, certifique-se de que você tenha o seguinte instalado em sua máquina:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Node.js](https://nodejs.org/)
- [npm](https://www.npmjs.com/) (gerenciador de pacotes Node.js)
- [Vite](https://vitejs.dev/) (instalado globalmente com `npm install -g create-vite`)

## Configuração do Backend

Abra um terminal e navegue até a pasta do backend:

```bash
cd backend
````
Compile e execute o backend Java:
```
./mvnw spring-boot:run
``````
***O backend estará disponível em http://localhost:8080.***

## Configuração do Frontend

Abra um novo terminal e navegue até a pasta do frontend:
````
cd frontend
````
Instale as dependências do frontend:
````
npm install
````
Inicie o servidor de desenvolvimento do frontend com Vite:
````
npm run dev
````

***O frontend estará disponível em http://localhost:3000.***

### Uso:
Agora você pode acessar a aplicação em seu navegador. O frontend se comunicará com o backend em http://localhost:8080 para buscar ou enviar dados.