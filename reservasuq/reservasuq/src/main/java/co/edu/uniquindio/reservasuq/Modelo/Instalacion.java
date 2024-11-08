package co.edu.uniquindio.reservasuq.Modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instalacion {
    private String nombre;
    private int aforo;
    private float costo;
    private List<Horario> horarios;

    public boolean estaDisponibleEnHorario(Horario horario) {
        for (Horario h : horarios) {
            if (h.equals(horario)) {
                return true;
            }
        }
        return false;
    }
}
