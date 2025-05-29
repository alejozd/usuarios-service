# Usuarios Service

Este es un microservicio construido con **Spring Boot** y **Java 17**, que se conecta a una base de datos MySQL remota. Es parte de un proyecto de práctica orientado al aprendizaje de arquitectura de microservicios, backend y patrones modernos.

## 🧱 Tecnologías utilizadas

- Spring Boot 3.x
- Java 17
- Maven
- Spring Web
- Spring Data JPA
- MySQL
- IntelliJ IDEA Community Edition

## ⚙️ Configuración del proyecto

El archivo `application.properties` contiene la configuración para conectarse a la base de datos:

```properties
spring.datasource.url=jdbc:mysql://url de mi server
spring.datasource.username=usuario
spring.datasource.password=pass
