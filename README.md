# Proyecto de Generación Automática de IDs

Este proyecto es un servicio auxiliar desarrollado en Java utilizando Spring Boot con Maven, diseñado para generar automáticamente IDs para entidades, objetos o colecciones de otros proyectos. Es ideal para utilizarse en aplicaciones que requieran la asignación única y automática de identificadores para diversas entidades en diferentes contextos.

## Características

* **Generación Automática de IDs**: El servicio proporciona IDs únicos para diferentes entidades, objetos o colecciones.
* **Conexión a MongoDB**: Por defecto, el proyecto se conecta a una base de datos NoSQL alojada en MongoDB.
* **Flexibilidad en Base de Datos**: Puedes adaptar el proyecto para que funcione con otras bases de datos si lo prefieres.
* **Endpoints RESTful**: El servicio expone endpoints para la generación y administración de IDs.

## Requisitos

* **Java**: Versión 21 (puedes cambiar la versión de Java en el archivo `pom.xml` si es necesario).
* **Maven**: Para la gestión de dependencias y construcción del proyecto.
* **MongoDB**: Una instancia de MongoDB a la cual conectar el servicio.

## Configuración
1. **Clona el repositorio:**
```bash
git clone https://github.com/Macrebot/CounterIds.git
cd CounterIds
```
2. **Configura la conexión a la base de datos:**
* La conexión a MongoDB se configura mediante la constante `MONGODB_URI`. Esta URI no está incluida en el repositorio por razones de seguridad, por lo que debes proveer tu propia base de datos MongoDB y definir esta constante.
* Alternativamente, puedes adaptar el proyecto para que se conecte a otro tipo de base de datos según tus necesidades.
3. **Compila y ejecuta el proyecto**

## Endpoints

El proyecto expone varios endpoints RESTful para la administración de contadores. A continuación se muestra una lista de los endpoints disponibles en `CounterController`:

* **Obtener todos los contadores:**
```http
GET /counters
```
Devuelve una lista de todos los contadores.
* **Obtener un contador por ID:**
```http
GET /counters/{id}
```
`{id}` es el ID del contador que deseas consultar.
* **Obtener el próximo ID disponible para un contador:**
```http
GET /counters/{id}/nextId
```
`{id}` es el ID del contador para el cual se desea obtener el próximo ID.
* **Crear un nuevo contador:**
```http
POST /counters
```
En el cuerpo de la solicitud, proporciona los datos del nuevo contador en formato JSON.
* **Eliminar un contador por ID:**
```http
DELETE /counters/{id}
```
`{id}` es el ID del contador que deseas eliminar.
