module com.rainyday.rainyday {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires com.google.gson;
    requires java.net.http;
    requires javafx.graphics;

    opens com.rainyday.rainyday to javafx.fxml;
    opens org.rainyday to com.google.gson;
    exports com.rainyday.rainyday;
}