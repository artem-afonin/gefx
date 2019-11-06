package gefx.core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CircleTool extends DrawTool {
    public CircleTool() {
        super();
    }

    public CircleTool(GraphicsContext context) {
        super(context);
    }

    public CircleTool(GraphicsContext context, Color color) {
        super(context, color);
    }

    @Override
    protected void draw(double x1, double y1, double x2, double y2) {
        configureGraphicsContext();

        if (x2 >= x1) {
            if (y2 >= y1) graphicsContext.strokeOval(x1, y1, x2 - x1, y2 - y1);
            else graphicsContext.strokeOval(x1, y2, x2 - x1, y1 - y2);
        } else {
            if (y2 >= y1) graphicsContext.strokeOval(x2, y1, x1 - x2, y2 - y1);
            else graphicsContext.strokeOval(x2, y2, x1 - x2, y1 - y2);
        }
    }
}
