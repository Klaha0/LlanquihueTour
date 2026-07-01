# 🧠 Actividad formativa individual "Aplicando polimorfismo y colecciones genéricas"
#                          Semana 7 - Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online

---

## 🎯 Objetivo de la semana 7

Esta semana, la actividad **"Aplicando polimorfismo y colecciones genéricas"** tiene como objetivo
**extender la jerarquía de clases** construida en la semana 6 para gestionar los servicios turísticos
de forma **dinámica y polimórfica**. Para ello se incorpora una **colección genérica**
(`List<ServicioTuristico>` / `ArrayList<ServicioTuristico>`) que almacena distintos tipos de servicio
en una misma estructura, y se recorre invocando el método **sobrescrito `mostrarInformacion()`** desde
referencias de la **superclase**, evidenciando el **polimorfismo** y la **sobrescritura de métodos**.

En el contexto del caso de la agencia **Llanquihue Tour**, esto permite **escalar el sistema de forma
flexible**: se pueden incorporar nuevas subclases de servicio sin modificar la lógica de recorrido y
despliegue, ya que cada objeto sabe cómo mostrar su propia información.

---

## 🆕 ¿Qué se hizo esta semana? (sobre el proyecto de la semana 6)

El trabajo se realizó **sobre el mismo proyecto `LlanquihueTourApp`** de las semanas anteriores,
manteniendo la organización modular ya existente. Concretamente:

* Se **renombró la sobrescritura `toString()` a `mostrarInformacion()`** en la superclase
  `ServicioTuristico` y en todas sus subclases (`RutaGastronomica`, `PaseoLacustre`,
  `ExcursionCultural`), conservando la anotación `@Override` en las subclases.
* Se **agregó el método `crearServiciosTuristicos()`** en la clase `GestorServicios` (paquete `Data/`),
  que reutiliza los métodos de creación de la semana 6 para devolver un
  **`ArrayList<ServicioTuristico>` con 6 instancias** (dos de cada subclase).
* Se **agregó el paquete `Service/`** con la clase **`ServicioTuristicoService`**, encargada de
  **recorrer la colección** con un bucle `for-each` y **mostrar cada servicio por consola** invocando
  su método sobrescrito `mostrarInformacion()`.
* Se **actualizó la clase `Main`** (paquete `UI/`) para: solicitar la lista al `GestorServicios`,
  entregarla al `ServicioTuristicoService` y mostrar el resultado por consola.
* **El código de las semanas 5 y 6 NO se eliminó:** dentro de `Main` quedó **comentado** (agrupado en
  regiones `<editor-fold>`), manteniendo la trazabilidad de la evolución del proyecto.
* Las clases de las semanas anteriores (`Tour`, `GuiaTuristico`, `Direccion`, gestores, utilidades y
  excepciones) **se conservan** en el proyecto.

> 📝 De esta manera se mantiene la trazabilidad del trabajo realizado en todas las semanas, dejando a
> la vista cómo evolucionó el proyecto sin perder lo construido anteriormente.

---

## 🧱 Estructura del proyecto

El código está organizado en paquetes funcionales según su responsabilidad:

```plaintext
📁 src/
├── UI/          # Clase Main, contiene el método main que ejecuta el programa (capa de presentación).
├── Model/       # Jerarquía de clases: ServicioTuristico, RutaGastronomica, PaseoLacustre,
│                #   ExcursionCultural (semanas 6-7) + Tour, GuiaTuristico, Direccion (semanas previas).
├── Data/        # Clase GestorServicios (crea instancias y la colección) + GestorDatos (semanas previas).
├── Service/     # Clase ServicioTuristicoService: recorre la colección y muestra los servicios (semana 7).
├── Exception/   # Excepciones personalizadas de semanas previas.
└── Util/        # Clases de validación y operaciones de semanas previas.

📁 resources/
└── tours.txt    # Archivo de persistencia utilizado por el código de la semana 5.
```

---

## 🧬 Jerarquía de clases y polimorfismo (semana 7)

```plaintext
                 ServicioTuristico            (superclase)
                 - nombre : String
                 - duracionHoras : double
                 + mostrarInformacion()       (método sobrescribible)
                        ▲
        ┌───────────────┼─────────────────┐
        │               │                 │
 RutaGastronomica  PaseoLacustre   ExcursionCultural
 + numeroDeParadas + tipoEmbarcacion + lugarHistorico
 + mostrarInformacion() @Override (en cada subclase)
```

| Clase | Tipo | Atributos | Descripción |
|-------|------|-----------|-------------|
| `ServicioTuristico` | Superclase | `nombre`, `duracionHoras` | Clase base con la información común y el método `mostrarInformacion()` con implementación base. |
| `RutaGastronomica` | Subclase | `+ numeroDeParadas` | Ruta con paradas gastronómicas. Hereda de `ServicioTuristico`. |
| `PaseoLacustre` | Subclase | `+ tipoEmbarcacion` | Paseo en el lago según el tipo de embarcación. Hereda de `ServicioTuristico`. |
| `ExcursionCultural` | Subclase | `+ lugarHistorico` | Excursión a un lugar histórico. Hereda de `ServicioTuristico`. |

Todas las subclases:

* **Heredan** de `ServicioTuristico` mediante `extends`.
* **Invocan a `super(nombre, duracionHoras)`** en su constructor para inicializar los atributos heredados.
* **Sobrescriben `mostrarInformacion()`** con `@Override` para mostrar su información completa
  (atributos heredados + atributo propio).

**Polimorfismo aplicado:** los 6 objetos se almacenan en una única colección
`ArrayList<ServicioTuristico>` y se recorren con un bucle `for-each`. Al invocar
`mostrarInformacion()`, cada objeto ejecuta **su propia versión sobrescrita** según su tipo real,
sin necesidad de conocer de antemano de qué subclase se trata.

Además, las clases `GestorServicios` (paquete `Data/`) y `ServicioTuristicoService` (paquete
`Service/`) aplican **composición**: `Main` las instancia y las utiliza para generar y mostrar la
colección de servicios.

---

## 🔍 Funcionalidad principal (semana 7)

* **`GestorServicios.crearServiciosTuristicos()`** construye y devuelve un
  `ArrayList<ServicioTuristico>` con **dos instancias de cada subclase**.
* **`ServicioTuristicoService.mostrarServicioTuristico(...)`** recorre la colección con `for-each` y
  muestra cada servicio por consola mediante su método sobrescrito `mostrarInformacion()`.
* **`Main`** orquesta el flujo: pide la colección al gestor y la entrega al servicio para su despliegue.

**Salida esperada por consola:**

```plaintext
--==** SERVICIOS TURÍSTICOS DISPONIBLES **==--
Paseo Lacustre: Conoce el lago calafquén, Duración: 2.5 horas, Tipo de Embarcación: lancha
Paseo Lacustre: Crucero romántico al atardecer, Duración: 3.0 horas, Tipo de Embarcación: Yate de lujo
Ruta Gastronómica: Ruta del curánto, Duración: 4.0 horas, Número de Paradas: 4
Ruta Gastronómica: Ruta de Vinos, Duración: 3.5 horas, Número de Paradas: 3
Excursion Cultural: Tour histórico ciudad nocturna, Duración: 2.5 horas, Lugar Histórico: Centro de Valdivia
Excursion Cultural: El arte desde otra perspectiva, Duración: 2.0 horas, Lugar Histórico: Museo Nacional de bellas artes
```

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:

```bash
git clone https://github.com/Klaha0/LlanquihueTour.git
```

2. Abre el proyecto en tu IDE (NetBeans o IntelliJ IDEA).
3. Ejecuta la clase principal **`Main.java`**, ubicada en el paquete `UI`.
4. Observa en la consola las **6 instancias** almacenadas en la colección, mostradas de forma
   **polimórfica** mediante su método `mostrarInformacion()`.

### 💻 Compilación y ejecución por consola (alternativa)

Desde la raíz del proyecto:

```bash
# Compilar TODO el código fuente del proyecto en la carpeta build/classes
javac -encoding UTF-8 -d build/classes \
  src/Model/*.java src/Data/*.java src/Service/*.java \
  src/Exception/*.java src/Util/*.java src/UI/*.java

# Ejecutar la clase principal
java -cp build/classes UI.Main
```

> ℹ️ El código de las semanas 5 y 6 está **comentado** dentro de `Main` (agrupado en regiones
> `<editor-fold>`). Si deseas volver a ejecutarlo, basta con descomentar el bloque correspondiente.

---

## 📚 Historial del proyecto

* **Semana 4-5:** Sistema de gestión de tours con encapsulamiento, composición (`Tour` →
  `GuiaTuristico` → `Direccion`), excepciones personalizadas, persistencia en archivo y filtrado por
  tipo y por guía.
* **Semana 6:** Jerarquía de servicios turísticos con herencia simple, `super(...)`, sobrescritura de
  `toString()` y composición a través de `GestorServicios`.
* **Semana 7 (actual):** Polimorfismo y colecciones genéricas: colección `ArrayList<ServicioTuristico>`,
  método sobrescrito `mostrarInformacion()`, recorrido `for-each` desde referencias de la superclase y
  nuevo paquete `Service/`.

---

**Repositorio GitHub:** https://github.com/Klaha0/LlanquihueTour

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad formativa individual
