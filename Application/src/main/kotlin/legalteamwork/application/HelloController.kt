package legalteamwork.application

import javafx.fxml.FXML
import javafx.scene.layout.VBox

class HelloController {
    lateinit var historyBox: VBox

    @FXML
    fun initialize() {
        initHistory()
    }

    @FXML
    fun initHistory() {
        historyBox.children.setAll(getRecentTasks().map { HistoryDisplay(it) })
    }
}