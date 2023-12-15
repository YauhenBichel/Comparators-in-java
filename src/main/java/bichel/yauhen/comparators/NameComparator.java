package bichel.yauhen.comparators;

import bichel.yauhen.shapes.Shape;
import java.util.Comparator;

/** A custom comparator that compares shapes by name alphabetically.*/
public class NameComparator implements Comparator<Shape> {

	/**
	 * Compare shapes based on the name
	 *
	 * @param shape1 first shape
	 * @param shape2 second shape
	 * @return 0 if names of shapes are equal, a negative value if the name of shape1 is less than
	 * the name of shape2, and a positive value otherwise.
	 */
	@Override
	public int compare(Shape shape1, Shape shape2) {
		//with reference to tests, if names are the same, then compare areas
		if (shape1.name().compareTo(shape2.name()) == 0) {
			return Double.compare(shape1.area(), shape2.area());
		}
		return shape1.name().compareTo(shape2.name());
	}
}
