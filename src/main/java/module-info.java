module com.example.balazskrisztian_muzeumfrontendjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.balazskrisztian_muzeumfrontendjavafx to javafx.fxml;
    exports com.example.balazskrisztian_muzeumfrontendjavafx;
    exports com.example.balazskrisztian_muzeumfrontendjavafx.Controllers;
    opens com.example.balazskrisztian_muzeumfrontendjavafx.Controllers to javafx.fxml;
}