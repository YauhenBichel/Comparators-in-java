package bichel.yauhen.shapes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the PlatonicSolid class */
@RunWith(Parameterized.class)
public class PlatonicSolidTest {
    private final double expectedArea;
    private final double expectedVolume;
    private final PlatonicSolid platonicSolid;

    public PlatonicSolidTest(int q, int p, double a, double expectedArea, double expectedVolume) {
        this.expectedArea = expectedArea;
        this.expectedVolume = expectedVolume;
        this.platonicSolid = new PlatonicSolid(q, p, a);
    }

    @Test
    public void testArea() {
        double actualArea = platonicSolid.area();
        assertEquals(expectedArea, actualArea, 0.01);
    }

    @Test
    public void testVolume() {
        double actualVolume = platonicSolid.volume();
        assertEquals(expectedVolume, actualVolume, 0.01);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{4, 3, 1.0, 3.46, 0.47});
        inputExpectedList.add(new Object[]{3, 3, 2.0, 6.93, 0.94});
        inputExpectedList.add(new Object[]{3, 5, 2.5, 129.04, 119.74});
        return inputExpectedList;
    }
}

