package bichel.yauhen.comparators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import bichel.yauhen.shapes.Circle;
import bichel.yauhen.shapes.ConvexRegularPolygon;
import bichel.yauhen.shapes.Rectangle;
import bichel.yauhen.shapes.Shape2D;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the PerimeterComparator class */
@RunWith(Parameterized.class)
public class PerimeterComparatorTest {

    private final Shape2D shape1;
    private final Shape2D shape2;
    private final int expectedCompareResult;
    private final PerimeterComparator perimeterComparator;

    public PerimeterComparatorTest(Shape2D shape1, Shape2D shape2, int expectedCompareResult) {
        this.shape1 = shape1;
        this.shape2 = shape2;
        this.expectedCompareResult = expectedCompareResult;
        perimeterComparator = new PerimeterComparator();
    }

    @Test
    public void testPerimeterComparison() {
        int actualCompareResult = perimeterComparator.compare(shape1, shape2);
        assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{new Circle(1.0), new Circle(1.0), 0});
        inputExpectedList.add(new Object[]{new Circle(2.0), new Circle(1.0), 1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Circle(2.0), -1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new Rectangle(1.0, 2.0), 1});
        inputExpectedList.add(new Object[]{new Rectangle(1.0, 2.0), new Circle(1.0), -1});
        inputExpectedList.add(new Object[]{new Circle(1.0), new ConvexRegularPolygon(1, 1.0), 1});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new Circle(1.0), -1});
        inputExpectedList.add(new Object[]{new ConvexRegularPolygon(1, 1.0), new ConvexRegularPolygon(1, 1.0), 0});
        return inputExpectedList;
    }
}
