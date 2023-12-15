package bichel.yauhen.shapes;

import java.util.LinkedList;
import java.util.List;

/**
 * Default implementation of ShapeFactory
 */
public class DefaultShapeFactory implements ShapeFactory {
    /**
     * Implementation of interface method createShape
     * @param shapeType shape type as Circle, Rectangle, Sphere, Platonic Solid, etc
     * @param shapeValues shape variables, which are required to compute area, perimeter or volume
     * @return instance of creates shpae based on shape type
     */
    @Override
    public Shape createShape(String shapeType, String shapeValues) {

        List<String> numbers = fetchNumericWords(shapeValues);

        Shape shape = null;
        switch (shapeType) {
            case Constants.CIRCLE -> {
                if(numbers.isEmpty()) {
                    System.out.println("There are no values for shape circle");
                    break;
                }

                double radius = Double.parseDouble(numbers.get(0));
                shape = new Circle(radius);
            }
            case Constants.CONVEX_REGULAR_POLYGON -> {

                if(numbers.size() < 2) {
                    System.out.println("There are no values for shape convex regular polygon. The shape needs 2 parameters.");
                    break;
                }

                int numOfSides = Integer.parseInt(numbers.get(0));
                double oneSideLength = Double.parseDouble(numbers.get(1));
                shape = new ConvexRegularPolygon(numOfSides, oneSideLength);
            }
            case Constants.SPHERE -> {
                if(numbers.isEmpty()) {
                    System.out.println("There are no values for shape sphere");
                    break;
                }

                double radius = Double.parseDouble(numbers.get(0));
                shape = new Sphere(radius);
            }
            case Constants.PLATONIC_SOLID -> {
                if(numbers.size() < 3) {
                    System.out.println("There are no values for shape platonic solid. The shape needs 3 parameters.");
                    break;
                }

                int p = Integer.parseInt(numbers.get(0));
                int q = Integer.parseInt(numbers.get(1));
                double a = Double.parseDouble(numbers.get(2));
                shape = new PlatonicSolid(q, p, a);
            }
            case Constants.RECTANGLE -> {
                if(numbers.size() < 2) {
                    System.out.println("There are no values for shape rectangle. The shape needs 2 parameters.");
                    break;
                }

                double height = Double.parseDouble(numbers.get(0));
                double width = Double.parseDouble(numbers.get(1));
                shape = new Rectangle(height, width);
            }
            default -> throw new IllegalArgumentException(shapeType);
        }

        return shape;
    }

    /**
     * Fetches numeric words from a sentence
     * @param shapeValues sentence with numeric words
     * @return list of numbers as strings
     */
    private List<String> fetchNumericWords(String shapeValues) {
        final String[] values = shapeValues.split(" ");
        List<String> numbers = new LinkedList<>();
        for (String value : values) {
            if (Utilities.isNumeric(value)) {
                numbers.add(value);
            }
        }
        return numbers;
    }
}
