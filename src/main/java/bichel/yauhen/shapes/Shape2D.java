package bichel.yauhen.shapes;

/** An abstract class Shape2D. Extends Shape.
 * A direct parent of all two-dimensional shape classes.
 */
public abstract class Shape2D extends Shape {

    /**
     * An abstract method for computing perimeter of 2D shape
     * @return @return double value of perimeter
     */
    public abstract double perimeter();

    /**
     * String of super class and perimeter
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + df.format(perimeter());
    }
}

