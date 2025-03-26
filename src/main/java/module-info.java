module co.edu.uniquindio.gestorcontactosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.gestorcontactosfx to javafx.fxml;
    exports co.edu.uniquindio.gestorcontactosfx;
}