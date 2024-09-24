package legalteamwork.application

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class CalculatorApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(CalculatorApplication::class.java.getResource("main-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 600.0, 537.0 + 29.0)
        scene.stylesheets.add(this::class.java.getResource("style.css")!!.toExternalForm())
        stage.title = "Calculator"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
//    Application.launch(CalculatorApplication::class.java)
}