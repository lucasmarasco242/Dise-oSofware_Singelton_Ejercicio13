Ejercicio 3 - Catálogo Compartido de Libros

Explicación del programa

En este ejercicio se creó una clase llamada CatalogoLibros que aplica el patrón Singleton para gestionar una colección de libros compartida y centralizada, permitiendo que tanto la pantalla del personal como la de consulta reflejen los cambios en tiempo real sin utilizar librerías externas ni imports.
La clase cuenta con:
- Una variable estática privada llamada instancia.
- Arreglos privados (codigos, titulos, autores, cantidades) y un contador (total) para mantener la colección encapsulada.
- Un constructor privado para evitar la instanciación externa directa.
- Un método estático público llamado getInstancia() que devuelve siempre la misma referencia única.
- Métodos públicos para agregar libros con validaciones, buscar por título o autor, actualizar ejemplares y mostrar el catálogo completo.

Luego, dentro del método main, se simulan las dos pantallas obteniendo referencias al Singleton:
CatalogoLibros pantallaPersonal = CatalogoLibros.getInstancia();
CatalogoLibros pantallaConsulta = CatalogoLibros.getInstancia();

Finalmente, se utilizó System.out.println() para comprobar que ambas referencias apuntan al mismo objeto, demostrar que los libros agregados desde el personal aparecen inmediatamente en la consulta y probar las validaciones de seguridad.

Lógica utilizada

La lógica del programa consiste en:
- Restringir la creación de objetos externos mediante un constructor privado.
- Controlar el acceso global a través de getInstancia() para asegurar que todas las pantallas compartan exactamente la misma instancia y colección de datos.
- Aplicar validaciones estrictas para rechazar códigos duplicados, títulos vacíos y cantidades negativas de ejemplares.

Resultado de la ejecución

La ejecución del programa muestra en la consola lo siguiente:
¿Es la misma instancia?: true
Libro agregado: Clean Code
Libro agregado: Java Programming
Error: Ya existe un libro con el código L001
Error: La cantidad de ejemplares no puede ser negativa.

--- Catálogo Actualizado de la Biblioteca ---
1. [L001] Clean Code - Robert Martin (Ejemplares: 5)
2. [L002] Java Programming - J. Gosling (Ejemplares: 3)

--- Resultados de búsqueda para: 'Java' ---
Código: L002 | Título: Java Programming | Autor: J. Gosling | Ejemplares: 3

Cantidad actualizada para 'Java Programming': 10

--- Catálogo Actualizado de la Biblioteca ---
1. [L001] Clean Code - Robert Martin (Ejemplares: 5)
2. [L002] Java Programming - J. Gosling (Ejemplares: 10)

Captura de pantalla

<img width="828" height="617" alt="image" src="https://github.com/user-attachments/assets/8fa9202d-1a8e-4087-b8e6-917b3a4720f5" />
