# 🧑‍💻 Usuarios Service - Microservicio con Spring Boot

Este proyecto es un microservicio backend desarrollado con **Spring Boot**, que permite realizar operaciones **CRUD** sobre una entidad de usuarios y documenta la API usando **Swagger**. El servicio se conecta a una base de datos **MySQL externa**.

## 🚀 Tecnologías utilizadas

- ✅ Java 17
- ✅ Spring Boot
- ✅ Spring Data JPA
- ✅ MySQL
- ✅ Swagger/OpenAPI
- ✅ Maven

## 🔧 Configuración

### 1. Clonar el proyecto

```bash
git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git
cd TU_REPOSITORIO
```
### 2. Configura las variables de conexión
Este proyecto usa un archivo application.properties, que contiene la configuración para conectar a la base de datos. Por seguridad, este archivo no está en el repositorio.

Copia el archivo de ejemplo y edítalo con tus datos reales:
```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
Edita el archivo y agrega tus credenciales reales:
spring.datasource.url=jdbc:mysql://zetamini.ddns.net:3306/ZetaDb
spring.datasource.username=base
spring.datasource.password=Diego2015*

### 3. ▶️ Ejecución del proyecto
Puedes ejecutar el proyecto desde IntelliJ o desde línea de comandos con Maven:
```bash
./mvnw spring-boot:run
```
Si no tienes el wrapper (mvnw), puedes usar Maven:
```bash
mvn spring-boot:run
```
### 4. 🧪 Endpoints disponibles
| Método | Endpoint           | Descripción                |
| ------ | ------------------ | -------------------------- |
| GET    | /api/usuarios      | Obtener todos los usuarios |
| POST   | /api/usuarios      | Crear nuevo usuario        |
| GET    | /api/usuarios/{id} | Buscar usuario por ID      |
| PUT    | /api/usuarios/{id} | Actualizar usuario         |
| DELETE | /api/usuarios/{id} | Eliminar usuario           |

### 5. Documentación Swagger
http://localhost:8080/swagger-ui/index.html

### 6. Estructura del proyecto
```text
usuariosservice/
├── src/
│   └── main/
│       ├── java/com/alejo/usuariosservice/
│       │   ├── controller/
│       │   ├── model/
│       │   └── repository/
│       └── resources/
│           ├── application.properties (IGNORADO)
│           └── application.properties.example
├── .gitignore
├── README.md
└── pom.xml
```

### 6. 🔐 Seguridad
Este proyecto omite application.properties en Git para proteger credenciales sensibles. Asegúrate de:
No subir archivos con contraseñas.
Crear un archivo .env o .properties.example para compartir estructuras seguras.

### 7. 💬 Autor
Alejandro Zambrano
Desarrollador backend | En transición desde Delphi a Java y Spring Boot
LinkedIn: [enlace aquí]
GitHub: [usuario aquí]
