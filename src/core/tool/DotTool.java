package core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DotTool extends DrawTool {
    public DotTool() {
        super();
    }

    public DotTool(GraphicsContext context) {
        super(context);
    }

    public DotTool(GraphicsContext context, Color color) {
        super(context, color);
    }

    @Override
    protected void draw(double x1, double y1, double x2, double y2) {
        configureGraphicsContext();
        graphicsContext.strokeLine(x1, y1, x2, y2);
    }

    public void draw(double x, double y) {
        draw(x, y, x, y);
    }
}
