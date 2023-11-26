
package RegistroUsuarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// Creamos una clase usuario que va a contener los atributos de todos los usuarios
class Usuario {
      // Atributos del usuario
        String nombre; 
        String apellido; 
        String dni;
        String fechaNacimiento; 
    
     // Constructor del objeto usuario
        public Usuario (String nombre, String apellido, String dni, String fechaNacimiento){
        this.nombre = nombre; 
        this.apellido = apellido; 
        this.dni = dni; 
        this.fechaNacimiento = fechaNacimiento; 
    }    
}

public class Main {
    // se crea un ArrayList "usuarios" para guardar la data de la clase Usuario
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();

     //  entrada de datos desde la consola con la clase Scanner
    private static final  Scanner sc = new Scanner(System.in);
     
    public static void main(String[] args) {
        
         // harcodeo algunos usuarios para que la lista no empiece vacia 
        usuarios.add(new Usuario("Juan", "Pérez", "42299878", "05/10/1999"));
        usuarios.add(new Usuario("Marcela", "Britos", "44555521", "27/11/1999")); 
         
        // con while puedo ejecutar el programa hasta que el usuario decida salir y ahi se corta la ejecusión
         while (true) {
         System.out.println("\n1. Agregar Usuario");
         System.out.println("2. Ver lista de usuarios");
         System.out.println("3. Salir");
         System.out.print("Seleccione una opción: ");
         
           int opcion = sc.nextInt();
            sc.nextLine();
            
            // con swich y case manejo las opciones del controlador
                switch (opcion) {
                 case 1 :
                    agregarUsuario();
                 break;
                 case 2 : 
                    listaDeUsuarios();
                 break;
                 case 3 : 
                     System.out.println("Saliendo del programa.");
                     System.exit(0);
                 default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
             }
         }
    }

     
     // creamos el método agregarUsuario() y se solicitan los datos de una nuevo usuario que se quiera registrar.
     private static void agregarUsuario() {
        String nombre;
    do {
        System.out.print("Ingrese el nombre: ");
        nombre = sc.nextLine();
        if (nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar en blanco. Inténtelo de nuevo.");
        }
    } while (nombre.isEmpty());

         String apellido;
    do {
        System.out.print("Ingrese el apellido: ");
         apellido = sc.nextLine();
        if (apellido.isEmpty()) {
            System.out.println("Error: El apellido no puede estar en blanco. Inténtelo de nuevo.");
        }
    } while (apellido.isEmpty());
        
         String dni;
    do {
        System.out.print("Ingrese el DNI (8 dígitos): ");
        dni = sc.nextLine();
        if (!validarDni(dni)) {
            System.out.println("Error: DNI no válido. Debe tener 8 dígitos. Inténtelo de nuevo.");
        }
    } while (!validarDni(dni));

    String fechaNacimiento;
    do {
        System.out.print("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
        fechaNacimiento = sc.nextLine();
        if (!validarFechaNacimiento(fechaNacimiento)) {
            System.out.println("Error: Formato de fecha no válido. Use dd/mm/yyyy. Inténtelo de nuevo.");
        }
    } while (!validarFechaNacimiento(fechaNacimiento));
        
        // aplicamos la validacion de datos para verificacar si agrega o no el nuevo usuario a la lista
        // Creamos la instancia usuario
        if (validarDatos(nombre, apellido, dni, fechaNacimiento)){
            Usuario usuario = new Usuario(nombre, apellido, dni, fechaNacimiento);
            // si los cumple, lo agregamos 
            usuarios.add(usuario);
            System.out.println("Usuario agregado correctamente!");
        } else {
            // si no los cumple tira error
            System.out.println("Error en los datos ingresados. Intente nuevamente");
        }
}
     
     // se crea el método listaDeUsuarios() para poder mostrar los usuarios agregados
     private static void listaDeUsuarios () {
         if(usuarios.isEmpty()){
             System.out.println("No hay usuarios registrados.");
         } else {
             System.out.println("\nListado de usuarios: ");
             for (Usuario usuario : usuarios){
                 System.out.println("Nombre: " + usuario.nombre);
                 System.out.println("Apellido: " + usuario.apellido);
                 System.out.println("D.N.I: " + usuario.dni);
                 System.out.println("Fecha de Nacimiento: " + usuario.fechaNacimiento);
                 System.out.println("________________________________________________");
             }
         }
     }
    
     // Validación de los datos ingresados 
     
     // use un regex para validar el dni
     private static boolean validarDni(String dni) {
          return dni.matches("\\d{8}");
     }
     
     // validación de la fecha
     private static boolean validarFechaNacimiento(String fechaNacimiento) {
         //le damos el formato de fecha (día/mes/año) con SimpleDateFormat
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          dateFormat.setLenient(false);
           
        //Comprobación de la fecha
        try {
            // si la fecha ingresada coincide con el formato dd/MM/yyyy pasa como true y se muestra en pantalla
            Date date = dateFormat.parse(fechaNacimiento);
            return true;
        } catch (ParseException e) {
            //Si la fecha no es correcta, cae en el catch 
            return false;
        }
     }
          private static boolean validarDatos(String nombre, String apellido, String dni, String fechaNacimiento) {
           return !nombre.isEmpty() && !apellido.isEmpty() && validarDni(dni) && validarFechaNacimiento(fechaNacimiento);
       }
       
    
    
}

    



