# 🧠 Evaluación Individual Semana 4 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online

\---

## 📘 Descripción general del sistema

Este proyecto corresponde a la actividad sumativa semana 4 de la asignatura *Desarrollo Orientado a Objetos I*. Sistema desarrollado en Java que gestiona tours de la agencia de turismo Llanquihue Tour. La aplicación permite registrar, listar, filtrar y persistir tours en un archivo de texto, aplicando los principios de encapsulamiento, manejo de excepciones personalizadas y persistencia de datos.

El proyecto fue desarrollado a partir del caso de la agencia de turismo Llanquihue Tour, cuyo requerimiento es un sistema que permita gestionar los tours disponibles, validar la información ingresada, evitar duplicados y mantener los registros entre ejecuciones mediante un archivo de texto. Se propone una solución estructurada, modular y reutilizable.

\---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/
├── UI/              # Contiene clase LlanquihueTourApp, contiene el método main.
├── Model/           # Contiene clase Tour con sus atributos.
├── Data/            # Clase GestorDatos para cargar, guardar y mostrar tours.
├── ExceptionTour/   # Excepción personalizada TourException.
└── Util/            # Clase UtilTour con validaciones y operaciones sobre la lista.

📁 resources/
└── tours.txt        # Archivo de texto donde se guardan los tours registrados.
```

\---

## 🔍 Funcionalidades principales

* **Cargar tours desde archivo:** Al iniciar, se leen los tours guardados en `resources/tours.txt`.
* **Agregar tours:** Se crean tours nuevos validando sus datos y evitando duplicados.
* **Mostrar tours:** Se despliega en consola la lista completa de tours registrados.
* **Filtrar por tipo:** Permite obtener solo los tours de un tipo determinado (ej. "Trekking").
* **Guardar en archivo:** Al finalizar, todos los tours se escriben de vuelta en el archivo.

\---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Klaha0/LlanquihueTour.git
```

2. Abre el proyecto en Netbeans.
3. Ejecuta el archivo `LlanquihueTourApp.java` desde el paquete `UI`.



\---

**Repositorio GitHub:** https://github.com/Klaha0/SistemaLlanquihueTour

**Fecha de entrega:** \[14/06/2026]

\---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad formativa 

