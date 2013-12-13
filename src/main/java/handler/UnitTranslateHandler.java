package handler;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitTranslateHandler extends InterpreterHandler {
    public static final String REGX = "^([a-zA-Z]+)\\s+is\\s+([a-zA-Z]+)$";
    private static Map<String, String> unitRomanMap = new HashMap<String, String>();

    @Override
    public void interpret(String param) {

        Matcher matcher = getMatcher(param, REGX);

        if (matcher.find()) {
            setMapFromRomanToUnit(matcher);
        } else {
            getNextHandler().interpret(param);
        }
    }

    private void setMapFromRomanToUnit(Matcher matcher) {
        String key = matcher.group(1);
        String value = matcher.group(2);

        unitRomanMap.put(key, value);
        System.out.println("translate " + key + " to " + value + " successfully!");
    }

    public static Map getUnitRomanMap() {
        return unitRomanMap;
    }
}
