module com.example.javaapp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.javaapp1 to javafx.fxml;
    exports com.example.javaapp1;
}