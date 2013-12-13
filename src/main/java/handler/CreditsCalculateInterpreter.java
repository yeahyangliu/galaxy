package handler;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static handler.MetalsUnitsCHandler.getUnitsStorage;
import static handler.UnitTranslateHandler.getUnitRomanMap;
import static roman.Calculator.calculateValueOfString;

public class CreditsCalculateInterpreter extends InterpreterHandler {


    private static final String REGX = "^how\\s+many\\s+Credits\\s+is\\s+([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+([a-zA-Z]+)\\s*\\?$";

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
        String key1 = matcher.group(1);
        String key2 = matcher.group(2);
        String key3 = matcher.group(3);

        Map<String, String> romanSymbolMapping = getUnitRomanMap();
        String romanSymbol1 = romanSymbolMapping.get(key1);
        String romanSymbol2 = romanSymbolMapping.get(key2);

        if (romanSymbol1 == null || romanSymbol2 == null) {
            System.out.println(" u need set roman symbol for " + key1);
            return;
        }

        Map<String, Double> unitsStorage = getUnitsStorage();

        Double unitVal = unitsStorage.get(key3);

        Integer romanInt = calculateValueOfString(romanSymbol1 + romanSymbol2);
        if (unitVal == null) {
            System.out.println("please set unit credits for " + key3);
        }

        unitVal = romanInt * unitVal;

        System.out.println(key1 + " " + key2 + " " + key3 + " is " + unitVal + "  Credits");
    }

}
