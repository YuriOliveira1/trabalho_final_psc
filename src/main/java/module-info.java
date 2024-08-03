module com.yurioliveira.doacoes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.yurioliveira.doacoes to javafx.fxml;
    exports com.yurioliveira.doacoes;
}