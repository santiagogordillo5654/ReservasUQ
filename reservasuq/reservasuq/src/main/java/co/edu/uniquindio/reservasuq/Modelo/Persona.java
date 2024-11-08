package co.edu.uniquindio.reservasuq.Modelo;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private int cedula;
    private String email;
    private TipoUsuario tipoUsuario;
    private String contrasena;
}

