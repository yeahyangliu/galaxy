import handler.*;

import java.util.Scanner;

public class Context {
    private InterpreterHandler handler = new UnitTranslateHandler();

    public Context() {

        MetalsUnitsCHandler metalsUnitsCHandler = new MetalsUnitsCHandler();
        RomanNumberCalculateInterpreter calculateInterpreter = new RomanNumberCalculateInterpreter();
        CreditsCalculateInterpreter creditsCalculateInterpreter = new CreditsCalculateInterpreter();

        handler.setNextHandler(metalsUnitsCHandler);
        metalsUnitsCHandler.setNextHandler(calculateInterpreter);
        calculateInterpreter.setNextHandler(creditsCalculateInterpreter);
        creditsCalculateInterpreter.setNextHandler(new ErrorInputInterpreter());
    }

    public void execute(String param) {
        handler.interpret(param);
    }

    public static void main(String[] args) {


        for (int i = 0; i < 6; i++) {
            if (i == 2) {
                try {
                    throw new NullPointerException();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            System.out.println(i);
        }


        Context context = new Context();

//        while (true) {
//            System.out.println("please input your command!");
//            Scanner in = new Scanner(System.in);
//            context.execute(in.nextLine());
//        }
    }

}
