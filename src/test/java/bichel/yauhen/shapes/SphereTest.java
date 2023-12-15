package bichel.yauhen.shapes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the Sphere class */
@RunWith(Parameterized.class)
public class SphereTest {
    private final double expectedArea;
    private final double expectedVolume;
    private final Sphere sphere;

    public SphereTest(double radius, double expectedArea, double expectedVolume) {
        this.expectedArea = expectedArea;
        this.expectedVolume = expectedVolume;
        this.sphere = new Sphere(radius);
    }

    @Test
    public void testArea() {
        double actualArea = sphere.area();
        assertEquals(expectedArea, actualArea, 0.01);
    }

    @Test
    public void testVolume() {
        double actualVolume = sphere.volume();
        assertEquals(expectedVolume, actualVolume, 0.01);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{1.5, 28.27, 14.14});
        inputExpectedList.add(new Object[]{5.0, 314.16, 523.60});
        inputExpectedList.add(new Object[]{4.0, 201.06, 268.08});
        return inputExpectedList;
    }
}
