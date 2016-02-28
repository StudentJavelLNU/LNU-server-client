package se.jherrlin.utils;


public class Utils {

    public static void sleep(){
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
