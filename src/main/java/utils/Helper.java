package utils;

public class Helper {

    public static void delayFor(int timeinmili){
        try {
            Thread.sleep(timeinmili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
