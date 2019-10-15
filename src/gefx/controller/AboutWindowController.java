package gefx.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class AboutWindowController {
    public AnchorPane windowPane;

    public void closeWindow(ActionEvent actionEvent) {
        windowPane.getScene().getWindow().hide();
    }
}
