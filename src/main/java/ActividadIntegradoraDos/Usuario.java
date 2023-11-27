
package ActividadIntegradoraDos;

import java.util.ArrayList;
import java.util.List;


public class Usuario implements NotificacionDevoluciones {
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String correo;
    private List<Libro> librosAlquilados;

    public Usuario(String nombre, String apellido, int edad, String dni, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.correo = correo;
        this.librosAlquilados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Libro> getLibrosAlquilados() {
        return librosAlquilados;
    }
    
    @Override
    public void notificar(String mensaje) {
        System.out.println("Notificación para el usuario '" + this.getNombre() + "': " + mensaje);

    }
    
  public void notificarDevolucionFueraPlazo(Libro libro) {
    notificar("¡Atención! Devolución fuera de plazo para el libro '" + libro.getTitulo() + "'.");
}

    
}
