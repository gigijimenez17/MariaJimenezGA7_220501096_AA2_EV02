# MindMeet - Sistema de Gestión de Reuniones con IA

## 📋 Descripción del Proyecto

MindMeet es un sistema web desarrollado en Java EE con Servlets y JSP que permite gestionar reuniones empresariales de manera inteligente, incorporando funcionalidades de transcripción automática mediante Inteligencia Artificial y generación de actas.

## 🏗️ Arquitectura del Sistema

### Tecnologías Utilizadas

- **Backend**: Java SE 8+, Java EE (Servlets, JSP)
- **Base de Datos**: MySQL 8.0
- **Servidor de Aplicaciones**: Apache Tomcat 9.x
- **Frontend**: HTML5, CSS3, JavaScript
- **JSTL**: Core y Format Tags
- **JDBC**: MySQL Connector/J 8.0

### Estructura del Proyecto

```
MindMeet/
├── src/
│   └── com/
│       └── mindmeet/
│           ├── model/          # Modelos de dominio
│           │   ├── Usuario.java
│           │   └── Reunion.java
│           ├── dao/            # Capa de acceso a datos
│           │   ├── UsuarioDAO.java
│           │   └── ReunionDAO.java
│           ├── controller/     # Servlets controladores
│           │   ├── LoginServlet.java
│           │   ├── LogoutServlet.java
│           │   ├── DashboardServlet.java
│           │   └── ReunionServlet.java
│           ├── filter/         # Filtros HTTP
│           │   ├── AuthenticationFilter.java
│           │   └── EncodingFilter.java
│           ├── util/           # Utilidades
│           │   └── DatabaseConnection.java
│           └── listener/       # Listeners
│               └── AppContextListener.java
├── WebContent/
│   ├── WEB-INF/
│   │   ├── web.xml            # Descriptor de despliegue
│   │   ├── views/             # Vistas JSP
│   │   │   ├── login.jsp
│   │   │   ├── dashboard.jsp
│   │   │   ├── reunion-form.jsp
│   │   │   ├── reuniones-lista.jsp
│   │   │   └── reunion-detalle.jsp
│   │   ├── includes/          # Fragmentos JSP
│   │   │   ├── header.jsp
│   │   │   └── footer.jsp
│   │   └── lib/               # Librerías JAR
│   ├── css/
│   │   └── styles.css
│   ├── js/
│   │   └── main.js
│   └── images/
├── sql/
│   └── mindmeet_schema.sql    # Script de base de datos
└── README.md
```

## 🗄️ Modelo de Datos

### Entidades Principales

1. **Usuario**: Representa a los usuarios del sistema
2. **Reunión**: Almacena información de las reuniones
3. **Participante**: Relación entre usuarios y reuniones
4. **Documento**: Actas y transcripciones generadas
5. **Tema**: Temas identificados en reuniones
6. **Acción**: Tareas derivadas de reuniones

## 🚀 Instalación y Configuración

### Requisitos Previos

- JDK 8 o superior
- Apache Tomcat 9.x
- MySQL Server 8.0
- IDE (Eclipse, IntelliJ IDEA, NetBeans)

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/tu-usuario/mindmeet.git
cd mindmeet
```

2. **Crear la base de datos**
```bash
mysql -u root -p < sql/mindmeet_schema.sql
```

3. **Configurar conexión a base de datos**
Editar `DatabaseConnection.java`:
```java
private static final String URL = "jdbc:mysql://localhost:3306/mindmeet_db";
private static final String USER = "tu_usuario";
private static final String PASSWORD = "tu_contraseña";
```

4. **Agregar librerías necesarias**
- Descargar MySQL Connector/J
- Colocar en `WebContent/WEB-INF/lib/`
- Agregar JSTL (jstl-1.2.jar)

5. **Desplegar en Tomcat**
- Copiar el proyecto al directorio webapps de Tomcat
- O configurar el proyecto en tu IDE

6. **Iniciar el servidor**
```bash
# En Windows
$CATALINA_HOME\bin\startup.bat

# En Linux/Mac
$CATALINA_HOME/bin/startup.sh
```

7. **Acceder a la aplicación**
```
http://localhost:8080/mindmeet/login
```

## 👤 Usuarios de Prueba

| Email | Contraseña | Rol |
|-------|-----------|-----|
| admin@mindmeet.com | admin123 | ADMIN |
| maria.jimenez@deloitte.com | maria123 | USER |
| brayan.baron@deloitte.com | brayan123 | USER |

## 📡 Endpoints Principales

### Servlets y Métodos HTTP

| Servlet | URL | Método | Descripción |
|---------|-----|--------|-------------|
| LoginServlet | /login | GET | Mostrar formulario de login |
| LoginServlet | /login | POST | Autenticar usuario |
| LogoutServlet | /logout | GET/POST | Cerrar sesión |
| DashboardServlet | /dashboard | GET | Panel principal |
| ReunionServlet | /reuniones | GET | Listar reuniones |
| ReunionServlet | /reunion | GET | Ver/Editar reunión |
| ReunionServlet | /reunion | POST | Crear/Actualizar reunión |

### Parámetros de Request

#### Login (POST)
```
email: String (requerido)
password: String (requerido)
recordar: String (opcional)
```

#### Crear Reunión (POST)
```
action: "crear"
titulo: String (requerido)
descripcion: String (opcional)
fechaInicio: DateTime (opcional)
```

#### Actualizar Reunión (POST)
```
action: "actualizar"
id: Integer (requerido)
titulo: String (requerido)
descripcion: String (opcional)
transcripcion: Text (opcional)
estado: String (opcional)
```

## 🔐 Seguridad

### Filtros Implementados

1. **AuthenticationFilter**: Protege recursos que requieren autenticación
2. **EncodingFilter**: Establece UTF-8 en todas las peticiones

### Medidas de Seguridad

- Sesiones HTTP con timeout de 30 minutos
- HttpOnly cookies para prevenir XSS
- Validación de sesión en cada request
- Prepared Statements para prevenir SQL Injection
- Encriptación de contraseñas (a implementar)

## 📊 Funcionalidades Principales

### Módulo de Usuarios
- ✅ Registro de usuarios
- ✅ Autenticación (login/logout)
- ✅ Gestión de sesiones
- ✅ Roles y permisos

### Módulo de Reuniones
- ✅ Crear nueva reunión
- ✅ Listar reuniones
- ✅ Ver detalle de reunión
- ✅ Editar reunión
- ✅ Eliminar reunión
- ✅ Finalizar reunión
- ⏳ Grabación de audio (próximamente)
- ⏳ Transcripción automática (próximamente)

### Módulo de Dashboard
- ✅ Estadísticas personalizadas
- ✅ Reuniones recientes
- ✅ Métricas de productividad

### Módulo de Documentos
- ⏳ Generación de actas
- ⏳ Exportar a PDF
- ⏳ Compartir documentos

## 🧪 Pruebas

### Casos de Uso Implementados

1. **CU-001**: Login de usuario
2. **CU-002**: Crear nueva reunión
3. **CU-003**: Listar reuniones del usuario
4. **CU-004**: Ver detalle de reunión
5. **CU-005**: Editar información de reunión
6. **CU-006**: Eliminar reunión
7. **CU-007**: Cerrar sesión

### Datos de Prueba

El script SQL incluye datos de ejemplo:
- 4 usuarios
- 3 reuniones de muestra
- Participantes asignados
- Configuraciones del sistema

## 📈 Mejoras Futuras

- [ ] Integración con API de transcripción (OpenAI Whisper)
- [ ] Generación automática de mapas mentales
- [ ] Integración con Google Calendar
- [ ] Integración con Microsoft Teams
- [ ] Notificaciones por email
- [ ] Chat en tiempo real
- [ ] Exportación a múltiples formatos (PDF, DOCX, TXT)
- [ ] Análisis de sentimientos en transcripciones
- [ ] Panel de administración completo
- [ ] API RESTful para integraciones
- [ ] Aplicación móvil

## 👥 Equipo de Desarrollo

- **Líder de Proyecto**: María Jiménez
- **Desarrollador Backend**: Brayan Barón
- **Desarrollador Frontend**: José Egurrola
- **Cliente**: Deloitte Colombia

## 📝 Licencia

Este proyecto es propiedad de Deloitte Colombia y está protegido por derechos de autor.

## 📞 Soporte

Para soporte técnico o preguntas:
- Email: soporte@mindmeet.com
- Documentación: https://docs.mindmeet.com

## 🔄 Control de Versiones

- **Versión Actual**: 1.0.0
- **Última Actualización**: 2025
- **Estado**: En Desarrollo

---

**MindMeet** - Transformando reuniones con Inteligencia Artificial 🚀