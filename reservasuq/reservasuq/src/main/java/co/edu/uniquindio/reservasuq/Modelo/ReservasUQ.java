package co.edu.uniquindio.reservasuq.Modelo;

import co.edu.uniquindio.reservasuq.Servicio.ServiciosReservasUQ;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservasUQ implements ServiciosReservasUQ {
    private List<Persona> personas = new ArrayList<>();
    private List<Instalacion> instalaciones = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    @Override
    public Persona login(String correo, String contrasena) throws Exception {
        return personas.stream()
                .filter(p -> p.getEmail().equals(correo) && p.getContrasena().equals(contrasena))
                .findFirst()
                .orElseThrow(() -> new Exception("Credenciales incorrectas"));
    }

    @Override
    public void registrarPersona(String cedula, String nombre, TipoUsuario tipoUsuario, String email, String password) throws Exception {
        if (personas.stream().anyMatch(p -> p.getEmail().equals(email))) {
            throw new Exception("El correo ya está registrado.");
        }
        Persona persona = new Persona(nombre, Integer.parseInt(cedula), email, tipoUsuario, password);
        personas.add(persona);
    }

    @Override
    public void crearInstalacion(String nombre, int aforo, float costo, List<Horario> horarios) {
        Instalacion instalacion = new Instalacion(nombre, aforo, costo, horarios);
        instalaciones.add(instalacion);
    }

    @Override
    public Reserva crearReserva(String idInstalacion, String cedulaPersona, LocalDate diaReserva, String horaReserva) throws Exception {
        Persona persona = personas.stream()
                .filter(p -> String.valueOf(p.getCedula()).equals(cedulaPersona))
                .findFirst()
                .orElseThrow(() -> new Exception("Persona no encontrada"));

        Instalacion instalacion = instalaciones.stream()
                .filter(inst -> inst.getNombre().equals(idInstalacion))
                .findFirst()
                .orElseThrow(() -> new Exception("Instalación no encontrada"));

        if (diaReserva.isBefore(LocalDate.now().plusDays(2))) {
            throw new Exception("La reserva debe hacerse con al menos 2 días de anticipación.");
        }

        LocalTime hora = LocalTime.parse(horaReserva);
        boolean horarioDisponible = instalacion.getHorarios().stream().anyMatch(h -> h.estaDisponible(hora));
        if (!horarioDisponible) {
            throw new Exception("El horario no está disponible.");
        }

        Reserva reserva = new Reserva(persona, instalacion, diaReserva, hora);
        reservas.add(reserva);
        return reserva;
    }

    @Override
    public List<Reserva> listarTodasReservas() {
        return new ArrayList<>(reservas);
    }

    @Override
    public List<Reserva> listarReservasPorPersona(String cedulaPersona) {
        return reservas.stream()
                .filter(r -> String.valueOf(r.getPersona().getCedula()).equals(cedulaPersona))
                .toList();
    }
}
