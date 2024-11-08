package co.edu.uniquindio.reservasuq.Controlador;
import co.edu.uniquindio.reservasuq.Modelo.*;
import co.edu.uniquindio.reservasuq.Modelo.TipoUsuario;
import co.edu.uniquindio.reservasuq.Servicio.ServiciosReservasUQ;


import java.time.LocalDate;
import java.util.List;

public class ControladorPrincipal implements ServiciosReservasUQ {
    private static ControladorPrincipal INSTANCIA;
    private final ReservasUQ reservasUQ;


    private ControladorPrincipal() {
        reservasUQ = new ReservasUQ();
    }


    public static ControladorPrincipal getInstancia() {
        if (INSTANCIA == null) {
            INSTANCIA = new ControladorPrincipal();
        }
        return INSTANCIA;
    }


    @Override
    public Persona login(String correo, String contrasena) throws Exception {
        return reservasUQ.login(correo, contrasena);
    }


    @Override
    public void registrarPersona(String cedula, String nombre, TipoUsuario tipoUsuario, String email, String password) throws Exception {
        reservasUQ.registrarPersona(cedula, nombre, tipoUsuario, email, password);
    }


    @Override
    public void crearInstalacion(String nombre,int aforo, float costo, List<Horario> horarios) {
        reservasUQ.crearInstalacion(nombre, aforo, costo, horarios);
    }

    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {
        return null;
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return List.of();
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) {
        return List.of();
    }


    //TODO Completar con el resto de métodos necesarios para la aplicación


}

