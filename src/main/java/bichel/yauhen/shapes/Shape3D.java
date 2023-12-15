package bichel.yauhen.shapes;

/** An abstract class Shape3D. Extends Shape.
 * A direct parent of all three-dimensional shape classes.
 */
public abstract class Shape3D extends Shape {

    /**
     * An abstract method for computing volume of 3D shape
     * @return double value of volume
     */
    public abstract double volume();

    /**
     * String of super class and volume
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + df.format(volume());
    }
}
