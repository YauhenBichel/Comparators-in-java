package bichel.yauhen.shapes;

import java.util.regex.Pattern;

/**
 * Contains static utility methods
 */
public final class Utilities {
    private Utilities() {}

    /**
     * Checks whether string is number
     * @param strNum string
     * @return true is strNum is number,false otherwise
     */
    public static boolean isNumeric(String strNum) {
        Pattern numericPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if (strNum == null) {
            return false;
        }

        return numericPattern.matcher(strNum).matches();
    }
}
