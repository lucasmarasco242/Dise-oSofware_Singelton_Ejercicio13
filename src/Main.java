public class Main {
    public static void main(String[] args) {
        // Simulación Pantalla del Personal y Pantalla de Consulta compartiendo la misma instancia
        CatalogoLibros pantallaPersonal = CatalogoLibros.getInstancia();
        CatalogoLibros pantallaConsulta = CatalogoLibros.getInstancia();

        System.out.println("¿Es la misma instancia?: " + (pantallaPersonal == pantallaConsulta));

        // Personal agrega libros al catálogo
        pantallaPersonal.agregarLibro("L001", "Clean Code", "Robert Martin", 5);
        pantallaPersonal.agregarLibro("L002", "Java Programming", "J. Gosling", 3);

        // Pruebas de validación (código duplicado y cantidad negativa)
        pantallaPersonal.agregarLibro("L001", "Libro Duplicado", "Autor X", 2);
        pantallaPersonal.agregarLibro("L003", "Refactoring", "Martin Fowler", -1);

        System.out.println();
        // Consulta muestra el catálogo actualizado automáticamente sin recargar datos
        pantallaConsulta.mostrarCatalogo();

        System.out.println();
        // Búsqueda por título o autor desde la pantalla de consulta
        pantallaConsulta.buscar("Java");

        System.out.println();
        // Actualizar ejemplares desde la pantalla del personal
        pantallaPersonal.actualizarCantidad("L002", 10);

        System.out.println();
        // Verificar que el cambio se refleja instantáneamente en la pantalla de consulta
        pantallaConsulta.mostrarCatalogo();
    }
}