import bichel.yauhen.comparators.*;
import bichel.yauhen.shapes.ShapeSorter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

/** Class for testing the ShapeSorter class */
public class ShapeSorterTest {

    @Test
    public void test_sortByArea_print() {
        String testName = "test_sortByArea_print";
        String inputShapeFile = "input" + File.separator + "shapesFile";
        String studentOutput1 = "output" + File.separator + "studentOutput1";

        Path actual = Paths.get(studentOutput1);

        ShapeSorter sorter = new ShapeSorter(inputShapeFile);
        if (Files.exists(actual)) {
            try{
                Files.delete(actual);
            }
            catch(IOException e) {
                System.out.println("Error while deleting the file :" + actual.toString());
            }
        }

        sorter.sortShapes("all",new AreaComparator());
        sorter.sortShapes("2D", new AreaComparator());
        sorter.sortShapes("3D", new AreaComparator());
        sorter.printToFile(studentOutput1);

        actual = Paths.get(studentOutput1);
        Path expected = Paths.get("output/sortedShapes1"); 											// output
        // Compare files
        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
            System.out.println(count);
        } catch (IOException e) {
            Assert.fail(String.format("%n" + "Test Case: %s%n" + " File check failed: %s%n", testName, e.getMessage()));
        }

        if (count <= 0) {
            Assert.fail(String.format("%n" + "Test Case: %s%n" + " Mismatched Line: %d%n", testName, -count));
        }

    }

    @Test
    public void test_sortAll_print() {
        String testName = "test_sortAll_print";
        String inputShapeFile = "input" + File.separator + "shapesFile";
        String studentOutput2 = "output" + File.separator + "studentOutput2";

        Path actual = Paths.get(studentOutput2);

        ShapeSorter sorter = new ShapeSorter(inputShapeFile);
        if (Files.exists(actual)) {
            try{
                Files.delete(actual);
            }
            catch(IOException e) {
                System.out.println("Error while deleting the file :" + actual.toString());
            }
        }

        sorter.sortShapes("all",new NameComparator()); // if names are same, sort by area
        sorter.sortShapes("2D", new PerimeterComparator());
        sorter.sortShapes("3D", new VolumeComparator());
        sorter.printToFile(studentOutput2);

        actual = Paths.get(studentOutput2);
        Path expected = Paths.get("output/sortedShapes2"); 											// output
        // Compare files
        int count = 0;
        try {
            count = TestUtils.checkFiles(expected, actual);
            System.out.println(count);
        } catch (IOException e) {
            Assert.fail(String.format("%n" + "Test Case: %s%n" + " File check failed: %s%n", testName, e.getMessage()));
        }

        if (count <= 0) {
            Assert.fail(String.format("%n" + "Test Case: %s%n" + " Mismatched Line: %d%n", testName, -count));
        }

    }
}


