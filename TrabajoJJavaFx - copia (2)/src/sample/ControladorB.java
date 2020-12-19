package sample;

import cr.ac.ucenfotec.rojas.federico.entidades.*;
import cr.ac.ucenfotec.rojas.federico.gestor.Gestor;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ControladorB {


    private Gestor gestor = new Gestor();
    public ArrayList<Genero> listaGenero = new ArrayList<>();
    private ArrayList<Cancion> subaCancionAlbum = new ArrayList<>();
    private ArrayList<Compositor> listaCompositor = new ArrayList<>();

    public int iniciarSesion(String correo, String contrasenna) {
        int resultado = 0;

        List<UsuarioFinal> unUsuarioFinal = null;
        try {
            unUsuarioFinal = gestor.findAllUsuarioFinal();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (UsuarioFinal unoUsuarioFinal : unUsuarioFinal) {
            if (unoUsuarioFinal.getCorreo().equals(correo) && unoUsuarioFinal.getContrasenna().equals(contrasenna)) {//condicional para probar si el usuario(correo) y clave son correctos
                resultado = 0;
                break;
            } else {
                resultado++;
            }
        }
        return resultado;
    }

    public String[] listarAlbumes2() throws SQLException { //tiene que ser public para poder llamarlo de ControlAlbum.java
        int i = 0;
        List<Album> unAlbum = gestor.findAllAlbum();
        String[] listarAlbum = new String[unAlbum.size()];

        for (Album unoAlbum : unAlbum) {
            //interfaz.imprimirMensaje(unoAlbum.toString());
            listarAlbum[i] = unoAlbum.getNombreAlbum();
            i++;
        }
        return listarAlbum;
    }

    public String[] listarCancionesParaAlbumes() {
        int i = 0;
        List<Cancion> unaCancion = null;
        try {
            unaCancion = gestor.findAllCancion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String[] listaCancionParaAlbum = new String[unaCancion.size()];

        for (Cancion unCancion : unaCancion) {
            listaCancionParaAlbum[i] = unCancion.getNombreCancion();
            i++;
        }
        return listaCancionParaAlbum;
    }

    public void agregarCancionesAlbum(String [] lista, String nombre){

        for (int i = 0; i < lista.length; i++) {
            gestor.guardarCancionAlbum(lista[i],nombre);
        }
    }

    public void agregarCancionesLista(String [] lista, String nombre){
        for (int i = 0; i < lista.length; i++) {
            gestor.guardarCancionLista(lista[i],nombre);
        }
    }

    public String[] listarCancionesSubidas() {
        int i = 0;
        List<Cancion> unaCancion = null;
        try {
            unaCancion = gestor.findAllCancion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String[] enlistarCanciones = new String[unaCancion.size()];
        for (Cancion unCancion : unaCancion) {
            enlistarCanciones[i] = unCancion.getNombreCancion();
            i++;
        }
        return enlistarCanciones;
    }

    public String[] listarListaReproduccion() {
        int i = 0;
        List<ListaReproduccion> unaListaReproduccion = null;
        try {
            unaListaReproduccion = gestor.findAllListaReproduccion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String[] enlistarListaReprod = new String[unaListaReproduccion.size()];
        for (ListaReproduccion unListaReproduccion: unaListaReproduccion){
            enlistarListaReprod[i] = unListaReproduccion.getNombreLista();
            i++;
        }
        return enlistarListaReprod;
    }

    /*public void listarPersonas() {
        try {
            List<UsuarioFinal> unUsuarioFinal = gestor.findAllUsuarioFinal();
            for (UsuarioFinal unoUsuarioFinal : unUsuarioFinal) {
                interfaz.imprimirMensaje(unoUsuarioFinal.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarCompositor() {
        try {
            List<Cantautor> unCompositor = gestor.findAllCompositor();
            for (Cantautor unoCompositor : unCompositor) {
                interfaz.imprimirMensaje(unoCompositor.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void listarArtista() {
        try {
            List<Artista> unArtista = gestor.findAllArtista();
            for (Artista unoArtista : unArtista) {
                interfaz.imprimirMensaje(unoArtista.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }*/

    public String[] listarGeneros() {
        int i = 0;
        List<Genero> unGenero = null;
        try {
            unGenero = gestor.findAllGenero();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] enlistarGeneros = new String[unGenero.size()];
        for (Genero unoGenero : unGenero) {
            enlistarGeneros[i] = unoGenero.getNombreGenero();
            i++;
        }
        return enlistarGeneros;
    }

    public String[] listarArtistas() throws SQLException {
        int i = 0;
        List<Artista> unArtista = gestor.findAllArtista();
        String[] enlistarArtistas = new String[unArtista.size()];
        for (Cantautor unaArtista: unArtista) {
            enlistarArtistas[i] = unaArtista.getNombre();
            i++;
        }
        return enlistarArtistas;
    }

    public String[] listarCompositores() throws SQLException {
        int i = 0;
        List<Cantautor> unCompositor = gestor.findAllCompositor();
        String[] enlistarCompositores = new String[unCompositor.size()];
        for (Cantautor unoCompositor: unCompositor) {
            enlistarCompositores[i] = unoCompositor.getNombre();
            i++;
        }
        return enlistarCompositores;
    }

    public void crearAdministrador(String nombreAdm, String apellido1, String apellido2, String avatar, String correo, String contrasenna) throws EmailException, SQLException {
        int existeAdm = gestor.getAllPersona();
        System.out.println("Cantidad de admin registrados en la BD: " + existeAdm);
        if (existeAdm == 0) {

            DefaultAuthenticator(nombreAdm, apellido1, correo);
            /*interfaz.imprimirMensaje("Registre su contraseña(al menos 8 dígitos numéricos): ");
            String contrasenna = interfaz.leerTexto();*/
            String tipoPersona = "admin";

            gestor.guardarAdministrador(nombreAdm, apellido1, apellido2, avatar, correo, contrasenna, tipoPersona);
        } else {
            System.out.println("Ya existe un administrador, NO puede registrarse como tal. Regístrese como UsuarioFinal. Gracias!!!");
        }
    }

    public void DefaultAuthenticator(String nombre, String apellido1, String correo) throws EmailException {
        int claveTemp = (int) Math.floor(Math.random() * (20000000 - 10000000 + 1) + 10000000);
        System.out.println(claveTemp);

        Email email = new SimpleEmail();
        email.setSmtpPort(587);

        email.setAuthenticator(new DefaultAuthenticator("repuestos.frm@gmail.com", "benditoDios137"));

        email.setDebug(false);
        email.setHostName("smtp.gmail.com");
        email.setFrom("repuestos.frm@gmail.com");

        email.setSubject(nombre + " complete su registro en su aplicación de música");
        email.setMsg("Estimado " + nombre + " " + apellido1 +
                "\n\nBienvenido a su aplicación de música.  Para terminar su proceso de registro, tenga la amabilidad de ingresar con la siguiente clave temporal." +
                " Una vez ingresado por favor cambie su contraseña.  Esta contraseña es válida solo para un primer ingreso: " + claveTemp + "." +
                "\n\nLe saluda el equipo de su música.  Disfrútela!!!");
        email.addTo(correo);
        email.setTLS(true);
        email.send();
        System.out.println("Mail sent!");
    }

    public void crearUsuarioFinal(String nombreUsuarioFinal, String apellido1, String apellido2, String avatar, String correo, String contrasenna, LocalDate fechaNacimiento,
                                  String paisProcedencia, String identificacion) throws EmailException {

        DefaultAuthenticator(nombreUsuarioFinal, apellido1, correo);

        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        String tipoPersona = "usuarioFinal";

        gestor.guardarUsuario(nombreUsuarioFinal, apellido1, apellido2, avatar, correo, contrasenna, tipoPersona, edad, paisProcedencia, identificacion);
    }

    public void registrarGeneroMusical(String nombreGeneroCancion, String descripcionGeneroCancion) {

        gestor.agregarNuevoGenero1(nombreGeneroCancion, descripcionGeneroCancion);
    }

    public void registrarArtista(String nombreCantante, String apellidoCantante, String paisNacimiento, String nombreArtistico, String fechaNacimientoCantante,
                                 String fechaDefuncionCantante, String descripcionCantante) {


        /*interfaz.imprimirMensaje("Desea registrar el genero musical del artista: 1=si o 2=no");
        int opcion = 0;
        do {
            opcion = interfaz.leerNumero();
            if (opcion == 1){
                procesarOpcionSeleccionada();
                break;
            }else{
                System.out.println("Puede registrar un género con la opción 12 más tarde");
            }
        } while (opcion != 2);*/
        int edadCantante = Period.between(LocalDate.parse(fechaNacimientoCantante), LocalDate.now()).getYears();

        gestor.guardarArtista(nombreCantante, apellidoCantante, paisNacimiento, edadCantante, nombreArtistico, fechaNacimientoCantante, fechaDefuncionCantante, descripcionCantante);
    }

/*    private void procesarOpcionSeleccionada() {
        registrarGeneroMusical();
    }*/

    public void registrarListaReproduccion(String nombreLista, LocalDate fechaCreacionLista, int calificacionLista) {
        gestor.guardarListaReproduccion(nombreLista, String.valueOf(fechaCreacionLista), calificacionLista);
    }

    public void registrarCompositor(String nombreCompositor, String apellidoCompositor, String paisNacimiento, int edadCompositor) {
        gestor.guardarCompositor(nombreCompositor, apellidoCompositor, paisNacimiento, edadCompositor);

    }

    public void registrarAlbum(String nombreAlbum, LocalDate fechaLanzamiento, String imagenAlbum) {
        gestor.guardarAlbum(nombreAlbum, String.valueOf(fechaLanzamiento), imagenAlbum);
    }

    public void agregarCanciones(String nombreCancion, LocalDate fechalanzamiento, String subaCancion) {
        gestor.guardarAgregarCancionesCompositor(nombreCancion, String.valueOf(fechalanzamiento), subaCancion);
    }

    /*public void listaCancionesAlbum(String[] nombreCanciones, String nombreAlbum) {
    }*/
}
