# 🧠 Actividad formativa individual "Creando jerarquías de clases con herencia simple"
#                          Semana 6 - Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto

* **Nombre completo:** Carlos Palma Garrido.
* **Carrera:** Programación de aplicaciones.
* **Sede:** Online

---

## 🎯 Objetivo de la semana 6

Esta semana, la actividad **"Creando jerarquías de clases con herencia simple"** tiene como objetivo
implementar una **clase base con atributos comunes** y un conjunto de **subclases que extiendan su
funcionalidad**, aplicando los conceptos de **herencia simple**, **atributos heredados**,
**sobrescritura de métodos (`toString()`)**, uso de **`super(...)`** en los constructores y
**composición** entre las clases que ejecutan el programa.

En el contexto del caso de la agencia **Llanquihue Tour**, se modelan jerárquicamente los distintos
tipos de servicios turísticos que ofrece la empresa (rutas gastronómicas, paseos lacustres y
excursiones culturales), reutilizando la información básica común (nombre y duración) y especializando
los atributos propios de cada categoría. De esta forma el sistema queda preparado para incorporar
fácilmente nuevos tipos de servicio en el futuro.

---

## 🆕 ¿Qué se hizo esta semana? (sobre el proyecto de la semana 5)

El trabajo se realizó **sobre el mismo proyecto `LlanquihueTourApp`** desarrollado en las semanas
anteriores, manteniendo la organización modular ya existente. Concretamente:

* Se **agregó la jerarquía de clases** de la semana 6 en el paquete `Model/`:
  `ServicioTuristico` (superclase) y sus subclases `RutaGastronomica`, `PaseoLacustre` y
  `ExcursionCultural`.
* Se **agregó la clase `GestorServicios`** en el paquete `Data/`, encargada de crear las instancias
  de prueba de cada subclase.
* Se **agregó la clase `Main`** en el paquete `UI/`, que ejecuta el programa de la semana 6.
* **El código de la semana 5 NO se eliminó:** dentro de `Main` se dejó **comentado** todo el código
  correspondiente a la actividad de la semana 5 (carga, agregado, filtrado y guardado de tours), y a
  continuación se **agregó el nuevo código** que cumple con las instrucciones de la semana 6 (creación
  y muestra por consola de los servicios turísticos mediante herencia).
* Las clases de las semanas anteriores (`Tour`, `GuiaTuristico`, `Direccion`, gestores, utilidades y
  excepciones) **se conservan** en el proyecto como parte del historial de avance del sistema.

> 📝 De esta manera se mantiene la trazabilidad del trabajo realizado en todas las semanas, dejando a
> la vista cómo evolucionó el proyecto sin perder lo construido anteriormente.

---

## 🧱 Estructura del proyecto

El código está organizado en paquetes funcionales según su responsabilidad:

```plaintext
📁 src/
├── UI/          # Clase Main, contiene el método main que ejecuta el programa (capa de presentación).
├── Model/       # Jerarquía de clases: ServicioTuristico, RutaGastronomica, PaseoLacustre,
│                #   ExcursionCultural (semana 6) + Tour, GuiaTuristico, Direccion (semanas previas).
├── Data/        # Clase GestorServicios (crea instancias de prueba) + GestorDatos (semanas previas).
├── Exception/   # Excepciones personalizadas de semanas previas.
└── Util/        # Clases de validación y operaciones de semanas previas.

📁 resources/
└── tours.txt    # Archivo de persistencia utilizado por el código de la semana 5.
```

---

## 🧬 Jerarquía de clases creada (semana 6)

```plaintext
                 ServicioTuristico            (superclase)
                 - nombre : String
                 - duracionHoras : double
                        ▲
        ┌───────────────┼─────────────────┐
        │               │                 │
 RutaGastronomica  PaseoLacustre   ExcursionCultural
 + numeroDeParadas + tipoEmbarcacion + lugarHistorico
```

| Clase | Tipo | Atributos | Descripción |
|-------|------|-----------|-------------|
| `ServicioTuristico` | Superclase | `nombre`, `duracionHoras` | Clase base con la información común a todo servicio turístico. |
| `RutaGastronomica` | Subclase | `+ numeroDeParadas` | Ruta con paradas gastronómicas. Hereda de `ServicioTuristico`. |
| `PaseoLacustre` | Subclase | `+ tipoEmbarcacion` | Paseo en el lago según el tipo de embarcación. Hereda de `ServicioTuristico`. |
| `ExcursionCultural` | Subclase | `+ lugarHistorico` | Excursión a un lugar histórico. Hereda de `ServicioTuristico`. |

Todas las subclases:

* **Heredan** de `ServicioTuristico` mediante `extends`.
* **Invocan a `super(nombre, duracionHoras)`** en su constructor para inicializar los atributos heredados.
* **Sobrescriben `toString()`** con `@Override` para mostrar su información completa (atributos
  heredados + atributo propio).

Además, la clase `GestorServicios` (paquete `Data/`) aplica **composición**: `Main` crea un objeto
`GestorServicios` y lo utiliza para generar las instancias de prueba de cada subclase.

---

## 🔍 Funcionalidad principal (semana 6)

* **`GestorServicios`** expone métodos que crean **dos instancias de cada subclase**
  (`PaseoLacustre`, `RutaGastronomica`, `ExcursionCultural`).
* **`Main`** instancia `GestorServicios`, solicita los objetos y los **muestra por consola** invocando
  el método `toString()` de cada uno, evidenciando la herencia y la sobrescritura.

**Salida esperada por consola:**

```plaintext
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
4. Observa en la consola las **dos instancias de cada subclase** (`PaseoLacustre`, `RutaGastronomica`
   y `ExcursionCultural`) mostradas mediante su método `toString()`.

> ℹ️ El código de la semana 5 está **comentado** dentro de `Main`. Si deseas volver a ejecutarlo, basta
> con descomentar ese bloque (y los `import` y atributos estáticos asociados) y comentar el bloque de
> la semana 6.

---

## 📚 Historial del proyecto

* **Semana 4-5:** Sistema de gestión de tours con encapsulamiento, composición (`Tour` →
  `GuiaTuristico` → `Direccion`), excepciones personalizadas, persistencia en archivo y filtrado por
  tipo y por guía.
* **Semana 6 (actual):** Jerarquía de servicios turísticos con herencia simple, `super(...)`,
  sobrescritura de `toString()` y composición a través de `GestorServicios`.

---

**Repositorio GitHub:** https://github.com/Klaha0/LlanquihueTour

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Actividad formativa individual
