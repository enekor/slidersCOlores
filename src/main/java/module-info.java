module com.example.coloresbind {
    requires javafx.controls;

    opens com.example.coloresbind to javafx.fxml;
    exports com.example.coloresbind;
}