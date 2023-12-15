package bichel.yauhen.shapes;

/**
 * 2D Shape rectangle
 */
public class Rectangle extends Shape2D {

    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Computes area of rectangle
     * @return area of rectangle
     */
    @Override
    public double area() {
        return height * width;
    }

    /**
     * Computes perimeter of rectangle
     * @return perimeter of rectangle
     */
    @Override
    public double perimeter() {
        return 2 * (height + width);
    }
}
