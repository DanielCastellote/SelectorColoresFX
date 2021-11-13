module com.example.selectorcoloresfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.selectorcoloresfx to javafx.fxml;
    exports com.example.selectorcoloresfx;
}