package co.edu.uniquindio.gestorcontactosfx.Controller;

import co.edu.uniquindio.gestorcontactosfx.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class InicioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableColumn<Usuario, String> colApellido;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TableColumn<Usuario, LocalDate> colFechaNacimieto;

    @FXML
    private TextField txtEmail;

    @FXML
    private ImageView imgFotoPerfil; // Usamos ImageView en lugar de JFileChooser

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private DatePicker dateNacimiento;

    @FXML
    private TableView<Usuario> tablaDeContenido;

    @FXML
    private TableColumn<Usuario, ImageView> colImagen; // Cambiar a ImageView en lugar de JFileChooser

    @FXML
    private TableColumn<Usuario, String> colTelefono;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();









    @FXML
    public void initialize() {
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'inicio.fxml'.";
        assert colApellido != null : "fx:id=\"colApellido\" was not injected: check your FXML file 'inicio.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'inicio.fxml'.";
        assert colFechaNacimieto != null : "fx:id=\"colFechaNacimieto\" was not injected: check your FXML file 'inicio.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'inicio.fxml'.";
        assert imgFotoPerfil != null : "fx:id=\"imgFotoPerfil\" was not injected: check your FXML file 'inicio.fxml'.";
        assert txtApellido != null : "fx:id=\"txtApellido\" was not injected: check your FXML file 'inicio.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'inicio.fxml'.";
        assert dateNacimiento != null : "fx:id=\"dateNacimiento\" was not injected: check your FXML file 'inicio.fxml'.";
        assert tablaDeContenido != null : "fx:id=\"tablaDeContenido\" was not injected: check your FXML file 'inicio.fxml'.";
        assert colTelefono != null : "fx:id=\"colTelefono\" was not injected: check your FXML file 'inicio.fxml'.";
        assert colEmail != null : "fx:id=\"colEmail\" was not injected: check your FXML file 'inicio.fxml'.";

        colNombre.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        colApellido.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellido()));
        colTelefono.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTelefono()));
        colEmail.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmail()));
        colFechaNacimieto.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFechaNacimiento()));

        // Mostrar la imagen en la columna
        colImagen.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getFotoPerfil()));

        // Usar un CellFactory para mostrar la imagen en la celda
        colImagen.setCellFactory(param -> new TableCell<Usuario, ImageView>() {
            @Override
            protected void updateItem(ImageView item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null); // Si está vacía, no mostrar nada
                } else {
                    setGraphic(item); // Si no está vacía, mostrar la imagen
                }
            }
        });

        tablaDeContenido.setItems(listaUsuarios);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtEmail.clear();
        dateNacimiento.setValue(null);
        imgFotoPerfil.setImage(null); // Limpiar el ImageView
    }

    public void crearEstudiante(javafx.event.ActionEvent actionEvent) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        LocalDate fechaNacimiento = dateNacimiento.getValue();

        Usuario nuevoUsuario = new Usuario(null, fechaNacimiento, email, telefono, apellido, nombre);
        listaUsuarios.add(nuevoUsuario);
        tablaDeContenido.setItems(listaUsuarios);

        limpiarCampos();
    }

    public void eliminarEstudiante(javafx.event.ActionEvent actionEvent) {
        Usuario seleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaUsuarios.remove(seleccionado);
        }
    }

    public void actualizarEstudiante(javafx.event.ActionEvent actionEvent) {
        Usuario seleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setApellido(txtApellido.getText());
            seleccionado.setTelefono(txtTelefono.getText());
            seleccionado.setEmail(txtEmail.getText());
            seleccionado.setFechaNacimiento(dateNacimiento.getValue());
            tablaDeContenido.refresh();
        }
    }

    public void seleccionarFoto(javafx.event.ActionEvent actionEvent) {
        // Crear un JFileChooser para seleccionar una imagen
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar una imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png"));

        // Mostrar el diálogo para seleccionar un archivo
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Convertir el archivo en una imagen de JavaFX
            Image image = new Image(file.toURI().toString());

            // Actualizar la imagen del perfil en el ImageView (mostrado en la interfaz gráfica)
            imgFotoPerfil.setImage(image);

            // Obtener el usuario seleccionado de la tabla
            Usuario seleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                // Asignar la imagen al perfil del usuario seleccionado como un ImageView
                seleccionado.setFotoPerfil(new ImageView(image)); // Guardar la ImageView con la imagen
            }

            // Actualizar la tabla si es necesario
            tablaDeContenido.refresh(); // Refrescar la tabla para mostrar la nueva imagen
        }
    }
}