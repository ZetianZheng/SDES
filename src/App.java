import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // --------------------------- Encryption ------------------------------------------
        // if you want to do encryption using data from input.csv uncomment these three lines
        // CsvDataEncrypt cde = new CsvDataEncrypt();
        // cde.csvDataEncrypt();
        // System.out.println("Encyption done! Results have been stored in data/output.csv!");

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

        // --------------------------- CTR Mode ------------------------------------------
        int[] pt = new int[]{0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1};
        int[] key = new int[]{1, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        // int[] ct = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1};
        CTR ctr = new CTR();
        System.out.println("CTR mode cipher text:" + Arrays.toString(ctr.CTREncrypt(pt, key)));
        // System.out.println(Arrays.toString(ctr.CTREncrypt(ct, key)));

        // --------------------------- CBC Mode ------------------------------------------
        int[] iv = new int[]{0, 1, 0, 0, 0, 0, 1, 0};
        CBC cbc = new CBC();
        System.out.println("CBC mode cipher text:" + Arrays.toString(cbc.CBCEncrypt(iv, pt, key)));


    }
}
