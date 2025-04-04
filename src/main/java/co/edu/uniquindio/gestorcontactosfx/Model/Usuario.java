package co.edu.uniquindio.gestorcontactosfx.Model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private String fotoPerfil;

    // Constructor privado para forzar el uso del Builder
    private Usuario(Builder builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.telefono = builder.telefono;
        this.email = builder.email;
        this.fechaNacimiento = builder.fechaNacimiento;
        this.fotoPerfil = builder.fotoPerfil;
    }

    // Clase interna Builder
    public static class Builder {
        private String nombre;
        private String apellido;
        private String telefono;
        private String email;
        private LocalDate fechaNacimiento;
        private String fotoPerfil;

        public Builder(String telefono) { // Parámetro obligatorio
            this.telefono = telefono;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder fechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
            return this;
        }

        public Builder fotoPerfil(String fotoPerfil) {
            this.fotoPerfil = fotoPerfil;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
}
