package core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DotTool extends DrawTool {
    public DotTool(GraphicsContext context) {
        super(context);
    }

    public DotTool(GraphicsContext context, Color color) {
        super(context, color);
    }

    public void draw(double x, double y) {
        configureGraphicsContext();
        graphicsContext.strokeLine(x, y, x, y);
    }
}
