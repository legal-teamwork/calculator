package legalteamwork.application

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 640.0, 480.0)
        scene.stylesheets.add(this::class.java.getResource("style.css")!!.toExternalForm())
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

class CalculatorApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(CalculatorApplication::class.java.getResource("Calculator-view.fxml"))
        val scene = Scene(fxmlLoader.load(), 298.0, 537.0)
        stage.title = "Calculator"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
//    Application.launch(HelloApplication::class.java)
    Application.launch(CalculatorApplication::class.java)
}