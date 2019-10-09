package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_HEIGHT = 480;
    private static final String stageTitle = "GEFX";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent mainWindow = FXMLLoader.load(getClass().getResource("/fx/fxml/MainWindow.fxml"));
        Scene mainScene = new Scene(mainWindow, WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.setTitle(stageTitle);
        primaryStage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
