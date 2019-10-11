package core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineTool extends DrawTool{
    public LineTool(GraphicsContext context) {
        super(context);
    }

    public LineTool(GraphicsContext context, Color color) {
        super(context, color);
    }

    public void draw(double x1, double y1, double x2, double y2) {
        graphicsContext.setStroke(color);
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }
}
