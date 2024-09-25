package legalteamwork.application

import javafx.fxml.FXML
import javafx.scene.control.TextArea

var serverUrl: String = ""

class MainViewController {
    lateinit var serverUrlInput: TextArea

    @FXML
    fun initialize() {
        serverUrlInput.textProperty().addListener { _, _, newValue ->
            serverUrl = newValue
        }
    }
}