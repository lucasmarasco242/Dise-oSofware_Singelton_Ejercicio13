public class CatalogoLibros {
    private static CatalogoLibros instancia;
    private String[] codigos;
    private String[] titulos;
    private String[] autores;
    private int[] cantidades;
    private int total;

    private CatalogoLibros() {
        this.codigos = new String[5];
        this.titulos = new String[5];
        this.autores = new String[5];
        this.cantidades = new int[5];
        this.total = 0;
    }

    public static CatalogoLibros getInstancia() {
        if (instancia == null) {
            instancia = new CatalogoLibros();
        }
        return instancia;
    }

    public void agregarLibro(String codigo, String titulo, String autor, int cantidad) {
        if (codigo == null || codigo.isEmpty() || titulo == null || titulo.isEmpty() || autor == null || autor.isEmpty()) {
            System.out.println("Error: Datos incompletos o vacíos.");
            return;
        }
        if (cantidad < 0) {
            System.out.println("Error: La cantidad de ejemplares no puede ser negativa.");
            return;
        }
        // Validar código único
        for (int i = 0; i < total; i++) {
            if (codigos[i].equals(codigo)) {
                System.out.println("Error: Ya existe un libro con el código " + codigo);
                return;
            }
        }
        if (total < 5) {
            codigos[total] = codigo;
            titulos[total] = titulo;
            autores[total] = autor;
            cantidades[total] = cantidad;
            total++;
            System.out.println("Libro agregado: " + titulo);
        } else {
            System.out.println("Catálogo lleno.");
        }
    }

    public void buscar(String texto) {
        System.out.println("--- Resultados de búsqueda para: '" + texto + "' ---");
        boolean encontrado = false;
        for (int i = 0; i < total; i++) {
            if (titulos[i].contains(texto) || autores[i].contains(texto)) {
                System.out.println("Código: " + codigos[i] + " | Título: " + titulos[i] + " | Autor: " + autores[i] + " | Ejemplares: " + cantidades[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    public void actualizarCantidad(String codigo, int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            System.out.println("Error: La cantidad no puede ser negativa.");
            return;
        }
        for (int i = 0; i < total; i++) {
            if (codigos[i].equals(codigo)) {
                cantidades[i] = nuevaCantidad;
                System.out.println("Cantidad actualizada para '" + titulos[i] + "': " + nuevaCantidad);
                return;
            }
        }
        System.out.println("Error: Libro con código " + codigo + " no encontrado.");
    }

    public void mostrarCatalogo() {
        System.out.println("--- Catálogo Actualizado de la Biblioteca ---");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". [" + codigos[i] + "] " + titulos[i] + " - " + autores[i] + " (Ejemplares: " + cantidades[i] + ")");
        }
    }
}