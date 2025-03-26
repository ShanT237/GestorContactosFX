package co.edu.uniquindio.gestorcontactosfx.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class viewController {


        @FXML // ResourceBundle that was given to the FXMLLoader
        private ResourceBundle resources;

        @FXML // URL location of the FXML file that was given to the FXMLLoader
        private URL location;

        @FXML // fx:id="txtNombre"
        private TextField txtNombre; // Value injected by FXMLLoader

        @FXML // fx:id="colApellido"
        private TableColumn<?, ?> colApellido; // Value injected by FXMLLoader

        @FXML // fx:id="txtTelefono"
        private TextField txtTelefono; // Value injected by FXMLLoader

        @FXML // fx:id="colFechaNacimieto"
        private TableColumn<?, LocalDate> colFechaNacimieto; // Value injected by FXMLLoader

        @FXML // fx:id="txtEmail"
        private TextField txtEmail; // Value injected by FXMLLoader

        @FXML // fx:id="imgFotoPerfil"
        private ImageView imgFotoPerfil; // Value injected by FXMLLoader

        @FXML // fx:id="txtApellido"
        private TextField txtApellido; // Value injected by FXMLLoader

        @FXML // fx:id="colNombre"
        private TableColumn<?, String > colNombre; // Value injected by FXMLLoader

        @FXML // fx:id="dateNacimiento"
        private DatePicker dateNacimiento; // Value injected by FXMLLoader

        @FXML // fx:id="tablaDeContenido"
        private TableView<?> tablaDeContenido; // Value injected by FXMLLoader

        @FXML // fx:id="colTelefono"
        private TableColumn<?, String > colTelefono; // Value injected by FXMLLoader

        @FXML // fx:id="colEmail"
        private TableColumn<?, String> colEmail; // Value injected by FXMLLoader

        @FXML
        void seleccionarFoto(ActionEvent event) {

        }

        @FXML
        void crearEstudiante(ActionEvent event) {

        }

        @FXML
        void eliminarEstudiante(ActionEvent event) {

        }

        @FXML
        void actualizarEstudiante(ActionEvent event) {

        }

        @FXML
            // This method is called by the FXMLLoader when initialization is complete
        void initialize() {
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

        }
    }
