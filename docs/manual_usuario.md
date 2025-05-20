# Manual de Usuario – Tobacco Manager

Este manual explica cómo utilizar la aplicación de gestión de tabaco.

## Requisitos Previos

- Tener Java instalado en tu equipo (Java 8 o superior).
- Ejecutar la aplicación desde un IDE como IntelliJ, VS Code o desde consola.

## Menú Principal

Al iniciar la aplicación, se muestra un menú con las siguientes opciones:

1. **Add tobacco**  
   Permite introducir una nueva marca de tabaco. Se solicitan los siguientes campos:
   - Nombre (texto)
   - Ranking (número del 0 al 5)
   - Precio (número decimal positivo)
   - Tamaño (número entero, representa cantidad de cigarrillos)

2. **Modify tobacco**  
   Permite modificar una marca de tabaco existente. El usuario selecciona una marca y puede editar sus datos.

3. **Show tobaccos**  
   Muestra una lista con todos los elementos añadidos al sistema.

4. **Delete tobacco**  
   Permite eliminar una marca seleccionada de la lista.

5. **Exit the program**  
   Cierra la aplicación.

## Validaciones

- El nombre no puede estar vacío.
- El ranking debe ser un número entero entre 0 y 5.
- El precio debe ser un número positivo con decimales (por ejemplo, 3.5).
- El tamaño debe ser un número entero positivo.

Si alguno de los campos es inválido, se muestra un mensaje de error y no se guarda la entrada.

## Control de errores

El programa controla:
- Formato incorrecto en números.
- Campos vacíos.
- Errores al modificar o borrar elementos.

---

© 2025 – Tobacco Manager