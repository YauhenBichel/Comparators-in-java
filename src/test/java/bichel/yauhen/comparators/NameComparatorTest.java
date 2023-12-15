package bichel.yauhen.comparators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import bichel.yauhen.shapes.Circle;
import bichel.yauhen.shapes.ConvexRegularPolygon;
import bichel.yauhen.shapes.PlatonicSolid;
import bichel.yauhen.shapes.Rectangle;
import bichel.yauhen.shapes.Shape;
import bichel.yauhen.shapes.Sphere;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the NameComparator class */
@RunWith(Parameterized.class)
public class NameComparatorTest {

    private final Shape shape1;
    private final Shape shape2;
    private final int expectedCompareResult;
    private final NameComparator nameComparator;

    public NameComparatorTest(Shape shape1, Shape shape2, int expectedCompareResult) {
        this.shape1 = shape1;
        this.shape2 = shape2;
        this.expectedCompareResult = expectedCompareResult;
        nameComparator = new NameComparator();
    }

    @Test
    public void testNameComparison() {
        int actualCompareResult = nameComparator.compare(shape1, shape2);
        assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{new Circle(1.0), new Circle(1.0), 0});
        inputExpectedList.add(new Object[]{new Circle(2.0), new Circle(1.0), 1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Sphere(1.0), -16});
        inputExpectedList.add(new Object[]{new Sphere(1.0), new Circle(1.0), 16});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Rectangle(1.0, 2.0), -15});
        inputExpectedList.add(new Object[]{new Rectangle(1.0, 2.0), new Circle(1.0), 15});
        inputExpectedList.add(new Object[]{new Circle(1.0), new PlatonicSolid(1, 2, 1.0), -13});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new Circle(1.0), 13});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new PlatonicSolid(1, 2, 1.0), 0});
        inputExpectedList.add(new Object[]{new Circle(1.0), new ConvexRegularPolygon(1, 1.0), -6});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new Circle(1.0), 6});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new ConvexRegularPolygon(1, 1.0), 0});
        return inputExpectedList;
    }
}
