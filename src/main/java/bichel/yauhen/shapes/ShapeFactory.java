package bichel.yauhen.shapes;

/**
 * Interface for shape factory, which allows creating instances of Shape2D and Shape3D
 */
public interface ShapeFactory {
    /**
     * Instantiates shape instances based on shape type
     * @param shapeType shape type as Circle, Rectangle, Sphere, Platonic Solid, etc
     * @param shapeValues shape variables, which are required to compute area, perimeter or volume
     * @return instance of the created shape
     */
    Shape createShape(String shapeType, String shapeValues);
}
