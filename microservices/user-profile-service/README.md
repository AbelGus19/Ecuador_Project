# User Profile Service

Este microservicio gestiona los perfiles de usuario.

## Requisitos

- Docker y Docker Compose
- JDK 17
- Maven

## Configuración

1. Copia `.env.example` a `.env` y ajusta las variables.
2. Ejecuta `docker-compose up --build` para levantar la base de datos y el servicio.
3. El servicio correrá en `http://localhost:8081`.

## Endpoints

- `POST /profiles`
- `GET /profiles/{id}`
- `GET /profiles/user/{userId}`
- `PUT /profiles/{id}`
- `DELETE /profiles/{id}`

## Swagger

Accede a `http://localhost:8081/swagger-ui.html` para la documentación de la API.
