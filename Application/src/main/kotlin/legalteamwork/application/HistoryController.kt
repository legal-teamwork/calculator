package legalteamwork.application

import javafx.fxml.FXML
import javafx.scene.control.TextArea
import javafx.scene.layout.VBox

class HistoryController {
    lateinit var historyBox: VBox

    @FXML
    fun initialize() {
        initHistory()
    }

    @FXML
    fun initHistory() {
        val entries = getRecentTasks()
        historyBox.children.setAll(entries.map { HistoryDisplay(it) })
    }
}