package fx.controller;

import core.scene.AboutWindow;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainWindowController {
    public void closeApplication(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void openAboutWindow(ActionEvent actionEvent) {
        AboutWindow aboutWindow = new AboutWindow();

        try {
            aboutWindow.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
