package bichel.yauhen.shapes;

/**
 * 2D Shape ConvexRegularPolygon
 */
public class ConvexRegularPolygon extends Shape2D {

    private final int numOfSides;
    private final double oneSideLength;
    private final double apothem;

    public ConvexRegularPolygon(int numOfSides, double oneSideLength) {
        this.numOfSides = numOfSides;
        this.oneSideLength = oneSideLength;
        this.apothem = computeApothem();
    }

    /**
     * Computes area of convex regular polygon
     * @return area of convex regular polygon
     */
    @Override
    public double area() {
        return 0.5 * apothem * perimeter();
    }

    /**
     * Computes perimeter of convex regular polygon
     * @return perimeter of convex regular polygon
     */
    @Override
    public double perimeter() {
        return numOfSides * oneSideLength;
    }

    private double computeApothem() {
        return this.oneSideLength / (2 * Math.tan((180 / (double)numOfSides) * Math.PI / 180));
    }
}
