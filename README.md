# 🧠 Actividad sumativa individual "Organización modular y creación de una librería personalizada" 
#                          Semana 5 - Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la actividad sumativa individual de la semana 5 - asignatura *Desarrollo Orientado a Objetos I*, llamada **"Organización modular y creación de una librería personalizada"**.

Es un sistema desarrollado en Java que gestiona los tours de la agencia de turismo **Llanquihue Tour**, ubicada en la Región de Los Lagos. La aplicación permite registrar, listar, filtrar y persistir tours junto con la información de su **guía turístico** y la **dirección** de éste, aplicando los principios de encapsulamiento, composición entre clases, manejo de excepciones personalizadas y persistencia de datos en archivos.

El sistema resuelve la problemática de la agencia, que necesita una herramienta para registrar y consultar datos de forma eficiente, evitar errores y duplicaciones, validar la información ingresada y automatizar tareas básicas como la búsqueda o el filtrado de registros. Para ello, lee los datos desde un archivo externo, los carga en estructuras dinámicas y aplica operaciones automatizadas de recorrido, búsqueda y visualización por consola.

---

## 🧱 Estructura general del proyecto

El código está organizado en paquetes funcionales según su rol:

```plaintext
📁 src/
├── UI/          # Clase LlanquihueTourApp, contiene el método main (capa de presentación).
├── Model/       # Clases de dominio: Tour, GuiaTuristico y Direccion.
├── Data/        # Clase GestorDatos para cargar, guardar y mostrar tours.
├── Exception/   # Excepciones personalizadas: TourException, GuiaTuristicoException y DireccionException.
└── Util/        # Clases de validación y operaciones: UtilTour, UtilGuiaTuristico y UtilDireccion.

📁 resources/
└── tours.txt    # Archivo de texto donde se persisten los tours registrados.
```

## 🔗 Relaciones entre clases (composición)

El proyecto aplica **composición** para reflejar las relaciones del dominio:

* Un `Tour` tiene un `GuiaTuristico` (cada tour tiene asignado un guía).
* Un `GuiaTuristico` contiene una `Direccion` (cada guía tiene una dirección).

---

## 🔍 Funcionalidades principales

* **Cargar tours desde archivo:** Al iniciar, se leen los tours guardados en `resources/tours.txt` y se cargan en un `ArrayList<Tour>`.
* **Agregar tours:** Se crean tours nuevos validando sus datos y los de su guía y dirección, evitando duplicados.
* **Mostrar tours:** Se despliega en consola la lista completa de tours registrados.
* **Filtrar por tipo:** Permite obtener solo los tours de un tipo determinado (ej. "Trekking").
* **Guardar en archivo:** Al finalizar, todos los tours se escriben de vuelta en el archivo.

---

## 📄 Formato del archivo de entrada (`resources/tours.txt`)

Cada línea del archivo representa **un tour** y contiene **11 campos separados por punto y coma (`;`)**, con un `;` final. El orden de los campos es el siguiente:

```plaintext
id;tipo;lugar;capacidad;distancia;nombreGuia;edadGuia;calle;numeracion;comuna;ciudad;
```

| Posición | Campo | Tipo | Descripción |
|----------|-------|------|-------------|
| 0 | `id` | entero | Identificador del tour (se reasigna al cargar). |
| 1 | `tipo` | texto | Tipo de tour (ej. Trekking, Gastronómico). |
| 2 | `lugar` | texto | Lugar donde se realiza el tour. |
| 3 | `capacidad` | entero | Cantidad máxima de personas. |
| 4 | `distancia` | decimal | Distancia del recorrido en kilómetros. |
| 5 | `nombreGuia` | texto | Nombre del guía turístico. |
| 6 | `edadGuia` | entero | Edad del guía turístico. |
| 7 | `calle` | texto | Calle de la dirección del guía. |
| 8 | `numeracion` | entero | Numeración de la dirección. |
| 9 | `comuna` | texto | Comuna de la dirección. |
| 10 | `ciudad` | texto | Ciudad de la dirección. |

**Ejemplo de línea válida:**

```plaintext
0;Trekking;Panguipulli;12;60.5;Daniel Opazo;32;Las golondrinas;10589;Coñaripe;Villarrica;
```

Si una línea no tiene exactamente 11 campos, o algún dato numérico está mal escrito, el programa **omite solo ese registro**, informa por consola y continúa cargando el resto del archivo.

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Klaha0/LlanquihueTour.git
```

2. Abre el proyecto en tu IDE (NetBeans o IntelliJ IDEA).
3. Ejecuta la clase principal `LlanquihueTourApp.java`, ubicada en el paquete `UI`.
4. Observa en la consola la carga de datos, la lista de tours, el filtrado por tipo y el guardado en el archivo.

---

**Repositorio GitHub:** https://github.com/Klaha0/LlanquihueTour

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad sumativa individual
