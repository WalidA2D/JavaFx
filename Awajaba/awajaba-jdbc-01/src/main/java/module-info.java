module com.awa.awajaba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.awa.awajaba to javafx.fxml;
    exports com.awa.awajaba;
}