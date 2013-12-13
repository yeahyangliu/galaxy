package roman;

import static roman.RomanNumber.getValueFromString;

public class Calculator {

    public static int calculateValueOfString(String romanNumber) {
        int length = romanNumber.length();
        if (length <= 0) {
            throw new NumberFormatException();
        }

        return getResult(romanNumber, length);
    }

    private static int getResult(String romanNumber, int length) {
        int result = 0;
        for (int index = 0; index < length; ) {
            int number = getValue(romanNumber.charAt(index));

            index++;
            if (index == length) {
                result += number;
            } else {
                int numberOfNext = getValue(romanNumber.charAt(index));

                if (number < numberOfNext) {
                    result += numberOfNext - number;
                    index++;
                } else {
                    result += number;
                }
            }
        }
        return result;
    }

    private static int getValue(Character character) {
        return getValueFromString(character.toString()).getValue();
    }
}
