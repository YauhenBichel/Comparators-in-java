package bichel.yauhen.comparators;

import bichel.yauhen.shapes.Shape;
import java.util.Comparator;

/** A custom comparator that compares shapes by area.*/
public class AreaComparator implements Comparator<Shape> {

	/**
	 * Compare shapes based on the area
	 *
	 * @param shape1 first shape
	 * @param shape2 second shape
	 * @return 0 if areas of shapes are equal, a negative value if the area of shape1 is less than
	 * the area of shape2, and a positive value otherwise.
	 */
	@Override
	public int compare(Shape shape1, Shape shape2) {
		return Double.compare(shape1.area(), shape2.area());
	}
}
