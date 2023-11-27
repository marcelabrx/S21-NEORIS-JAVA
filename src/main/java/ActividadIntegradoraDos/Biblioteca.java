
package ActividadIntegradoraDos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Biblioteca {
    private final List<Libro> listaLibros;
    private final List<Usuario> listaUsuarios;

    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    // Métodos para la gestión de libros
    public void agregarLibro(String titulo, String autor, String genero, int anioPublicacion, boolean esUsado, boolean disponible) {
        Libro libro = new Libro(titulo, autor, genero, anioPublicacion, esUsado, disponible);
        listaLibros.add(libro);
    }

  public void eliminarLibro(Libro libro) {
    Iterator<Libro> iterator = listaLibros.iterator();
    while (iterator.hasNext()) {
        if (iterator.next().getTitulo().equals(libro.getTitulo())) {
            iterator.remove();
            System.out.println("Libro '" + libro.getTitulo() + "' eliminado.");
            return;
        }
    }
    System.out.println("Libro '" + libro.getTitulo() + "' no encontrado.");
}

    // Métodos para la gestión de usuarios
    public void agregarUsuario(String nombre, String apellido, int edad, String dni, String correo) {
    Usuario nuevoUsuario = new Usuario(nombre, apellido, edad, dni, correo);
    listaUsuarios.add(nuevoUsuario);
    System.out.println("Usuario agregado exitosamente.");

    // Imprimir información del nuevo usuario
    System.out.println("Nombre: " + nuevoUsuario.getNombre() +
            ", Apellido: " + nuevoUsuario.getApellido() +
            ", Edad: " + nuevoUsuario.getEdad() +
            ", DNI: " + nuevoUsuario.getDni() +
            ", Correo: " + nuevoUsuario.getCorreo());
}

public void alquilarLibro(String dniUsuario, String nombreLibro) {
    // Busca el usuario por DNI
    Usuario usuario = buscarUsuarioPorDni(dniUsuario);

    // Busca el libro por nombre
    Libro libro = buscarLibroPorNombre(nombreLibro);

    // Verifica si el usuario y el libro existen
    if (usuario != null && libro != null) {
        // Verifica si el libro está disponible
        if (libro.isDisponible()) {
            // Agrega el libro a la lista de libros alquilados del usuario
            usuario.getLibrosAlquilados().add(libro);

            // Cambia el estado del libro a no disponible
            libro.setDisponible(false);

            System.out.println("Libro '" + libro.getTitulo() + "' alquilado por " + usuario.getNombre() + ".");
        } else {
            System.out.println("Libro '" + libro.getTitulo() + "' no está disponible para alquilar.");
        }
    } else {
        System.out.println("Usuario o libro no encontrado.");
    }
}

public void devolverLibro(String dniUsuario, String nombreLibro) {
    // Busca el usuario por DNI
    Usuario usuario = buscarUsuarioPorDni(dniUsuario);

    // Busca el libro por nombre
    Libro libro = buscarLibroPorNombre(nombreLibro);

    // Verifica si el usuario y el libro existen
    if (usuario != null && libro != null) {
        // Verificar si el usuario tiene el libro alquilado
        if (usuario.getLibrosAlquilados().contains(libro)) {
            // Quita el libro de la lista de libros alquilados del usuario
            usuario.getLibrosAlquilados().remove(libro);

            // Cambia el estado del libro a disponible
            libro.setDisponible(true);

            System.out.println("Libro '" + libro.getTitulo() + "' devuelto por " + usuario.getNombre() + ".");
        } else {
            System.out.println("El usuario " + usuario.getNombre() + " no tiene el libro '" + libro.getTitulo() + "' alquilado.");
        }
    } else {
        System.out.println("Usuario o libro no encontrado.");
    }
}
// Método para notificar devoluciones fuera de plazo
    public void notificarDevolucionFueraPlazo(String dniUsuario, String nombreLibro) {
        // Busca el usuario por DNI
        Usuario usuario = buscarUsuarioPorDni(dniUsuario);

        // Busca el libro por nombre
        Libro libro = buscarLibroPorNombre(nombreLibro);

        // Verifica si el usuario y el libro existen
        if (usuario != null && libro != null) {
            // Verifica si el usuario tiene el libro alquilado
            if (usuario.getLibrosAlquilados().contains(libro)) {
                // Notifica al usuario sobre la devolución fuera de plazo
                usuario.notificarDevolucionFueraPlazo( libro);
            } else {
                System.out.println("El usuario " + usuario.getNombre() + " no tiene que devolver el libro: " + libro.getTitulo() );
            }
        } else {
            System.out.println("Usuario o libro no encontrado.");
        }
    }
// Métodos de búsqueda auxiliares
private Usuario buscarUsuarioPorDni(String dni) {
    for (Usuario usuario : listaUsuarios) {
        if (usuario.getDni().equals(dni)) {
            return usuario;
        }
    }
    return null; // Usuario no encontrado
}

private Libro buscarLibroPorNombre(String nombre) {
    for (Libro libro : listaLibros) {
        if (libro.getTitulo().equals(nombre)) {
            return libro;
        }
    }
    return null; // Libro no encontrado
}

 // Métodos para consultas y búsquedas
public List<Libro> buscarLibros(String criterio, String valor) {
    List<Libro> resultados = new ArrayList<>();

    for (Libro libro : listaLibros) {
        switch (criterio.toLowerCase()) {
            case "titulo" -> {
                if (libro.getTitulo().toLowerCase().contains(valor.toLowerCase())) {
                    resultados.add(libro);
                }
            }
            case "autor" -> {
                if (libro.getAutor().toLowerCase().contains(valor.toLowerCase())) {
                    resultados.add(libro);
                }
            }
            case "genero" -> {
                if (libro.getGenero().toLowerCase().contains(valor.toLowerCase())) {
                    resultados.add(libro);
                }
            }
            default -> {
                System.out.println("Criterio de búsqueda no válido.");
                return resultados;
            }
        }
    }

    return resultados;
}

public void mostrarResultadosBusqueda(List<Libro> resultados) {
    if (resultados.isEmpty()) {
        System.out.println("No se encontraron libros que coincidan con el criterio de búsqueda.");
    } else {
        System.out.println("Libros que coinciden con el criterio de búsqueda:");
        for (Libro libro : resultados) {
            System.out.println("Título: " + libro.getTitulo() +
                    ", Autor: " + libro.getAutor() +
                    ", Género: " + libro.getGenero() +
                    ", Año de Publicación: " + libro.getAnioPublicacion());
        }
    }
}

}

