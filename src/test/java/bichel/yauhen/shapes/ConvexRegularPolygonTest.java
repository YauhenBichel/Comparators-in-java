package bichel.yauhen.shapes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the ConvexRegularPolygon class */
@RunWith(Parameterized.class)
public class ConvexRegularPolygonTest {
    private final double expectedArea;
    private final double expectedPerimeter;
    private final ConvexRegularPolygon convexRegularPolygon;

    public ConvexRegularPolygonTest(int numOfSides, double oneSideLength, double expectedArea, double expectedPerimeter) {
        this.expectedArea = expectedArea;
        this.expectedPerimeter = expectedPerimeter;
        this.convexRegularPolygon = new ConvexRegularPolygon(numOfSides, oneSideLength);
    }

    @Test
    public void testArea() {
        double actualArea = convexRegularPolygon.area();
        assertEquals(expectedArea, actualArea, 0.01);
    }

    @Test
    public void testVolume() {
        double actualPerimeter = convexRegularPolygon.perimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.01);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{5, 1.0, 1.72, 5.0});
        inputExpectedList.add(new Object[]{7, 2.0, 14.54, 14.0});
        inputExpectedList.add(new Object[]{3, 3.1, 4.16, 9.30});
        return inputExpectedList;
    }
}

