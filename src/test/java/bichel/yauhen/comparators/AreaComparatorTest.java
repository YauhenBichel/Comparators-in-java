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

/** Class for testing the AreaComparator class */
@RunWith(Parameterized.class)
public class AreaComparatorTest {

    private final Shape shape1;
    private final Shape shape2;
    private final int expectedCompareResult;
    private final AreaComparator areaComparator;

    public AreaComparatorTest(Shape shape1, Shape shape2, int expectedCompareResult) {
        this.shape1 = shape1;
        this.shape2 = shape2;
        this.expectedCompareResult = expectedCompareResult;
        areaComparator = new AreaComparator();
    }

    @Test
    public void testAreaComparison() {
        int actualCompareResult = areaComparator.compare(shape1, shape2);
        assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{new Circle(1.0), new Circle(1.0), 0});
        inputExpectedList.add(new Object[]{new Circle(2.0), new Circle(1.0), 1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Circle(2.0), -1});
        inputExpectedList.add(new Object[]{new Sphere(1.0), new Circle(1.0), 1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Rectangle(1.0, 2.0), 1});
        inputExpectedList.add(new Object[]{new Rectangle(1.0, 2.0), new Circle(1.0), -1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new PlatonicSolid(1, 2, 1.0), 1});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new Circle(1.0), -1});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new PlatonicSolid(1, 2, 1.0), 0});
        inputExpectedList.add(new Object[]{new Circle(1.0), new ConvexRegularPolygon(1, 1.0), 1});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new Circle(1.0), -1});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new ConvexRegularPolygon(1, 1.0), 0});
        return inputExpectedList;
    }
}

