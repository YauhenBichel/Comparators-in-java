package bichel.yauhen.shapes;

/**
 * 2D Shape circle
 */
public class Circle extends Shape2D {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Computes area of circle
     * @return area of circle
     */
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

    /**
     * Computes perimeter of circle
     * @return perimeter of circle
     */
    @Override
    public double perimeter() {
        return 2 * radius * Math.PI;
    }
}
