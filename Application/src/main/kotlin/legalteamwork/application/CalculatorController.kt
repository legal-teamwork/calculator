package legalteamwork.application

import com.fasterxml.jackson.databind.ObjectMapper
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.math.exp

class CalculatorController {
    @FXML
    private lateinit var output: Label
    private val expression = StringBuilder()

    @FXML
    private fun clearOutput() {
        output.text = "0"
        expression.setLength(0)
    }

    @FXML
    private fun readExpression(event: ActionEvent) {
        val value = (event.source as Button).text

        if (value == "=") {
            calculateResult()
        } else {
            expression.append(value)
            output.text = expression.toString()
        }
    }

    private fun calculateResult() {
        val expressionInput = expression.toString()

        try {
            val result = getResult(expressionInput)
            sendToServer(expressionInput, result)
            output.text = result
        } catch (e: Exception) {
            output.text = "Err"
        } finally {
            expression.setLength(0)
        }
    }

    private fun getResult(input: String): String {
        /* test implementation */
        return "$input (but result)"
    }

    private fun sendToServer(expression: String, result: String) {
        val values = mapOf("expression" to expression, "result" to result)

        val objectMapper = ObjectMapper()
        val requestBody: String = objectMapper
            .writeValueAsString(values)

        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("$serverUrl/AddExpression"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        println(response.body())
    }
}