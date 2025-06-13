
Proyecto backend educativo desarrollado en Java con Spring Boot. Simula una API REST para gestionar usuarios y operaciones basicas como envío de montos entre usuarios y consulta de movimientos.

Este proyecto forma parte de mi proceso de formación como desarrollador backend / QA. El objetivo fue aprender los conceptos esenciales de una API REST, mejorar lógica, manejo de datos en memoria y consumo de endpoints vía Postman.

Desarrollada con Spring Boot y PostgreSQL, como parte de mi aprendizaje en desarrollo backend.


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



## 💡 ¿Qué aprendí con este proyecto?

- Creación de APIs REST con Spring Boot
- Definición de controladores y servicios
- Uso de DTOs para la transferencia de datos
- Simulación de lógica financiera básica (envíos, movimientos, saldos)
- Estructuración de un proyecto backend con capas claras
- Consumo y prueba de endpoints con Postman

 ## ⚠️ Estado actual
## 🚧 En Desarrollo
Este proyecto está en una versión inicial. No incluye autenticación ni validaciones profundas. 
Originalmente no tenía persistencia, pero fue extendido para conectarse con PostgreSQL. Está orientado a prácticas de aprendizaje y será mejorado en futuras versiones.


##  📦 Instalación y Configuración
## Requisitos:

### Java 17

### PostgreSQL 15

### Maven 3.8+



Sebastián Vivas
LinkedIn  https://www.linkedin.com/in/sluisvivas/
📧 sebastian14vivas@hotmail.com
