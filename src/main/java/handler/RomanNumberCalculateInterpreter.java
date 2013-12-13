package handler;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static handler.UnitTranslateHandler.getUnitRomanMap;
import static roman.Calculator.calculateValueOfString;

public class RomanNumberCalculateInterpreter extends InterpreterHandler {

    private static final String REGX = "^how\\s+much\\s+is([ A-Za-z]+)\\?$";
    public static final String SPLITER = " ";

    @Override
    public void interpret(String param) {

        Matcher matcher = getMatcher(param, REGX);

        if (matcher.find()) {
            handleQuestion(matcher);
        } else {
            getNextHandler().interpret(param);
        }
    }

    private void handleQuestion(Matcher matcher) {
        String val = matcher.group(1);

        val = val.trim();

        if (val.length() == 0) {
            System.out.println("input format like this : how much is pish tegj glob glob ? ");
        } else {
            String romanString = "";
            String[] valArray = val.split(SPLITER);
            Map<String, String> romanSymbolMapping = getUnitRomanMap();

            for (String valUnit : valArray) {

                String romanSymbol = romanSymbolMapping.get(valUnit);

                if (romanSymbol == null) {
                    System.out.println(" u need set roman symbol for " + valUnit);
                }
                romanString = romanString + romanSymbol;
            }

            int romanInt = calculateValueOfString(romanString);

            System.out.println(val + " is " + romanInt);
        }
    }

}
