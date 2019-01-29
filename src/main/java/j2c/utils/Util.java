package j2c.utils;

import java.util.Random;

public class Util {


    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static String getFormattedDate(String dt) {
        // TODO
        return dt;
    }

}


