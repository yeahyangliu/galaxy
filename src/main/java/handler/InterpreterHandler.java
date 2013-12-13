package handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class InterpreterHandler {

    private InterpreterHandler nextHandler;

    public InterpreterHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(InterpreterHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void interpret(String param);

    protected Matcher getMatcher(String param, String regx){
        param = param.trim();

        Pattern patten = Pattern.compile(regx);
        Matcher matcher = patten.matcher(param);
        return matcher;
    }
}
