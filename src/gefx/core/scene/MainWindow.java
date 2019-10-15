package gefx.core.scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Window {
    @Override
    public void start(Stage primaryStage) throws Exception {
        STAGE_TITLE = "GEFX";
        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        Parent window = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
        Scene scene = new Scene(window);

        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
