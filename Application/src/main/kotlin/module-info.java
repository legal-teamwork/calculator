module legalteamwork.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires java.desktop;


    opens legalteamwork.application to javafx.fxml;
    exports legalteamwork.application;
}