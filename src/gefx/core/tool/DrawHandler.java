package gefx.core.tool;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import static javafx.scene.input.MouseEvent.*;

public class DrawHandler {
    private Canvas canvas;
    private DrawTool drawTool;
    private double x1, y1, x2, y2;

    public DrawHandler(Canvas canvas, DrawTool drawTool) {
        this.canvas = canvas;
        this.drawTool = drawTool;
        setGraphicsContextForDrawTool();
        runHandler();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private void setGraphicsContextForDrawTool() {
        this.drawTool.setGraphicsContext(canvas.getGraphicsContext2D());
    }

    public void setCanvas(Canvas canvas) {
        stopHandler();
        this.canvas = canvas;
        setGraphicsContextForDrawTool();
        runHandler();
    }

    public DrawTool getDrawTool() {
        return drawTool;
    }

    public void setDrawTool(DrawTool drawTool) {
        stopHandler();
        this.drawTool = drawTool;
        setGraphicsContextForDrawTool();
        runHandler();
    }

    private void mousePressedHandler(MouseEvent event) {
        x1 = event.getX();
        y1 = event.getY();
    }

    private void mouseReleasedHandler(MouseEvent event) {
        x2 = event.getX();
        y2 = event.getY();
        drawTool.draw(x1, y1, x2, y2);
    }

    private void mouseDraggedHandler(MouseEvent event) {
        x2 = event.getX();
        y2 = event.getY();
        drawTool.draw(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
    }

    public void runHandler() {
        if (drawTool instanceof LineTool) {
            canvas.addEventHandler(MOUSE_PRESSED, this::mousePressedHandler);
            canvas.addEventHandler(MOUSE_RELEASED, this::mouseReleasedHandler);
        }
        else if (drawTool instanceof DotTool) {
            canvas.addEventHandler(MOUSE_PRESSED, this::mousePressedHandler);
            canvas.addEventHandler(MOUSE_DRAGGED, this::mouseDraggedHandler);
        }
    }

    public void stopHandler() {
        canvas.removeEventHandler(MOUSE_PRESSED, this::mousePressedHandler);
        canvas.removeEventHandler(MOUSE_RELEASED, this::mouseReleasedHandler);
        canvas.removeEventHandler(MOUSE_DRAGGED, this::mouseDraggedHandler);
    }
}
