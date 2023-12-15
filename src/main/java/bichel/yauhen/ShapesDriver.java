package bichel.yauhen;

import bichel.yauhen.comparators.AreaComparator;
import bichel.yauhen.comparators.NameComparator;
import bichel.yauhen.comparators.PerimeterComparator;
import bichel.yauhen.comparators.VolumeComparator;
import bichel.yauhen.shapes.ShapeSorter;

import static bichel.yauhen.shapes.Constants.SHAPE_CATEGORY_2D;
import static bichel.yauhen.shapes.Constants.SHAPE_CATEGORY_3D;
import static bichel.yauhen.shapes.Constants.SHAPE_CATEGORY_ALL;

public class ShapesDriver {
    public static void main(String[] args) {
        // Get arguments from the args array: input file, output file1, output file2

        if(args.length < 3) {
            System.out.println("Expects three arguments: input file, output file1, output file2. Please review program arguments");
            return;
        }

        String inputFile = args[0];
        String outputFile1 = args[1];
        String outputFile2 = args[2];

        ShapeSorter shapeSorter = new ShapeSorter(inputFile);

        AreaComparator areaComparator = new AreaComparator();
        shapeSorter.sortShapes(SHAPE_CATEGORY_ALL, areaComparator);
        shapeSorter.sortShapes(SHAPE_CATEGORY_2D, areaComparator);
        shapeSorter.sortShapes(SHAPE_CATEGORY_3D, areaComparator);
        shapeSorter.printToFile(outputFile1);

        shapeSorter.sortShapes(SHAPE_CATEGORY_ALL, new NameComparator());
        shapeSorter.sortShapes(SHAPE_CATEGORY_2D, new PerimeterComparator());
        shapeSorter.sortShapes(SHAPE_CATEGORY_3D, new VolumeComparator());
        shapeSorter.printToFile(outputFile2);
    }
}
