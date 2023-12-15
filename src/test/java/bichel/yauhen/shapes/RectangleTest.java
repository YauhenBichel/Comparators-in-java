package bichel.yauhen.shapes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the Rectangle class */
@RunWith(Parameterized.class)
public class RectangleTest {
    private final double expectedArea;
    private final double expectedPerimeter;
    private final Rectangle rectangle;

    public RectangleTest(double height, double width, double expectedArea, double expectedPerimeter) {
        this.expectedArea = expectedArea;
        this.expectedPerimeter = expectedPerimeter;
        this.rectangle = new Rectangle(height, width);
    }

    @Test
    public void testArea() {
        double actualArea = rectangle.area();
        assertEquals(expectedArea, actualArea, 0.01);
    }

    @Test
    public void testPerimeter() {
        double actualPerimeter = rectangle.perimeter();
        assertEquals(expectedPerimeter, actualPerimeter, 0.01);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{0.5, 8, 4.0, 17.0});
        inputExpectedList.add(new Object[]{10, 0.02, .20, 20.04});
        return inputExpectedList;
    }
}

