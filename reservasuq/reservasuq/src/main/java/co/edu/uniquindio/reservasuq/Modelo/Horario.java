package co.edu.uniquindio.reservasuq.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Horario {
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public boolean estaDisponible(LocalTime hora) {
        return !hora.isBefore(horaInicio) && !hora.isAfter(horaFin);
    }
}
