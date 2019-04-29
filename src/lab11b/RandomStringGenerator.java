package lab11b;

import java.util.Random;

class RandomStringGenerator {

    private static final String CHAR_LIST_ALLOWED =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int STRING_LENGTH = 8;

    public String getRandomString() {

        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST_ALLOWED.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random random = new Random();
        randomInt = random.nextInt(CHAR_LIST_ALLOWED.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

}