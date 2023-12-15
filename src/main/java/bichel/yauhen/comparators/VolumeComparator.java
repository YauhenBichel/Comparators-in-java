package bichel.yauhen.comparators;

import bichel.yauhen.shapes.Shape3D;
import java.util.Comparator;

/** A custom comparator that compares shapes by volume. */
public class VolumeComparator implements Comparator<Shape3D> {

	/**
	 * Compare shapes based on the volume
	 *
	 * @param shape1 first shape
	 * @param shape2 second shape
	 * @return 0 if volumes of shapes are equal, a negative value if the volume of shape1 is less than
	 * the volume of shape2, and a positive value otherwise.
	 */
	@Override
	public int compare(Shape3D shape1, Shape3D shape2) {
		return Double.compare(shape1.volume(), shape2.volume());
	}
}
