package bichel.yauhen.comparators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import bichel.yauhen.shapes.PlatonicSolid;
import bichel.yauhen.shapes.Shape3D;
import bichel.yauhen.shapes.Sphere;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Class for testing the VolumeComparator class */
@RunWith(Parameterized.class)
public class VolumeComparatorTest {

    private final Shape3D shape1;
    private final Shape3D shape2;
    private final int expectedCompareResult;
    private final VolumeComparator volumeComparator;

    public VolumeComparatorTest(Shape3D shape1, Shape3D shape2, int expectedCompareResult) {
        this.shape1 = shape1;
        this.shape2 = shape2;
        this.expectedCompareResult = expectedCompareResult;
        volumeComparator = new VolumeComparator();
    }

    @Test
    public void testVolumeComparison() {
        int actualCompareResult = volumeComparator.compare(shape1, shape2);
        assertEquals(expectedCompareResult, actualCompareResult);
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> loadTestData() {

        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{new Sphere(1.0), new Sphere(1.0), 0});
        inputExpectedList.add(new Object[]{new Sphere(2.0), new Sphere(1.0), 1});
        inputExpectedList.add(new Object[]{new Sphere(1.0), new Sphere(2.0), -1});
        inputExpectedList.add(new Object[]{new Sphere(1.0), new PlatonicSolid(1, 2, 1.0), 1});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new Sphere(1.0), -1});
        inputExpectedList.add(new Object[]{new PlatonicSolid(1, 2, 1.0), new PlatonicSolid(1, 2, 1.0), 0});
        return inputExpectedList;
    }
}
