# 🛒 eCommerce Web Application  
### Java Servlets + REST API + JavaScript

Aplicación web de comercio electrónico desarrollada en **Java**, utilizando **Servlets**, **JPA (Hibernate)**, **MySQL**, y una **API REST** consumida desde **JavaScript** para la parte del cliente.

El sistema maneja usuarios, productos, carritos, pedidos, reseñas y autenticación, siguiendo una **arquitectura por capas** bien definida.

---

## 🧱 Arquitectura del Proyecto

El sistema está dividido en varios proyectos (módulos), cada uno con una responsabilidad clara:

- **ecommerceDominio**  
  Entidades del dominio (JPA Entities).

- **ecommercePersistencia**  
  Configuración JPA, DAOs y acceso a base de datos.

- **ecommerceNegocio**  
  Lógica de negocio (BOs), validaciones y reglas.

- **API_ecommerce**  
  API REST (Jakarta / JAX-RS) consumida por JavaScript.

- **ecommerce1.0**  
  Aplicación web (JSP + Servlets + JS + CSS).

---

## 🛠️ Tecnologías Utilizadas

- Java 17+
- Jakarta EE (Servlets, JPA, JAX-RS)
- Hibernate (JPA Provider)
- MySQL
- JavaScript (Fetch API)
- JSP
- Maven
- MySQL Workbench
- NetBeans

---

## 🚀 Instrucciones para Ejecutar el Proyecto

### 1️⃣ Crear la Base de Datos

1. Abrir **MySQL Workbench**
2. Crear una base de datos **SIN tablas** con el nombre:

```sql
CREATE DATABASE ecommerce3;
```

> ⚠️ **No crear tablas manualmente**, JPA se encarga de eso.

3. Crear una nueva conexión en MySQL Workbench  
4. Probar la conexión con **Test Connection**

---

### 2️⃣ Configurar Credenciales de la Base de Datos

En el proyecto **ecommercePersistencia**, modificar el archivo:

```
Other Sources
└── src/main/resources
    └── META-INF
        └── persistence.xml
```

Actualizar las credenciales:

```xml
<property name="jakarta.persistence.jdbc.user" value="TU_USUARIO"/>
<property name="jakarta.persistence.jdbc.password" value="TU_PASSWORD"/>
```

---

### 3️⃣ Compilar los Proyectos (IMPORTANTE)

Una vez descargado el proyecto, ejecutar **CLEAN AND BUILD** en el siguiente orden:

1. ecommerceDominio  
2. ecommercePersistencia  
3. ecommerceNegocio  
4. API_ecommerce  
5. ecommerce1.0  

> 🔁 **El orden es obligatorio** para evitar errores de dependencias.

---

### 4️⃣ Crear las Tablas con JPA

Para que JPA cree automáticamente las tablas en la base de datos:

1. Ir al proyecto **ecommerceNegocio**
2. Navegar a:

```
Test Packages
└── bos
    └── UsuariosBOTest.java
```

3. Ejecutar la prueba unitaria:

```java
testRegistrarUsuarioOK()
```

Esto hará dos cosas:

- Registrará un usuario de prueba
- Creará todas las tablas en la base de datos **ecommerce3**

---

### 5️⃣ Insertar Datos de Prueba

En el proyecto se incluyen dos archivos SQL:

- `TriggersEjecutar.sql`
- `InsertMockEcommerce.sql`

**Orden correcto de ejecución:**

1. Ejecutar primero:

```
TriggersEjecutar.sql
```

(Crea los triggers necesarios)

2. Después ejecutar:

```
InsertMockEcommerce.sql
```

(Inserta los datos de prueba)

---

### 6️⃣ Ejecutar la Aplicación

- La **API (`API_ecommerce`) debe estar activa en todo momento**
- Ejecutar el proyecto **ecommerce1.0**
- El frontend consume la API usando **JavaScript (Fetch)**

---

## ⚠️ Consideraciones Importantes

- Si la API no está levantada, el sistema no funcionará correctamente
- No modificar el esquema de la base de datos manualmente
- Usar siempre el orden correcto de compilación
- Revisar la consola si ocurre algún error (especialmente JPA o conexión)

---

## 👥 Equipo de Desarrollo

Proyecto desarrollado por:

- **Ramón Zamudio Ayala** – 00000251924  
- **Pedro Morales Esquer** – 00000252815  
- **Juan Pablo Heras Carrazco** – 00000247054  
- **Gael Guerra Landavazo** – 00000252522  

---

## 📌 Notas Finales

Este proyecto fue desarrollado con fines académicos, aplicando buenas prácticas de:

- Arquitectura por capas
- Separación de responsabilidades
- Uso correcto de JPA y API REST
- Integración frontend–backend moderna
