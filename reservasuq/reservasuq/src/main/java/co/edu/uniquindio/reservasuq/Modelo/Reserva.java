package co.edu.uniquindio.reservasuq.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {
    private Persona persona;
    private Instalacion instalacion;
    private LocalDate fecha;
    private LocalTime hora;

    public boolean esCancelable(LocalDate fechaActual) {
        return fechaActual.isBefore(fecha.minusDays(2));
    }
}
