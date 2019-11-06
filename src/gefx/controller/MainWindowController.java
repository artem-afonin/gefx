package gefx.controller;

import gefx.core.scene.AboutWindow;
import gefx.core.tool.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainWindowController {
    public Canvas canvas;
    public Group drawGroup;
    public Pane drawPane;
    public ColorPicker toolColorCheckbox;
    public Slider toolWidthSlider;

    public Button loadImageButton;
    public Button saveImageButton;

    public Button dotToolButton;
    public Button lineToolButton;
    public Button rectangleToolButton;
    public Button circleToolButton;


    private DrawTool tool;
    private Color toolColor;
    private double toolWidth;
    private double toolOpacity;

    private DrawHandler drawHandler;

    private double prefCanvasWidth;
    private double prefCanvasHeight;


    public void initialize() {
        setDotTool();

        prefCanvasWidth = canvas.getWidth();
        prefCanvasHeight = canvas.getHeight();

        toolWidthSlider.setOnMouseDragged(this::toolWidthSliderHandler);
        toolColorCheckbox.setOnAction(this::toolColorCheckboxHandler);

        toolWidthSlider.setValue(tool.getStrokeWidth());
        toolColorCheckbox.setValue(Color.BLACK);

        loadImageButton.setOnMouseClicked(this::loadImage);
        saveImageButton.setOnMouseClicked(this::saveImage);

        setToolButtonsImages();
        dotToolButton.setOnMouseClicked(event -> {setDotTool();});
        lineToolButton.setOnMouseClicked(event -> {setLineTool();});
        rectangleToolButton.setOnMouseClicked(event -> {setRectangleTool();});
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

    public void setTool(DrawTool tool) {
        this.tool = tool;
        this.tool.setColor(toolColor);
        this.tool.setStrokeWidth(toolWidth);
        this.tool.setCurrentOpacity(toolOpacity);
        if (drawHandler != null) {
            drawHandler.setDrawTool(this.tool);
        } else {
            drawHandler = new DrawHandler(canvas, this.tool);
        }
    }

    public void setDotTool() {
        setTool(new DotTool());
    }

    public void setLineTool() {
        setTool(new LineTool());
    }

    public void setRectangleTool() {
        setTool(new RectangleTool());
    }

    public void toolColorCheckboxHandler(ActionEvent event) {
        tool.setColor(toolColorCheckbox.getValue());
    }

    public void toolWidthSliderHandler(MouseEvent event) {
        tool.setStrokeWidth(toolWidthSlider.getValue());
    }

    public void loadImage(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите изображение");
        File file = fileChooser.showOpenDialog(loadImageButton.getScene().getWindow());

        if (file == null)
            return;

        Image image = new Image(
                file.toURI().toString(),
                prefCanvasWidth,
                prefCanvasHeight,
                true,
                true,
                false
        );

        BackgroundImage backImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        drawPane.setBackground(new Background(backImage));
        canvas.setWidth(image.getWidth());
        canvas.setHeight(image.getHeight());
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void saveImage(MouseEvent event) {
        WritableImage image = drawGroup.snapshot(null, null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить изображение");
        fileChooser.setInitialFileName("image.png");
        File file = fileChooser.showSaveDialog(saveImageButton.getScene().getWindow());

        if (file == null)
            return;

        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setToolButtonsImages() {
        Image dotToolImage = null;
        Image lineToolImage = null;
        Image rectangleToolImage = null;
        Image circleToolImage = null;

        try {
            dotToolImage = new Image(
                    this.getClass()
                            .getResource("/images/dotTool.png")
                            .toURI()
                            .toString(),
                    32,
                    32,
                    false,
                    true);
        } catch (Exception ignored) {}

        try {
            lineToolImage = new Image(
                    this.getClass()
                            .getResource("/images/lineTool.png")
                            .toURI()
                            .toString(),
                    32,
                    32,
                    false,
                    true);
        } catch (Exception ignored) {}

        try {
            rectangleToolImage = new Image(
                    this.getClass()
                            .getResource("/images/rectangleTool.png")
                            .toURI()
                            .toString(),
                    32,
                    32,
                    false,
                    true);
        } catch (Exception ignored) {}

        try {
            circleToolImage = new Image(
                    this.getClass()
                            .getResource("/images/circleTool.png")
                            .toURI()
                            .toString(),
                    32,
                    32,
                    false,
                    true);
        } catch (Exception ignored) {}

        dotToolButton.graphicProperty().setValue(new ImageView(dotToolImage));
        lineToolButton.graphicProperty().setValue(new ImageView(lineToolImage));
        rectangleToolButton.graphicProperty().setValue(new ImageView(rectangleToolImage));
        circleToolButton.graphicProperty().setValue(new ImageView(circleToolImage));
    }
}
