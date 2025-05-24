# Proyecto Spring Ecommerce Concesionario

---

Este proyecto es una API RESTful desarrollada con Java y Spring Boot, diseñada para gestionar un concesionario de coches. La API permite la gestión de usuarios, roles y autenticación mediante inicio de sesión, proporcionando un sistema seguro y escalable para la administración de datos relacionados con vehículos y usuarios.

---
## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Configuración Spring](#configuración-spring)
- [Instalación](#instalación)
- [Credenciales](#credenciales)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)
---
## Características

- Autenticación y autorización utilizando JWT.
- Cifrado de contraseñas con BCrypt.
- Estructura de código siguiendo los principios SOLID.
- Ejemplos de endpoints para registro y autenticación de usuarios.
- Manejo de excepciones y respuestas estandarizadas.
---
## Tecnologías Utilizadas

- Java 24
- Spring Boot
- JWT (JSON Web Tokens)
- Hibernate
- PostgreSQL (o cualquier base de datos compatible)
- Maven
---
## Configuración Spring

Dependencias proyecto Spring Boot:
* Spring Web
* Spring boot devtools
* Spring Data JPA
* PostgreSQL
* Spring Security
* Dependencia jwt (añadida manualmente en pom.xml)

``` xml
    <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
    <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-api</artifactId>
          <version>0.12.5</version>
      </dependency>
      <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
      <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-impl</artifactId>
          <version>0.12.5</version>
          <scope>runtime</scope>
      </dependency>
      <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
      <dependency>
          <groupId>io.jsonwebtoken</groupId>
          <artifactId>jjwt-jackson</artifactId>
          <version>0.12.5</version>
          <scope>runtime</scope>
      </dependency>
      <!-- https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api -->
      <dependency>
          <groupId>jakarta.servlet</groupId>
          <artifactId>jakarta.servlet-api</artifactId>
          <version>6.0.0</version>
          <scope>provided</scope>
      </dependency>
```
---
## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
---

## Credenciales

Se ha incluido usuarios con Role de OWNER Y ADMINISTRATOR

   ```JSON
  {
    "email": "admin@mail.com",
    "password": "45678"
  }
  ```
  ```JSON
  {
    "email": "owner@mail.com",
    "password": "1234"
  }
  ```

---
## Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos:

Haz un fork del proyecto.
Crea una nueva rama (git checkout -b feature/nueva-caracteristica).
Realiza tus cambios y haz un commit (git commit -m 'Añadir nueva característica').
Haz push a la rama (git push origin feature/nueva-caracteristica).
Abre un Pull Request.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.