package co.edu.uniquindio.gestorcontactosfx.Controller;

import co.edu.uniquindio.gestorcontactosfx.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
    private ImageView imgFotoPerfil;

    @FXML
    private TextField txtApellido;

    @FXML
    private TableColumn<Usuario, String> colNombre;

    @FXML
    private DatePicker dateNacimiento;

    @FXML
    private TableView<Usuario> tablaDeContenido;

    @FXML
    private TableColumn<Usuario, String> colTelefono;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    private final ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    @FXML
    public void seleccionarFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            imgFotoPerfil.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    public void crearEstudiante(ActionEvent event) {
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

    @FXML
    public void eliminarEstudiante(ActionEvent event) {
        Usuario seleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaUsuarios.remove(seleccionado);
        }
    }

    @FXML
    public void actualizarEstudiante(ActionEvent event) {
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

        tablaDeContenido.setItems(listaUsuarios);
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtEmail.clear();
        dateNacimiento.setValue(null);
    }
}
