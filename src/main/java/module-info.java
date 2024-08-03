module com.yurioliveira.doacoes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;

    opens com.yurioliveira.doacoes to javafx.fxml;
    opens com.yurioliveira.doacoes.gui to javafx.fxml;
    exports com.yurioliveira.doacoes;
}