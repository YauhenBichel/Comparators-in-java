package bichel.yauhen.shapes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * ShapeSorter stores a collection of shapes and is able to sort shapes based
 * on different criteria. Stores shapes in a map that has three keys: "all", "2D", "3D".
 * For each key, stores a list of shapes that correspond to this key.
 * For instance:
 * - for the key "all", the corresponding value is the list of all shapes
 * - for the key "2D", the corresponding value is the list of two-dimensional shapes
 * - for the key "3D", the corresponding value is the of three-dimensional shapes
 *
 * The class provides a method to sort shapes of a given type with the given Comparator.
 * For general shapes we have an option to sort by area or by name.
 * For 2d shapes, we can sort by area, by perimeter or by name.
 * For 3d shapes, we can sort by area, by volume or by name.
 *
 * Do NOT change the signatures of methods in this class, but you may add more methods of your own.
 * @author okarpenko
 *
 */
public class ShapeSorter {
	private final Map<String, List<Shape>> shapesMap; // see the comment above the class for the description of the map
	private final ShapeFactory shapeFactory;

	/**
	 * Constructor for class ShapeSorter. Reads information about each shape from the given input file,
	 * creates an object of the appropriate class and adds it to the shapesMap.
	 *
	 * @param inputFile
	 */
	public ShapeSorter(String inputFile) {
		this.shapeFactory = new DefaultShapeFactory();
		shapesMap = new HashMap<>();

		readShapesFile(inputFile);
	}

	private void readShapesFile(String inputFile) {
		final String splitter = ":";

		try {
			Scanner scanner = new Scanner(new File(inputFile));

			while (scanner.hasNextLine()) {
				final String shapeRecord = scanner.nextLine();
				final String[] parts = shapeRecord.split(splitter);
				final String shapeType = parts[0];
				final String shapeValues = parts[1];

				Shape shape = shapeFactory.createShape(shapeType, shapeValues);
				if(shape != null) {
					shapesMap.computeIfAbsent(Constants.SHAPE_CATEGORY_ALL, val -> new ArrayList<>()).add(shape);

					if (shape instanceof Shape2D) {
						shapesMap.computeIfAbsent(Constants.SHAPE_CATEGORY_2D, val -> new ArrayList<>()).add(shape);
					} else if (shape instanceof Shape3D) {
						shapesMap.computeIfAbsent(Constants.SHAPE_CATEGORY_3D, val -> new ArrayList<>()).add(shape);
					}
				}
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sort a list of Shapes
	 *
	 * @param type       A string, either "all", "2D" or "3D" - specifies which shapes to sort
	 * @param comparator A Comparator that tells the method how to sort shapes.
	 */
	public void sortShapes(String type, Comparator<? extends Shape> comparator) {
		switch (type) {
			case Constants.SHAPE_CATEGORY_ALL -> shapesMap.get(Constants.SHAPE_CATEGORY_ALL).sort((Comparator<? super Shape>) comparator);
			case Constants.SHAPE_CATEGORY_2D -> shapesMap.get(Constants.SHAPE_CATEGORY_2D).sort((Comparator<? super Shape>) comparator);
			case Constants.SHAPE_CATEGORY_3D -> shapesMap.get(Constants.SHAPE_CATEGORY_3D).sort((Comparator<? super Shape>) comparator);
		}
	}

	/**
	 * Print the list of shapes to a file as following:
	 * First, all 2D shapes, one line per shape;
	 * each shape is printed according to the toString() method in the corresponding parent class.
	 * An empty line after printing all 2D shapes.
	 * <p>
	 * Then all 3D shapes, one line per shape;
	 * each shape is printed according to the toString() method in the corresponding parent class.
	 * An empty line after printing all 3D Shapes.
	 * <p>
	 * Then all shapes.
	 * Each shape is printed according to the format specified in the toString()
	 * method of the corresponding parent class
	 * An empty line.
	 * <p>
	 * See expectedOutput1 and expectedOutput2 in the output folder
	 *
	 * @param filename the name of the output file
	 */
	public void printToFile(String filename) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
			List<Shape> shape2DList = shapesMap.get(Constants.SHAPE_CATEGORY_2D);
			writeShapesToFile(shape2DList, out);

			List<Shape> shape3DList = shapesMap.get(Constants.SHAPE_CATEGORY_3D);
			writeShapesToFile(shape3DList, out);

			List<Shape> shapeList = shapesMap.get(Constants.SHAPE_CATEGORY_ALL);
			writeShapesToFile(shapeList, out);

		} catch (IOException e) {
			// This method must catch IOException
			e.printStackTrace();
		}
	}

	private void writeShapesToFile(List<Shape> shapeList, BufferedWriter out) throws IOException {
		for(Shape shape: shapeList) {
			out.write(shape.toString());
			out.newLine();
		}
		out.newLine();
	}
}
