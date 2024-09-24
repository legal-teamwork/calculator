package legalteamwork.application;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    private Label output;
    private StringBuilder expression = new StringBuilder();

    @FXML
    private void clearOutput() {
        output.setText("0");
        expression.setLength(0);
    }

    @FXML
    private void readExpression(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (value.equals("=")) {
            calculateResult();
        } else {
            expression.append(value);
            output.setText(expression.toString());
        }
    }

    private void calculateResult() {
        String expressionInput = expression.toString();

        try {
            String result = expressionInput; // Для примера, просто возвращаем выражение. А так выражение отправляется в парсер и выдает результат
            output.setText(result);
        }
        catch (Exception e) {
            output.setText("Err");
        }
        finally {
            expression.setLength(0);
        }
    }
}
