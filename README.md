API REST para gestión de usuarios desarrollada con Spring Boot y PostgreSQL, como parte de un proyecto de aprendizaje en desarrollo backend.


## 🌟 Características Principales

| Funcionalidad               | Detalle                                                                 |
|-----------------------------|-------------------------------------------------------------------------|
| **CRUD Completo**           | Creación, lectura, actualización y eliminación de usuarios             |
| **ID Automático**           | Generación incremental de identificadores únicos                       |
| **Validaciones**            | Campos obligatorios y formato de email con `@NotBlank` y `@Email`      |
| **Registro Temporal**       | Fecha de creación automática usando `@PrePersist`                      |
| **Balance Financiero**      | Manejo preciso de montos con `BigDecimal`


- Modelo de usuario con:
  - Nombre completo
  - Email único
  - Fecha de creación/actualización
  - Configuración de base de datos PostgreSQL

- **Operaciones Transaccionales**:
  - Relación `@OneToMany` con entidad Transaction (base para futuras implementaciones)

- **Documentación Completa**:
  - Swagger UI con ejemplos interactivos
  - Respuestas HTTP detalladas (201, 400, 404, etc.)

## 🛠 Tecnologías Utilizadas

<div align="center">

| **Categoría**       | **Tecnologías**                                                                                  |
|---------------------|--------------------------------------------------------------------------------------------------|
| **Lenguaje**        | ![Java](https://img.shields.io/badge/-Java%2017-ED8B00?logo=openjdk&logoColor=white)             |
| **Framework**       | ![Spring Boot](https://img.shields.io/badge/-Spring%20Boot%203.1.5-6DB33F?logo=spring)          |
| **Base de Datos**   | ![PostgreSQL](https://img.shields.io/badge/-PostgreSQL%2015-336791?logo=postgresql)             |
| **ORM**             | ![Hibernate](https://img.shields.io/badge/-Hibernate-59666C?logo=hibernate&logoColor=white)     |
| **Documentación**   | ![Swagger](https://img.shields.io/badge/-Swagger%20UI-85EA2D?logo=swagger)                     |

</div>



## 📡 Endpoints Principales

### 🔍 Obtener todos los usuarios
GET /api/users/users

### 📌 Obtener usuario específico
GET /api/users/{id}


✅ 200 OK - Usuario encontrado

❌ 404 Not Found - Usuario no existe

### ✨ Crear nuevo usuario
POST /api/users

Body Request

json
{
  "fullName": "Carlos Méndez",
  "email": "carlos@fintech.com"
}



Validaciones:

🛑 fullName: Campo obligatorio (mínimo 3 caracteres)

🛑 email: Formato válido y único en el sistema




##  📦 Instalación y Configuración
## Requisitos:

### Java 17

### PostgreSQL 15

### Maven 3.8+

## 🚧 En Desarrollo

Sebastián Vivas
LinkedIn  https://www.linkedin.com/in/sluisvivas/
📧 sebastian14vivas@hotmail.com
