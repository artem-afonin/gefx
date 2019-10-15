package gefx.core.tool;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

abstract public class DrawTool {
    protected Color color;
    protected double currentOpacity;
    protected double strokeWidth;
    protected StrokeLineCap strokeLineCap;
    protected GraphicsContext graphicsContext;

    public DrawTool() {
        this(null);
    }

    public DrawTool(GraphicsContext context) {
        this(context, Color.BLACK);
    }

    public DrawTool(GraphicsContext context, Color color) {
        this.graphicsContext = context;
        this.color = color;
        currentOpacity = 1;
        strokeWidth = 5;
        strokeLineCap = StrokeLineCap.ROUND;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCurrentOpacity() {
        return currentOpacity;
    }

    public void setCurrentOpacity(double currentOpacity) {
        this.currentOpacity = currentOpacity;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public StrokeLineCap getStrokeLineCap() {
        return strokeLineCap;
    }

    public void setStrokeLineCap(StrokeLineCap strokeLineCap) {
        this.strokeLineCap = strokeLineCap;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    protected void configureGraphicsContext() {
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(strokeWidth);
        graphicsContext.setLineCap(strokeLineCap);
    }

    abstract protected void draw(double x1, double y1, double x2, double y2);
}
