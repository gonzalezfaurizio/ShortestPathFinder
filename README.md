---

# Shortest Path Finder

## Descripción

Shortest Path Finder es una aplicación desarrollada como parte del proyecto programado de la asignatura IF3001 Algoritmos y Estructuras de Datos en la Universidad de Costa Rica. El objetivo de la aplicación es simular un robot que debe recorrer un laberinto desde una posición inicial hasta encontrar una zona segura en el menor número de pasos posibles. El robot tiene un máximo de 5 intentos para completar el laberinto.

## Características

- Menú principal con opciones para iniciar un juego nuevo, ver instrucciones del juego, acceder al salón de la fama y salir de la aplicación.
- Previsualización y actualización de laberintos.
- Registro y validación de usuarios.
- Ejecución de diferentes algoritmos de recorrido de laberintos, incluyendo búsqueda en profundidad, búsqueda en anchura, exploración de muros, y más.
- Visualización del movimiento del robot y registro en el salón de la fama.
- Menú del juego que permite seleccionar y cargar laberintos, registrar jugadores y seleccionar algoritmos de recorrido.
- Simulación visual del recorrido del robot a través del laberinto seleccionado.

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
