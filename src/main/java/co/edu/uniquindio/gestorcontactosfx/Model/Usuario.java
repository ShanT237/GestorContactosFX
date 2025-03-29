package co.edu.uniquindio.gestorcontactosfx.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private String fotoPerfil;


}
