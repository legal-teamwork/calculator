package legalteamwork.application

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.text.Font
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

data class HistoryEntry(
    val task: String,
    val answer: Double
)

fun getRecentTasks(): List<HistoryEntry> {
    /* test implementation */
    return listOf(
        HistoryEntry("2+2", 4.0),
        HistoryEntry("5*3/2", 7.5),
        HistoryEntry("(5+8)/4*4", 13.0)
    )
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
            text.text = entry.task
        } else {
            shown = true
            text.text = entry.answer.toString()
        }
    }

    init {
        text = Label(entry.task).apply {
            font = Font(24.0)
            maxWidth = Double.POSITIVE_INFINITY
        }
        val copyButton = Button("Copy input").apply {
            setOnMouseClicked { copy(entry.task) }
        }
        val showButton = Button("Copy answer").apply {
            setOnMouseClicked { copy(entry.answer.toString()) }
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