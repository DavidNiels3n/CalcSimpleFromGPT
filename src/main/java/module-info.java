module com.example.calcsimplefromgpt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calcsimplefromgpt to javafx.fxml;
    exports com.example.calcsimplefromgpt;
}