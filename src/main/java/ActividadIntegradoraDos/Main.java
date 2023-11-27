
package ActividadIntegradoraDos;

import java.util.List;


public class Main {
    
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Agregar libros
        biblioteca.agregarLibro("Harry Potter", "J.K. Rowling", "Fantasía", 2001, false, true);
        biblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 1967, false, true);
        biblioteca.agregarLibro("1984", "George Orwell", "Distopía", 1949, false, true);

        // Agregar usuarios
        biblioteca.agregarUsuario("Juan", "Perez", 25, "12345678", "juan@gmail.com");
        biblioteca.agregarUsuario("Ana", "Gomez", 30, "87654321", "ana@gmail.com");
        
        // Alquilar libros
        biblioteca.alquilarLibro("12345678", "Harry Potter");
        biblioteca.alquilarLibro("87654321", "1984");
        
        // Devolucion Libros
        biblioteca.devolverLibro("87654321", "Cien años de soledad");
        biblioteca.devolverLibro("12345678", "Harry Potter");
        
        // Buscar libro
       List<Libro> resultadosBusqueda = biblioteca.buscarLibros("titulo", "Harry");
        biblioteca.mostrarResultadosBusqueda(resultadosBusqueda);
        
        // Notificacion fuera de plazo
        biblioteca.notificarDevolucionFueraPlazo("12345678", "Harry Potter");
        biblioteca.notificarDevolucionFueraPlazo("123456756", "Harry Potter");
        biblioteca.notificarDevolucionFueraPlazo("87654321", "1984");

    }
}
