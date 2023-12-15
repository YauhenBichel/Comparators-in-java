package bichel.yauhen.shapes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the Circle class */
@RunWith(Parameterized.class)
public class CircleTest {
    private final double expectedArea;
    private final double expectedPerimeter;
    private final Circle circle;

    public CircleTest(double radius, double expectedArea, double expectedPerimeter) {
        this.expectedArea = expectedArea;
        this.expectedPerimeter = expectedPerimeter;
        this.circle = new Circle(radius);
    }

    @Test
    public void testArea() {
        double actualArea = circle.area();
        assertEquals(expectedArea, actualArea, 0.01);
    }

    @Test
    public void testPerimeter() {
        double actualPerimeter = circle.perimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.01);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{1.0, 3.14, 6.28});
        inputExpectedList.add(new Object[]{2.5, 19.63, 15.71});
        inputExpectedList.add(new Object[]{4.0, 50.27, 25.13});
        return inputExpectedList;
    }
}
