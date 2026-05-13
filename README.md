# Tarea de Interfaces en Java
**Programación Orientada a Objetos — Java / IntelliJ IDEA**

---

## Descripción general

Este proyecto contiene tres sistemas desarrollados en Java que aplican el uso de **interfaces como contratos de comportamiento**. Cada tarea está en su propia carpeta (`tarea1`, `tarea2`, `tarea3`) y puede ejecutarse de forma independiente. A lo largo del proyecto se trabajan conceptos como **polimorfismo**, **encapsulamiento**, **validaciones** y **responsabilidad única**.

El proyecto está organizado así:

```
InterfacesJava/
├── README.md
├── tarea1/
├── tarea2/
└── tarea3/
```

---

## Tarea 1 — Sistema académico de documentos

Una institución educativa necesita imprimir tres tipos de documentos: certificados, actas de notas y horarios académicos. Aunque son documentos distintos, todos comparten una capacidad común: pueden imprimirse. Por eso se define la interfaz **`Imprimible`**, que obliga a cualquier clase que la implemente a definir su propio método `imprimir()`.

Las clases `Certificado`, `ActaNotas` y `HorarioAcademico` implementan esta interfaz, cada una con su propia lógica de presentación. Cada clase tiene **atributos propios** como número de documento, carrera o período académico, todos encapsulados con modificador `private`. Las validaciones en los constructores aseguran que no se creen objetos con datos inválidos, como promedios fuera de rango o nombres vacíos.

En el `MainAcademico` se aplica **polimorfismo**: los tres objetos se almacenan en un arreglo de tipo `Imprimible[]` y se recorren con un ciclo, llamando a `imprimir()` en cada uno sin importar de qué clase concreta se trate.

---

## Tarea 2 — Sistema bancario de pagos

Un banco necesita procesar pagos por tres medios distintos: efectivo, tarjeta y transferencia. Todos deben poder procesar un monto, pero cada uno lo hace de forma diferente y con reglas distintas. La interfaz **`Pagable`** define el contrato: cualquier medio de pago debe implementar `procesarPago(double monto)`.

Una regla compartida es que **el monto siempre debe ser mayor a cero** — si no lo es, el sistema informa el error sin lanzar una excepción, para que el flujo continúe. Como reto adicional, se implementaron **comisiones diferenciadas**: la tarjeta cobra un 3% sobre el monto y la transferencia un 1.5%, mientras que el efectivo no tiene comisión. El total final se calcula y muestra en cada caso.

Al igual que en la tarea anterior, el `MainPagos` usa un arreglo de tipo `Pagable[]` para demostrar polimorfismo y probar tanto pagos válidos como inválidos.

---

## Tarea 3 — Sistema de roles empresariales

Una empresa tiene tres tipos de empleados: cajeros, administradores y supervisores. Cada uno tiene permisos distintos dentro del sistema, y eso es exactamente lo que se modela con **múltiples interfaces**.

Se definen tres interfaces: **`Autenticable`** para iniciar sesión, **`Reportable`** para generar reportes y **`Gestionable`** para operar datos. La clave del diseño es que **no todos los roles implementan todas las interfaces**:

- El **Cajero** implementa `Autenticable` y `Gestionable`: puede entrar al sistema y registrar operaciones de caja, pero no tiene acceso a reportes.
- El **Administrador** implementa las tres interfaces: tiene acceso completo al sistema.
- El **Supervisor** implementa `Autenticable` y `Reportable`: puede revisar reportes de su zona, pero no toca los datos directamente.

Esto demuestra que las interfaces permiten **asignar capacidades específicas a cada clase sin forzar una jerarquía de herencia**. No se usó clase abstracta porque los tres roles no comparten atributos ni lógica común — cada uno tiene sus propios datos (sucursal, departamento, zona) y sus propias reglas.

El `Main` incluye un **menú interactivo** donde se selecciona el rol, se ingresan las credenciales y se ejecutan solo las acciones disponibles para ese rol.

**Credenciales para probar:**
- Cajero → usuario: `Gaby123` / clave: `caje123`
- Administrador → usuario: `jordy1` / clave: `admin1234`
- Supervisor → usuario: `Beto12` / clave: `super123`

---

## Cómo ejecutar

Abrir IntelliJ IDEA y crear un proyecto separado por cada tarea, o agregar los archivos de una carpeta como fuentes del proyecto. Luego ejecutar la clase `Main` correspondiente con `Shift + F10`. Cada carpeta es completamente independiente.

---

## Conceptos clave aplicados

A lo largo del proyecto se trabajaron los siguientes conceptos de forma práctica:

**Interfaz como contrato:** la interfaz no implementa lógica, solo define qué métodos deben existir. Quien implemente la interfaz está obligado a darle su propio cuerpo a esos métodos.

**`implements` y `@Override`:** la palabra `implements` conecta la clase con la interfaz, y `@Override` confirma que el método está siendo correctamente sobrescrito, ayudando a detectar errores de nombre o firma.

**Polimorfismo:** al declarar variables con el tipo de la interfaz (`Imprimible doc`, `Pagable pago`, `Autenticable auth`), el código puede trabajar con cualquier clase que implemente esa interfaz sin conocer su tipo concreto.

**Encapsulamiento:** todos los atributos de las clases son `private`, accesibles únicamente a través de constructores y getters, protegiendo el estado interno del objeto.

**Responsabilidad única:** cada interfaz tiene un propósito claro y definido. La interfaz declara, la clase implementa, y el Main prueba — sin mezclar responsabilidades.

---

## Autor

**Jordy Cajas**  
Estudiante de Desarrollo de Software  
Entrega: Tarea S6 — Interfaces en Java
