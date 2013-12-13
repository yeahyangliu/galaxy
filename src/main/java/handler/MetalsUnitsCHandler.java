package handler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static handler.UnitTranslateHandler.getUnitRomanMap;
import static roman.Calculator.calculateValueOfString;

public class MetalsUnitsCHandler extends InterpreterHandler {
    private static final String REGX = "^([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+([a-zA-Z]+)\\s+is\\s+(\\d+)\\s+Credits$";
    private static Map<String, Double> unitsStorage = new HashMap<String, Double>(100);

    public static Map<String, Double> getUnitsStorage() {
        return unitsStorage;
    }

    @Override
    public void interpret(String param) {

        Matcher matcher = getMatcher(param, REGX);

        if (matcher.find()) {
            setMapForMetals(matcher);

        } else {
            getNextHandler().interpret(param);
        }
    }

    private void setMapForMetals(Matcher matcher) {
        String key1 = matcher.group(1);
        String key2 = matcher.group(2);
        String key3 = matcher.group(3);
        String val = matcher.group(4);

        Map<String, String> romanSymbolMapping = getUnitRomanMap();
        String romanSymbol1 = romanSymbolMapping.get(key1);
        String romanSymbol2 = romanSymbolMapping.get(key2);

        if (romanSymbol1 == null || romanSymbol2 == null) {
            System.out.println(" u need set roman symbol");
            return;
        }

        int romanInt = calculateValueOfString(romanSymbol1 + romanSymbol2);

        double unitVal = new BigDecimal(val).divide(new BigDecimal(romanInt)).doubleValue();
        unitsStorage.put(key3, unitVal);

        System.out.println("set unit= " + key3 + ", val= " + unitVal + " successfully!");
    }
}
