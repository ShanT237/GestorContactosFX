package co.edu.uniquindio.gestorcontactosfx.Model;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private JFileChooser fotoPerfil;


    public Usuario(JFileChooser fotoPerfil, LocalDate fechaNacimiento, String email, String telefono, String apellido, String nombre) {
        this.fotoPerfil = fotoPerfil;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public JFileChooser getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(JFileChooser fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public void seleccionarFoto() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null && file.isFile()) {
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
                this.fotoPerfil.setSelectedFile(new File(fileName));
            } else {
                System.out.println("Formato no permitido. Selecciona un archivo JPG, JPEG o PNG.");
            }
        }
    }



}
