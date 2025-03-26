package co.edu.uniquindio.gestorcontactosfx.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private ImageView fotoPerfil;  // Cambiado a ImageView para mostrar imágenes en JavaFX

    public Usuario(ImageView fotoPerfil, LocalDate fechaNacimiento, String email, String telefono, String apellido, String nombre) {
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

    public ImageView getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(ImageView fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    // Método para seleccionar una foto usando JFileChooser de Swing
    public void seleccionarFoto() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Foto");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes JPG, PNG, JPEG", "jpg", "jpeg", "png"));

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Verifica que el archivo seleccionado sea una imagen válida
            String fileName = file.getName().toLowerCase();
            if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
                try {
                    // Cargar la imagen usando el archivo seleccionado
                    Image image = new Image(file.toURI().toString());  // Convierte el archivo a URI y luego a Image
                    this.fotoPerfil = new ImageView(image);  // Asigna la imagen al atributo fotoPerfil
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al cargar la imagen.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Formato no permitido. Selecciona un archivo JPG, JPEG o PNG.");
            }
        } else {
            System.out.println("No se seleccionó ninguna imagen.");
        }
    }
}