package gefx.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class AboutWindowController {
    public GridPane windowPane;

    public void closeWindow(ActionEvent actionEvent) {
        windowPane.getScene().getWindow().hide();
    }
}
