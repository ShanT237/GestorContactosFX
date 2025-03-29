module co.edu.uniquindio.gestorcontactosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires static lombok;


    opens co.edu.uniquindio.gestorcontactosfx to javafx.fxml;
    opens co.edu.uniquindio.gestorcontactosfx.Controller to javafx.fxml;
    exports co.edu.uniquindio.gestorcontactosfx;
    exports co.edu.uniquindio.gestorcontactosfx.Controller;
}