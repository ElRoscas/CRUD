# Proyecto Final

# Sistema de Gestión de Reservas de Salas

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar las reservas de salas por parte de empleados. Está desarrollado en Java usando Maven como gestor de dependencias, MySQL como base de datos con Xampp. También incluye pruebas automatizadas con JUnit 5.

## Descripción general

La aplicación permite:

- Gestionar salas (crear, modificar, eliminar, consultar).
- Gestionar empleados.
- Reservar salas para una fecha y un horario específico.
- Validar que las horas de inicio y fin sean correctas.
- Realizar pruebas automatizadas para asegurar el correcto funcionamiento del sistema.

Estructura de entidades:
- Salas: nombre, capacidad, recursos.
- Empleados: nombre, email, departamento.
- Reservas: vincula una sala con un empleado en una fecha y horario determinado.

---

## Cómo ejecutar el proyecto

### Requisitos previos

- Tener instalado Java (JDK 11) o superior.
- Tener NetBeans o Eclipse (el que querais) con soporte para Maven.
- Tener MySQL en funcionamiento.

### Instrucciones para ejecutar

1. Abre el proyecto con NetBeans (`Archivo > Abrir Proyecto`) en caso de Netbeans ya saldra directamente, pero en caso de Eclipse hay que (`File > Open Projects From file System > Directory...`) Y entonces seleccionamos la carpeta completa.
2. Asegúrate de tener configurada la conexión a la base de datos correctamente en tu clase.
3. Ejecuta la aplicación haciendo clic derecho en la clase principal (`CRUDexecutar`) y selecciona “Run File”.

---

##  Cómo ejecutar las pruebas (JUnit)

1. Abre NetBeans y busca la clase de pruebas que quieras ejecutar (por ejemplo, `SalaDaoTest.java`).
2. Haz clic derecho sobre la clase de test y selecciona “Test File”.
3. NetBeans ejecutará los tests automáticamente y mostrará los resultados en la ventana inferior.

---
