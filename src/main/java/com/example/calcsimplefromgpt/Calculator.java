package com.example.calcsimplefromgpt;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
    private TextField textField;

    @Override
    public void start(Stage primaryStage) {
        // Create a grid pane layout to hold the calculator buttons
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        // Create a text field to display the calculator input and result
        textField = new TextField();
        textField.setEditable(false);
        textField.setPrefWidth(200);
        gridPane.add(textField, 0, 0, 4, 1);

        // Create the calculator buttons
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnEquals = new Button("=");

        // Add the buttons to the grid pane layout
        gridPane.add(btn7, 0, 1);
        gridPane.add(btn8, 1, 1);
        gridPane.add(btn9, 2, 1);
        gridPane.add(btnDivide, 3, 1);
        gridPane.add(btn4, 0, 2);
        gridPane.add(btn5, 1, 2);
        gridPane.add(btn6, 2, 2);
        gridPane.add(btnMultiply, 3, 2);
        gridPane.add(btn1, 0, 3);
        gridPane.add(btn2, 1, 3);
        gridPane.add(btn3, 2, 3);
        gridPane.add(btnMinus, 3, 3);
        gridPane.add(btn0, 0, 4);
        gridPane.add(btnEquals, 1, 4);
        gridPane.add(btnPlus, 2, 4);

        // Create button event handlers
        EventHandler<ActionEvent> numberHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button button = (Button) event.getSource();
                textField.setText(textField.getText() + button.getText());
            }
        };

        EventHandler<ActionEvent> operatorHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button button = (Button) event.getSource();
                String operator = button.getText();
                double value1 = Double.parseDouble(textField.getText());
                textField.setText("");
                textField.setPromptText(operator);
                btnEquals.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        double value2 = Double.parseDouble(textField.getText());
                        double result;
                        switch (operator) {
                            case "+":
                                result = value1 + value2;
                                break;
                            case "-":
                                result = value1 - value2;
                                break;
                            case "*":
                                result = value1 * value2;
                                break;
                            case "/":
                                result = value1 / value2;
                                break;
                            default:
                                result = 0;
                        }
                        textField.setText(Double.toString(result));
                    }
                });
            }
        };

        // Add event handlers to the buttons
        btn0.setOnAction(numberHandler);
        btn1.setOnAction(numberHandler);
        btn2.setOnAction(numberHandler);
        btn3.setOnAction(numberHandler);
        btn4.setOnAction(numberHandler);
        btn5.setOnAction(numberHandler);
        btn6.setOnAction(numberHandler);
        btn7.setOnAction(numberHandler);
        btn8.setOnAction(numberHandler);
        btn9.setOnAction(numberHandler);
        btnPlus.setOnAction(operatorHandler);
        btnMinus.setOnAction(operatorHandler);
        btnMultiply.setOnAction(operatorHandler);
        btnDivide.setOnAction(operatorHandler);

        // Create a scene with the grid pane layout and show the stage
        Scene scene = new Scene(gridPane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
