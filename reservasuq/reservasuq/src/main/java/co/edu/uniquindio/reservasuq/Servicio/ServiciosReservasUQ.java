package co.edu.uniquindio.reservasuq.Servicio;

import co.edu.uniquindio.reservasuq.Modelo.Horario;
import co.edu.uniquindio.reservasuq.Modelo.Persona;
import co.edu.uniquindio.reservasuq.Modelo.Reserva;
import co.edu.uniquindio.reservasuq.Modelo.TipoUsuario;

import java.time.LocalDate;
import java.util.List;

public interface ServiciosReservasUQ {
    Persona login(String correo, String contrasena) throws Exception;


    void registrarPersona(String cedula, String nombre, TipoUsuario tipoUsuario, String email, String password) throws Exception;


    void crearInstalacion(String nombre, int aforo, float costo, List<Horario> horarios);


    Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception;


    List<Reserva> listarTodasReservas();


    List<Reserva> listarReservasPorPersona(String cedulaPersona);


}



