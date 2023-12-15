package bichel.yauhen.comparators;

import bichel.yauhen.shapes.Shape2D;
import java.util.Comparator;

/** A custom comparator that compares shapes by perimeter. */
public class PerimeterComparator implements Comparator<Shape2D> {

	/**
	 * Compare shapes based on the perimeter
	 *
	 * @param shape1 first shape
	 * @param shape2 second shape
	 * @return 0 if perimeter of shapes are equal, a negative value if the perimeter of shape1 is less than
	 * the perimeter of shape2, and a positive value otherwise.
	 */
	@Override
	public int compare(Shape2D shape1, Shape2D shape2) {
		return Double.compare(shape1.perimeter(), shape2.perimeter());
	}
}
