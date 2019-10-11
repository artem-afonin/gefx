package core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class DrawTool {
    protected Color color;
    protected GraphicsContext graphicsContext;

    public DrawTool(GraphicsContext context) {
        this(context, Color.BLACK);
    }

    public DrawTool(GraphicsContext context, Color color) {
        this.graphicsContext = context;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}
