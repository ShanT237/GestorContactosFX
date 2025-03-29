package co.edu.uniquindio.gestorcontactosfx.Controller;

import co.edu.uniquindio.gestorcontactosfx.Model.GestorContactos;
import co.edu.uniquindio.gestorcontactosfx.Model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
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
    private ComboBox<String> selectedBox;

    @FXML
    private TextField searchField;

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
    private TableColumn<Usuario, ImageView> colImagen;

    @FXML
    private TableColumn<Usuario, String> colEmail;

    private final GestorContactos gestorContactos = new GestorContactos();

    @FXML
    public void seleccionarFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.jpg", "*.jpeg", "*.png"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            String ruta = file.toURI().toString();
            imgFotoPerfil.setImage(new Image(ruta, true));

            Usuario usuarioSeleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
            if (usuarioSeleccionado != null) {
                usuarioSeleccionado.setFotoPerfil(ruta);
                tablaDeContenido.refresh();
            }
        }
    }



    @FXML
    public void crearEstudiante(ActionEvent event) throws Exception {
        if (!validarCampos()) {
            return;
        }
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        LocalDate fechaNacimiento = dateNacimiento.getValue();

        String rutaImagen = (imgFotoPerfil.getImage() != null) ? imgFotoPerfil.getImage().getUrl() : null;

        Usuario usuario = Usuario.builder()
                .telefono(telefono)  // Si el teléfono es obligatorio, debe ir primero
                .nombre(nombre)
                .apellido(apellido)
                .email(email)
                .fechaNacimiento(fechaNacimiento)
                .fotoPerfil(rutaImagen)
                .build();
        gestorContactos.crearEstudiante(usuario);
        tablaDeContenido.setItems(gestorContactos.getContactos());

        limpiarCampos();
    }

    @FXML
    public void eliminarEstudiante(ActionEvent event) {
        Usuario seleccionado = tablaDeContenido.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            try {
                gestorContactos.eliminarEstudiante(seleccionado.getTelefono());
                tablaDeContenido.setItems(FXCollections.observableArrayList(gestorContactos.getContactos()));
            } catch (Exception e) {
                mostrarAlerta("Error", e.getMessage());
            }
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

        selectedBox.getItems().addAll("Nombre", "Teléfono");
        selectedBox.setValue("Nombre");



        searchField.textProperty().addListener((observable, oldValue, newValue) -> filtrarTabla(newValue));

        colImagen.setCellValueFactory(cellData -> {
            String ruta = cellData.getValue().getFotoPerfil();
            ImageView imageView = new ImageView();

            if (ruta != null && !ruta.isEmpty()) {
                imageView.setImage(new Image(ruta, true));
            }

            imageView.setFitHeight(60);
            imageView.setFitWidth(60);
            return new javafx.beans.property.SimpleObjectProperty<>(imageView);
        });

        tablaDeContenido.setItems(gestorContactos.getContactos());


        tablaDeContenido.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtNombre.setText(newSelection.getNombre());
                txtApellido.setText(newSelection.getApellido());
                txtTelefono.setText(newSelection.getTelefono());
                txtEmail.setText(newSelection.getEmail());
                dateNacimiento.setValue(newSelection.getFechaNacimiento());

                if (newSelection.getFotoPerfil() != null && !newSelection.getFotoPerfil().isEmpty()) {
                    imgFotoPerfil.setImage(new Image(newSelection.getFotoPerfil(), true));
                } else {
                    imgFotoPerfil.setImage(null);
                }
            }
        });

    }

    private boolean validarCampos() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String email = txtEmail.getText();
        LocalDate fechaNacimiento = dateNacimiento.getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty() || fechaNacimiento == null) {
            mostrarAlerta("Error", "Todos los campos deben estar completos.");
            return false;
        }


        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            mostrarAlerta("Error", "Ingrese un correo electrónico válido.");
            return false;
        }

        if (!telefono.matches("\\d{7,10}")) {
            mostrarAlerta("Error", "El teléfono debe contener entre 7 y 10 dígitos numéricos.");
            return false;
        }


        if (fechaNacimiento.isAfter(LocalDate.now())) {
            mostrarAlerta("Error", "La fecha de nacimiento no puede ser futura.");
            return false;
        }

        return true;
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtTelefono.clear();
        txtEmail.clear();
        dateNacimiento.setValue(null);
        imgFotoPerfil.setImage(null);
    }

    private void filtrarTabla(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            tablaDeContenido.setItems(gestorContactos.getContactos());
            return;
        }

        ObservableList<Usuario> listaFiltrada = FXCollections.observableArrayList();

        for (Usuario usuario : gestorContactos.getContactos()) {
            if (selectedBox.getValue().equals("Nombre") && usuario.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                listaFiltrada.add(usuario);
            } else if (selectedBox.getValue().equals("Teléfono") && usuario.getTelefono().contains(filtro)) {
                listaFiltrada.add(usuario);
            }
        }

        tablaDeContenido.setItems(listaFiltrada);
    }
}



