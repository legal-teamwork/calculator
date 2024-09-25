package legalteamwork.application

import javafx.fxml.FXML
import javafx.scene.control.TextArea

var serverUrl: String = "http://localhost:5201"

class MainViewController {
    lateinit var serverUrlInput: TextArea

    @FXML
    fun initialize() {
        serverUrlInput.textProperty().addListener { _, _, newValue ->
            serverUrl = newValue
        }
    }
}