# 🧭 LlanquihueTourApp

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, desarrollado como proyecto
progresivo de la asignatura **Desarrollo Orientado a Objetos I** (Duoc UC).

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online

---

## 📄 Descripción del sistema

LlanquihueTourApp permite administrar las entidades de la agencia (guías turísticos y
servicios turísticos) a través de una interfaz gráfica Swing. El sistema aplica encapsulamiento,
herencia, polimorfismo, interfaces y colecciones genéricas para modelar y mostrar la información
de forma flexible, sin necesidad de conocer de antemano el tipo concreto de cada entidad.

## 🧩 Clases e interfaces principales

| Paquete | Elemento | Rol |
|---------|----------|-----|
| `model` | `Registrable` | Interfaz común (`mostrarResumen()`) implementada por toda entidad gestionable. |
| `model` | `ServicioTuristico` | Superclase de los servicios turísticos. |
| `model` | `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural` | Subclases de `ServicioTuristico`. |
| `model` | `GuiaTuristico`, `Direccion`, `Tour` | Entidades de dominio de semanas anteriores. |
| `data` | `GestorEntidades` | Colección `ArrayList<Registrable>`, agrega y muestra entidades diferenciando su tipo con `instanceof`. |
| `data` | `GestorServicios`, `GestorGuias` | Creación y carga de datos de ejemplo. |
| `service` | `ServicioTuristicoService` | Recorre y muestra por consola una colección de servicios turísticos. |
| `util` | `UtilDireccion`, `UtilGuiaTuristico`, `UtilServicioTuristico`, `UtilTour` | Validaciones de campos. |
| `exception` | `TourException`, `DireccionException`, `GuiaTuristicoException` | Excepciones personalizadas. |
| `ui` | `Main`, `FrameIngresarGuia`, `FrameIngresarServicio` | Interfaz gráfica Swing. |

## 🧱 Estructura del proyecto

```plaintext
📁 src/
├── ui/          # Interfaz gráfica: Main, FrameIngresarGuia, FrameIngresarServicio.
├── model/       # Entidades y jerarquías: Registrable, ServicioTuristico y subclases,
│                # GuiaTuristico, Direccion, ExcursionCultural, PaseoLacustre, RutaGastronomica, Tour.
├── data/        # Gestores: GestorEntidades, GestorServicios, GestorGuias.
├── service/     # ServicioTuristicoService.
├── exception/   # Excepciones personalizadas.
└── util/        # UtilDireccion, UtilGuiaturistico, UtilServicioTuristico, UtilTour
```

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Klaha0/LlanquihueTour.git
```

2. Abre el proyecto en tu IDE (NetBeans o IntelliJ IDEA).
3. Ejecuta la clase principal **`Main.java`**, ubicada en el paquete `ui`.
4. Desde la ventana principal puedes:
   * Ingresar un nuevo **Guía** o **Servicio** (Ruta Gastronómica, Paseo Lacustre o Excursión
     Cultural).
   * Mostrar los **Guías**, los **Servicios** o **Todo** el listado registrado.

---

## 🆕 Semana 8 — Interfaces, polimorfismo y GUI (actual)

**Objetivo:** ampliar el sistema con un contrato de comportamiento común (`Registrable`),
diferenciación de tipos en tiempo de ejecución mediante `instanceof` y una interfaz gráfica
básica para el ingreso y visualización de registros.

**Qué se agregó sobre el proyecto de semanas anteriores:**

* **Interfaz `Registrable`** (paquete `model`), con el método `mostrarResumen()`. La implementan
  `ServicioTuristico` (y sus subclases, por herencia), `GuiaTuristico` y `Direccion`.
* **`GestorEntidades`** (paquete `data`): mantiene una única colección `ArrayList<Registrable>`
  con guías y servicios, y usa `instanceof` para separarlos al mostrarlos (`mostrarGuias()`,
  `mostrarServicios()`, `mostrarTodo()`).
* **Interfaz gráfica Swing** (paquete `ui`): `Main` es la ventana principal; `FrameIngresarGuia`
  y `FrameIngresarServicio` permiten ingresar cada tipo de entidad mediante formularios con
  validación y confirmación por `JOptionPane`.
* **Paquetes renombrados a minúsculas** (`model`, `data`, `ui`, `util`, `exception`, `service`) y
  **métodos renombrados a camelCase** en todo el proyecto, siguiendo la convención estándar de
  Java.

**Cómo probarlo:** ejecuta `Main`, ingresa un guía y un servicio desde los botones en la sección "Ingresar
nuevo", y luego usa los botones "Mostrar" para ver el listado polimórfico resultante.

---


**Repositorio GitHub:** https://github.com/Klaha0/LlanquihueTour

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad sumativa individual
