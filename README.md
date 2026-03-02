# Ejercicio guiado de clase: Biblioteca (arrays fijos + composición + métodos)

## Objetivo
Construir un sistema mínimo de biblioteca usando **composición** y un **array unidimensional de tamaño fijo**, aplicando:
- Clases, atributos, constructores, getters y `toString()`
- Métodos con responsabilidad clara
- Búsquedas y gestión de huecos (`null`)
- Javadoc en clases y métodos públicos
- Flujo de trabajo con **commits pequeños y descriptivos**

## Escenario
Una biblioteca pequeña necesita gestionar un catálogo limitado de libros (máximo 10).  
No se usarán listas dinámicas: todo se gestiona con un **array fijo**.

---

## Reglas del ejercicio (importantes)
- No se permite `ArrayList`.
- El array debe inicializarse en el constructor.
- Un hueco libre en el array se representa con `null`.
- `Main` se usa solo para pruebas (crear objetos y llamar a métodos).
- Los métodos deben estar documentados con Javadoc.

---

## Estructura esperada del proyecto
- `Libro.java`
- `Biblioteca.java`
- `Main.java`

---

## Paso a paso (guía de clase con micro-entregas + commits)

### 0) Preparación del proyecto
1. Crea un proyecto Java en IntelliJ.
2. Crea el paquete (opcional) `app` para `Main` y `modelo` para las clases.

**Commit 0**
- Mensaje recomendado:
    - `chore: inicializar proyecto de biblioteca`

---

# 1) Crear la clase `Libro`
## Requisitos de `Libro`
Atributos:
- `id` (int)
- `titulo` (String)
- `autor` (String)
- `numeroPaginas` (int)

Incluye:
- Constructor completo
- Getters
- `toString()`
- Javadoc en la clase y en el constructor

**Commit 1**
- Mensaje recomendado:
    - `feat: crear clase Libro con atributos y javadoc`

---

# 2) Crear la clase `Biblioteca` (comenzando por los dos métodos clave)
> **Orden obligatorio en clase**: al llegar a `Biblioteca`, empezamos por implementar:
- `public Libro buscarLibro(int id)`
- `private int buscarPrimeraPosicionLibre()`

## 2.1 Estructura base de `Biblioteca`
Atributos:
- `private Libro[] libros;`

Constructor:
- Inicializa el array con tamaño 10.

**Commit 2**
- Mensaje recomendado:
    - `feat: crear clase Biblioteca con array fijo e inicialización`

---

## 2.2 Implementar `private int buscarPrimeraPosicionLibre()`
### Comportamiento esperado
- Recorre el array `libros`.
- Devuelve el índice de la **primera posición que sea `null`**.
- Si no hay hueco libre, devuelve `-1`.

> Punto de fricción típico: olvidarse del `-1` y devolver un índice inválido.

**Commit 3**
- Mensaje recomendado:
    - `feat: añadir búsqueda de primera posición libre en Biblioteca`

---

## 2.3 Implementar `public Libro buscarLibro(int id)`
### Comportamiento esperado
- Recorre el array `libros`.
- Si encuentra un `Libro` no nulo cuyo `id` coincida, lo devuelve.
- Si no existe, devuelve `null`.

> Puntos de fricción típicos:
- No comprobar `null` antes de acceder a `getId()`
- Devolver un `Libro` “vacío” en vez de `null`

**Commit 4**
- Mensaje recomendado:
    - `feat: implementar búsqueda de libro por id`

---

# 3) Implementar `public boolean registrarLibro(Libro libro)`
## Comportamiento esperado
- Usa `buscarPrimeraPosicionLibre()`.
- Si devuelve `-1`, no se puede insertar → devuelve `false`.
- Si devuelve un índice válido, inserta el libro en esa posición → devuelve `true`.

> Punto de fricción típico: sobrescribir un libro existente por no usar bien el índice.

**Commit 5**
- Mensaje recomendado:
    - `feat: registrar libros usando hueco libre del array`

---

# 4) Implementar `public void mostrarLibros()`
## Comportamiento esperado
- Recorre el array y muestra por consola solo libros no nulos.
- Recomendación: usar `System.out.println(libro)` para aprovechar `toString()`.

> Punto de fricción típico: imprimir también `null` o no filtrar.

**Commit 6**
- Mensaje recomendado:
    - `feat: mostrar listado de libros registrados`

---

# 5) Implementar `public int contarLibros()`
## Comportamiento esperado
- Recorre el array y cuenta cuántas posiciones no nulas hay.

> Punto de fricción típico: confundir “tamaño del array” con “cantidad de libros”.

**Commit 7**
- Mensaje recomendado:
    - `feat: añadir conteo de libros en Biblioteca`

---

# 6) Probar desde `Main`
## Requisitos de prueba
- Crear una `Biblioteca`.
- Crear al menos 3 libros.
- Registrarlos.
- Mostrar libros.
- Mostrar el total.
- Probar `buscarLibro(id)` con:
    - un id que exista
    - un id que no exista

**Commit 8**
- Mensaje recomendado:
    - `test: añadir pruebas manuales en Main`

---

## Checklist final (para dejarlo listo)
- [ ] `Libro` tiene Javadoc, constructor, getters y `toString()`
- [ ] `Biblioteca` inicializa `libros` en constructor
- [ ] `buscarPrimeraPosicionLibre()` devuelve índice o `-1`
- [ ] `buscarLibro(id)` devuelve `Libro` o `null`
- [ ] `registrarLibro()` usa el método de hueco libre
- [ ] `mostrarLibros()` no imprime `null`
- [ ] `contarLibros()` cuenta correctamente
- [ ] `Main` prueba los casos básicos

---

## Ejecución y salida esperada (orientativa)
Ejecutar:
- Desde IntelliJ ejecuta `Main`.

Salida esperada (aproximada):
- Se muestran los libros registrados
- Aparece el total
- Se muestra el resultado de `buscarLibro(id)`:
    - un libro si existe
    - `null` si no existe