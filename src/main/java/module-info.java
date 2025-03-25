module co.edu.uniquindio.gestorcontactosfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gestorcontactosfx to javafx.fxml;
    exports co.edu.uniquindio.gestorcontactosfx;
}