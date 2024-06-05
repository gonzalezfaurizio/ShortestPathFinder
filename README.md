---

# Shortest Path Finder

## Descripción

Shortest Path Finder es una aplicación desarrollada como parte del proyecto programado de la asignatura IF3001 Algoritmos y Estructuras de Datos en la Universidad de Costa Rica. El objetivo de la aplicación es simular un robot que debe recorrer un laberinto desde una posición inicial hasta encontrar una zona segura en el menor número de pasos posibles. El robot tiene un máximo de 5 intentos para completar el laberinto.

## Características

- **Menú Principal**: 
  - **Juego**: Permite ingresar al menú del juego donde se puede registrar, subir laberintos, iniciar un nuevo juego y seleccionar algoritmos de recorrido.
  - **Salón de la Fama**: Acceso al registro de los mejores jugadores y sus logros.
  - **Instrucciones**: Proporciona una guía sobre cómo jugar y utilizar las diferentes opciones del juego.
  - **Salir**: Permite cerrar la aplicación.

- **Menú del Juego**:
  - **Registro y Validación de Usuarios**: Opción para que los usuarios se registren y se validen para poder jugar.
  - **Subida de Laberintos**: Funcionalidad para subir y previsualizar laberintos personalizados.
  - **Inicio del Juego**: Comienza un nuevo juego seleccionando un laberinto, un jugador y un algoritmo de recorrido.
  - **Simulación de Recorridos**: Selección y ejecución de diferentes algoritmos de recorrido de laberintos, incluyendo:
    - Búsqueda en profundidad
    - Búsqueda en anchura
    - Exploración de muros
    - Otros algoritmos personalizados
  - **Visualización del Movimiento del Robot**: Muestra el recorrido del robot a través del laberinto seleccionado.
  - **Registro en el Salón de la Fama**: Almacena y muestra los mejores tiempos y rutas completadas por los jugadores.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/gonzalezfaurizio/ShortestPathFinder.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd ShortestPathFinder
   ```
3. Importa el proyecto en tu IDE de Java preferido (Eclipse, IntelliJ, etc.).
4. Asegúrate de tener configurado el JDK apropiado para el proyecto.

## Uso

1. Ejecuta la aplicación desde tu IDE o usando la línea de comandos:
   ```bash
   java -jar ShortestPathFinder.jar
   ```
## Algoritmos de Recorrido Implementados

- **A* (AStarAlgorithm.java):** Algoritmo de búsqueda heurística que encuentra el camino más corto con eficiencia.
- **Búsqueda en profundidad (DepthFirstSearch.java):** Explora todas las alternativas posibles, retrocediendo solo cuando es necesario.
- **Búsqueda en anchura (BreadthFirstSearch.java):** Recorre una rama de una intersección a otra, retrocediendo para revisar caminos alternativos.
- **Relleno por inundación (FloodFillAlgorithm.java):** Realiza recorridos optimistas suponiendo inicialmente que no hay muros.
- **Recorrido completo del laberinto (FullMazeTraversal.java):** Explora todas las rutas posibles del laberinto.

## Contribuciones

Las contribuciones son bienvenidas. Para contribuir, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Añadir nueva funcionalidad"
   ```
4. Sube tus cambios:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request.

## Autores

- **C33317 Gonzalez Alfaro Faurizio**
- **C36713 Rodriguez Gutierrez Rebeca**
- **C36773 Rodriguez Rodriguez Andrey Eladio**

## Contacto

Para preguntas o sugerencias, por favor contacta a [faurizio.gonzalez@ucr.ac.cr].

---
