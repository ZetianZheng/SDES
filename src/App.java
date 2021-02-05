import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // --------------------------- Encryption ------------------------------------------
        // if you want to do encryption using data from input.csv uncomment these three lines
        CsvDataEncrypt cde = new CsvDataEncrypt();
        cde.csvDataEncrypt();
        System.out.println("Encyption done! Results have been stored in data/output.csv!");

        // --------------------------- Brute Force ------------------------------------------
        // // if you want to do Brute Force by using plainText and cipherText, uncomment lines after this line
        // int[] plainText = new int[]{1, 0, 1, 0, 1, 0, 1, 0};
        // int[] cipherText = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
        // BruteForce bf = new BruteForce();

        // // using brute force to get whole key if knowing plaintext, first 5 bits keys and ciphertext.
        // int[] answer = bf.bruteForce(plainText, cipherText);
        // System.out.println("answer for 5 bits key: " + Arrays.toString(answer));

        // // using brute force to get whole key if knowing plaintext and ciphertext.
        // int[] answer2 = bf.bruteForceNoHint(plainText, cipherText);
        // System.out.println("answer for 10 bits key: " + Arrays.toString(answer2));
    }
}
