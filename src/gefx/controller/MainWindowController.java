package gefx.controller;

import gefx.core.scene.AboutWindow;
import gefx.core.tool.DotTool;
import gefx.core.tool.DrawHandler;
import gefx.core.tool.DrawTool;
import gefx.core.tool.LineTool;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainWindowController {
    public Canvas canvas;
    public Group drawGroup;
    public Pane drawPane;
    public ColorPicker toolColorCheckbox;
    public Slider toolWidthSlider;

    private DrawTool tool;
    private Color toolColor;
    private double toolWidth;
    private double toolOpacity;

    private DrawHandler drawHandler;


    public void initialize() {
        setTool(new DotTool());
        drawHandler = new DrawHandler(canvas, tool);
        drawHandler.runHandler();

        toolWidthSlider.setOnMouseDragged(this::toolWidthSliderHandler);
        toolColorCheckbox.setOnAction(this::toolColorCheckboxHandler);

        toolWidthSlider.setValue(tool.getStrokeWidth());
        toolColorCheckbox.setValue(Color.BLACK);
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
    }

    public void setDotTool() {
        setTool(new DotTool());
    }

    public void setLineTool() {
        setTool(new LineTool());
    }

    public void toolColorCheckboxHandler(ActionEvent event) {
        tool.setColor(toolColorCheckbox.getValue());
    }

    public void toolWidthSliderHandler(MouseEvent event) {
        tool.setStrokeWidth(toolWidthSlider.getValue());
    }
}
