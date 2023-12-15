package bichel.yauhen.shapes;

/**
 * 3D Shape Sphere
 */
public class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    /**
     * Computes area of sphere
     * @return area of sphere
     */
    @Override
    public double area() {
        return 4 * Math.pow(radius, 2) * Math.PI;
    }

    /**
     * Computes volume of sphere
     * @return perimeter of sphere
     */
    @Override
    public double volume() {
        return (4 * Math.pow(radius, 3) * Math.PI) / 3;
    }
}
