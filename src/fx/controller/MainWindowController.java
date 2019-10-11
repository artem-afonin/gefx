package fx.controller;

import core.scene.AboutWindow;
import core.tool.DotTool;
import core.tool.DrawHandler;
import core.tool.DrawTool;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController {
    public Canvas canvas;
    public Group drawGroup;
    public Pane drawPane;

    public void initialize() {
        DrawTool tool = new DotTool();
        DrawHandler drawHandler = new DrawHandler(canvas, tool);
        drawHandler.runHandler();
    }

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
