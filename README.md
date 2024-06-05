---

# Shortest Path Finder

## Descripción

Shortest Path Finder es una aplicación desarrollada como parte del proyecto programado de la asignatura IF3001 Algoritmos y Estructuras de Datos en la Universidad de Costa Rica. El objetivo de la aplicación es simular un robot que debe recorrer un laberinto desde una posición inicial hasta encontrar una zona segura en el menor número de pasos posibles. El robot tiene un máximo de 5 intentos para completar el laberinto.

## Características

- Menú principal con opciones para ingresar laberintos, iniciar un juego nuevo, simular recorridos, ver instrucciones del juego, acceder al salón de la fama y salir de la aplicación.
- Previsualización y actualización de laberintos.
- Registro y validación de usuarios.
- Ejecución de diferentes algoritmos de recorrido de laberintos, incluyendo búsqueda en profundidad, búsqueda en anchura, exploración de muros, y más.
- Visualización del movimiento del robot y registro en el salón de la fama.

## Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/gonzalezfaurizio/ShortestPathFinder.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd ShortestPathFinder
   ```
3. Instala las dependencias necesarias:
   ```bash
   pip install -r requirements.txt
   ```

## Uso

1. Ejecuta la aplicación:
   ```bash
   python main.py
   ```
2. Usa el menú principal para:
   - Ingresar y actualizar laberintos.
   - Iniciar un nuevo juego ingresando un nombre de usuario válido y seleccionando un laberinto.
   - Ver la simulación del recorrido usando diferentes algoritmos.
   - Leer las instrucciones del juego.
   - Consultar el salón de la fama.

## Algoritmos de Recorrido Implementados

- **Búsqueda en profundidad:** Explora todas las alternativas posibles, retrocediendo solo cuando es necesario.
- **Búsqueda en anchura:** Recorre una rama de una intersección a otra, retrocediendo para revisar caminos alternativos.
- **Exploración de muros (mano derecha o izquierda):** Utiliza los muros como referencia para recorrer el laberinto.
- **Algoritmo de relleno:** Realiza recorridos optimistas suponiendo inicialmente que no hay muros.

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
