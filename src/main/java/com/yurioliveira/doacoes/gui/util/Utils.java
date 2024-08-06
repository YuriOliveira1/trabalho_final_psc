package com.yurioliveira.doacoes.gui.util;

import javafx.stage.Stage;
import javafx.scene.Node;

import javafx.event.ActionEvent;

public class Utils {

    public static Stage currentStage(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Integer tryParseToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
