# 🧭 LlanquihueTourApp

Aplicación de escritorio para la gestión de la agencia de turismo **Llanquihue Tour**. El
sistema modela y administra las entidades clave del negocio —clientes, guías turísticos y
servicios turísticos— a través de una interfaz gráfica Swing, aplicando los principios
fundamentales de la Programación Orientada a Objetos.

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos I** (Duoc UC).

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online.

---

## 📄 Descripción del sistema

LlanquihueTourApp permite **registrar, consultar, buscar, actualizar y eliminar** las entidades
de la agencia desde una interfaz gráfica. Todas las entidades se almacenan de forma polimórfica
en una única colección y se persisten en un archivo de texto (`DatosLlanquihueTours.txt`), que se
carga automáticamente al iniciar el programa y se mantiene sincronizado con cada operación.

Características principales:

* **Categorización de personas:** distingue formalmente entre **clientes** y **guías
  turísticos** mediante una jerarquía de herencia con base en `Persona`.
* **Reservas:** una entidad `Reserva` asocia un **cliente** con un **servicio turístico**
  mediante un código de reserva propio, e indica la **cantidad de integrantes** (1 a 40) que
  descuenta cupos de la capacidad del servicio. Se admiten hasta 40 reservas y se almacenan en
  un `ArrayList<Reserva>`.
* **Capacidad de servicios:** cada `ServicioTuristico` tiene una **capacidad** (1 a 40 personas)
  que limita el total de integrantes reservados; el sistema calcula y muestra los cupos
  disponibles al reservar.
* **Integridad de datos:** cada campo se valida con clases utilitarias y **excepciones
  personalizadas** (RUT con dígito verificador, edad, numeración, capacidad, código de reserva,
  cantidad de integrantes, etc.).
* **Reutilización de estructuras:** una misma colección `ArrayList<Persistible>` y un mismo
  gestor de archivos sirven para todas las entidades; las reservas se persisten en el mismo
  archivo y se reconstruyen en una segunda pasada de lectura (resolviendo cliente y servicio).
* **Gestión completa (CRUD):** cualquier registro puede buscarse por nombre (coincidencia
  parcial), RUT o código de reserva, y luego actualizarse o eliminarse.

## 🧠 Principios de POO aplicados

| Principio | Dónde se aplica |
|-----------|-----------------|
| **Encapsulamiento** | Atributos `private` con getters/setters y validación en todas las clases del paquete `model`. |
| **Composición** | `Persona` contiene una `Direccion` y un `Rut`; los gestores contienen la colección de entidades. |
| **Herencia** | `Cliente` y `GuiaTuristico` extienden `Persona`; `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` extienden `ServicioTuristico`. |
| **Polimorfismo** | Colección `ArrayList<Persistible>` recorrida con `instanceof` y métodos `toString()`/`persistir()` sobreescritos con `@Override`; `Reserva` también implementa `Persistible`. |
| **Interfaces** | `Persistible` define el contrato `persistir()` implementado por toda entidad almacenable. |
| **Sobrecarga** | `UtilRut.validarRut(String)` y `UtilRut.validarRut(Rut)`. |
| **Excepciones propias** | `PersonaException`, `RutInvalidoException`, `DireccionException`, `ServicioTuristicoException`, `ReservaException`. |

## 🧩 Clases e interfaces principales

| Paquete | Elemento | Rol |
|---------|----------|-----|
| `model` | `Persistible` | Interfaz común (`persistir()`) que implementa toda entidad almacenable. |
| `model` | `Persona` | Clase base con nombre, edad, `Direccion` y `Rut`. |
| `model` | `Cliente`, `GuiaTuristico` | Subclases de `Persona` (agregan código de reserva y especialidad). |
| `model` | `ServicioTuristico` | Superclase de los servicios turísticos (nombre, duración y capacidad). |
| `model` | `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural` | Subclases de `ServicioTuristico`. |
| `model` | `Reserva` | Entidad que asocia un `Cliente` y un `ServicioTuristico` con un código de reserva y una cantidad de integrantes. |
| `model` | `Direccion`, `Rut` | Objetos de valor compuestos dentro de `Persona`. |
| `data` | `GestorEntidades` | Mantiene la colección `ArrayList<Persistible>` y el `ArrayList<Reserva>`; agrega, muestra, busca, actualiza y elimina, y calcula cupos disponibles. |
| `data` | `GestorDatos` | Lee y escribe las entidades y reservas en `DatosLlanquihueTours.txt` (carga en dos pasadas, agrega y reescribe el archivo). |
| `service` | `GeneradorCodigos` | Genera códigos de reserva aleatorios de 8 caracteres. |
| `util` | `UtilPersona`, `UtilCliente`, `UtilGuiaTuristico`, `UtilServicioTuristico`, `UtilDireccion`, `UtilRut`, `UtilReserva` | Validaciones de los campos de cada entidad. |
| `exception` | `PersonaException`, `RutInvalidoException`, `DireccionException`, `ServicioTuristicoException`, `ReservaException` | Excepciones personalizadas de validación. |
| `ui` | `Main` | Ventana principal con el menú de acciones. |
| `ui` | `FrameIngresarPersona`, `FrameIngresarServicio` | Formularios para registrar personas y servicios. |
| `ui` | `FrameGestionar` | Ventana para buscar, actualizar y eliminar cualquier entidad. |
| `ui` | `FrameGestionarReservas` | Ventana para crear reservas y buscarlas, actualizarlas o eliminarlas. |

## 🧱 Estructura del proyecto

```plaintext
📁 src/
├── ui/          # Interfaz gráfica: Main, FrameIngresarPersona, FrameIngresarServicio,
│                # FrameGestionar, FrameGestionarReservas.
├── model/       # Entidades y jerarquías: Persistible, Persona, Cliente, GuiaTuristico,
│                # ServicioTuristico y subclases, Reserva, Direccion, Rut.
├── data/        # Gestores de datos: GestorEntidades, GestorDatos.
├── service/     # GeneradorCodigos.
├── util/        # Validadores: UtilPersona, UtilCliente, UtilGuiaTuristico,
│                # UtilServicioTuristico, UtilDireccion, UtilRut, UtilReserva.
└── exception/   # Excepciones personalizadas.
```

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Klaha0/LlanquihueTour.git
```

2. Abre el proyecto en tu IDE (NetBeans o IntelliJ IDEA).
3. Ejecuta la clase principal **`Main.java`**, ubicada en el paquete `ui`.
4. Desde la ventana principal puedes:
   * **Crear nuevo:** registrar una **Persona** (Cliente o Guía) o un **Servicio** (Ruta
     Gastronómica, Paseo Lacustre o Excursión Cultural, indicando su **capacidad**).
   * **Mostrar:** listar los **Guías**, **Clientes**, **Servicios** o **Todo** el registro.
   * **Gestionar:** buscar una entidad por nombre (coincidencia parcial), RUT o código de
     reserva, **actualizar** sus datos o **eliminarla** del sistema.
   * **Reservas:** crear una reserva asociando un cliente con un servicio (mostrando los cupos
     disponibles), y buscar, actualizar o eliminar reservas existentes.
   * **Sistema:** limpiar el área de información.

## 💾 Formato del archivo de datos

Cada línea de `DatosLlanquihueTours.txt` representa una entidad, con sus campos separados por `;`
y precedidos por el tipo. Ejemplos:

```text
GuiaTuristico;Ana Torres Rivas;38;Los Aromos;120;Puerto Varas;Los Lagos;12345678-5;Trekking
Cliente;Pedro Soto Lagos;29;Las Camelias;450;Frutillar;Los Lagos;11111111-1;aB3xY7kM
RutaGastronomica;Sabores del sur;6.5;20;3
PaseoLacustre;Vuelta al lago;2.0;15;Lancha
ExcursionCultural;Museo colonial;3.0;25;Frutillar
Reserva;aB3xY7kM;11111111-1;Sabores del sur;4
```

En los servicios turísticos el cuarto campo corresponde a la **capacidad** (1 a 40 personas) y
el quinto al dato propio del subtipo. Cada `Reserva` guarda su código, el **RUT del cliente**, el
**nombre del servicio** y la **cantidad de integrantes**; al leer el archivo, las reservas se
reconstruyen en una segunda pasada, resolviendo el cliente y el servicio ya cargados.

El archivo se crea automáticamente si no existe, y se reescribe por completo al actualizar o
eliminar una entidad o reserva para mantener la integridad de los datos.

---

**Repositorio GitHub:** https://github.com/Klaha0/LlanquihueTour

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Evaluación Final Transversal (EFT)
