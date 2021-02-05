import java.util.Arrays;

public class BruteForce {
    // brute force without hint of 5 bits key.
    public int[] bruteForceNoHint(int[] PlainText, int[] CipherText) {
        int[] GuessKey = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; 

        // enurmerate all possible keys
        for (int i = 0; i < Math.pow(2, 10) - 1; i++)  {
            // return correct guess key
            if (GuessCorrect(GuessKey, PlainText, CipherText)) {
                return GuessKey;
            }
            for (int n = 0; n < 10; n++) {
                if (GuessKey[n] == 1) {
                    GuessKey[n] = 0;
                    continue;
                } else {
                    GuessKey[n] = 1;
                    break;
                }
            }
        }

        System.out.println("no answer!");
        return null;
    }

    public int[] bruteForce(int[] PlainText, int[] CipherText) {
        int[] HalfKey = new int[]{1, 0, 0, 0, 1};
        int[] GuessHalfKey = new int[]{0, 0, 0, 0, 0}; 

        // enurmerate all possible keys
        for (int i = 0; i < Math.pow(2, 5) - 1; i++)  {
            int[] wholeKey = utils.concat(HalfKey, GuessHalfKey);
            if (GuessCorrect(wholeKey, PlainText, CipherText)) {
                return wholeKey;
            }

            for (int n = 0; n < 5; n++) {
                if (GuessHalfKey[n] == 1) {
                    GuessHalfKey[n] = 0;
                    continue;
                } else {
                    GuessHalfKey[n] = 1;
                    break;
                }
            }
        }

        System.out.println("no answer!");
        return null;
    }

    // return true if the guess to the key is correct.
    public boolean GuessCorrect(int[] Key, int[] PlainText, int[] CipherText) {
        int[] GuessCT = SDES.sDES(Key, PlainText);
        if (Arrays.equals(CipherText, GuessCT)) {
            return true;
        }

        return false;
    }
}
