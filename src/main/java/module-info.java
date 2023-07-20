module com.rainyday.rainyday {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.rainyday.rainyday to javafx.fxml;
    exports com.rainyday.rainyday;
}