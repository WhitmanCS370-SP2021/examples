public class Shape {
    public static final int LINE = 1;
    public static final int CIRCLE = 2;
    public static final int TRIANGLE = 3;
    public static final int RECTANGLE = 4;

    private int shapeType;
    private double width, height;

    public Shape(int shapeType, double width, double height) {
        this.shapeType = shapeType; 
        this.width = width;
        this.height = height;
    }

    public int getShapeType() { 
        return shapeType; 
    }

    public double area() {
        if (shapeType == LINE) {
            throw new UnsupportedOperationException();
        } 
        else if (shapeType == CIRCLE) {
            return 3.14159 * width * width / 4.0;
        }
        else if (shapeType == TRIANGLE) {
            return width * height / 2.0;
        }
        else if (shapeType == RECTANGLE) {
            return width * height;
        }
        else {
            return 0;
        }
    }
}

