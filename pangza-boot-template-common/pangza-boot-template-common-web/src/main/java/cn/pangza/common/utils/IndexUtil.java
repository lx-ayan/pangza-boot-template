package cn.pangza.common.utils;

import java.util.concurrent.ThreadLocalRandom;

public class IndexUtil {
    public static Integer randomCode() {
        return ThreadLocalRandom.current().nextInt(999999) + 1;
    }
    public static String generateRandomString(Integer length) {
        if(length == null) {
            length = 6;
        }

        if (length <= 0) {
            length = 6;
        }

        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(chars.length());
            stringBuilder.append(chars.charAt(randomIndex));
        }

        return stringBuilder.toString();
    }
}
