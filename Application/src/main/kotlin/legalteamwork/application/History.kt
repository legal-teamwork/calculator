package legalteamwork.application

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.text.Font
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.net.URI

@Serializable
data class HistoryEntry(
    val id: Int,
    val expression: String,
    val result: String
)

@OptIn(ExperimentalSerializationApi::class)
fun getRecentTasks(): List<HistoryEntry> {
    try {
        URI("$serverUrl/GetListOfExpressions").toURL()
    } catch (_: IllegalArgumentException) {
        return listOf()
    }
    val stream = URI("$serverUrl/api/GetListOfExpressions").toURL().openStream()
    val obj = Json.decodeFromStream<List<HistoryEntry>>(stream)
    return obj
}

class HistoryDisplay(private val entry: HistoryEntry): HBox() {
    private var shown = false
    private var text: Label

    private fun copy(text: String) {
        Toolkit.getDefaultToolkit()
            .systemClipboard
            .setContents(
                StringSelection(text),
                null
            )
    }

    private fun show() {
        if (shown) {
            shown = false
            text.text = entry.expression
        } else {
            shown = true
            text.text = entry.result
        }
    }

    init {
        text = Label(entry.expression).apply {
            font = Font("Arial", 24.0)
            textFill = Color.WHITE
            maxWidth = Double.POSITIVE_INFINITY
        }
        val copyButton = Button("Copy input").apply {
            styleClass.add("historyButton")
            setOnMouseClicked { copy(entry.expression) }
        }
        val showButton = Button("Copy answer").apply {
            styleClass.add("historyButton")
            setOnMouseClicked { copy(entry.result) }
        }
        children.addAll(text, copyButton, showButton)

        setOnMouseClicked { show() }
        styleClass.add("historyBox")
        alignment = Pos.CENTER_LEFT
        spacing = 5.0
        padding = Insets(0.0, 10.0, 0.0, 10.0)
        HBox.setHgrow(text, Priority.ALWAYS)
    }
}