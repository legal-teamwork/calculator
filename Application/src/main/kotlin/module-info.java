module legalteamwork.application {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.serialization;
    requires kotlinx.serialization.core;
    requires kotlinx.serialization.json;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires java.desktop;


    opens legalteamwork.application to javafx.fxml, kotlin.serialization, kotlinx.serialization.json, kotlinx.serialization.core;
    exports legalteamwork.application;
}