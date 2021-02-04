import java.util.Arrays;

public class Encryption {
    public static final int[] IP = new int[]{2, 6, 3, 1, 4, 8, 5, 7};
    public static final int[] RERVERSEIP = new int[]{4, 1, 3, 5, 7, 2, 8, 6};
    
    // encryption function
    // @param plainText
    // @param key
    //
    // Firstly, do initial permutation to plaintext
    // Then, select left 4 bits and right 4 bits of resultIP
    // Do f function to right side get resultF1, 
    // Switch resultF1 and right side of resultIP
    // Do f function again to resultF1 get resultF2
    // Do final permutation of concat of resultF2 + resultF1
    // Get  CT = BA
    public int[] encryption(int[] plainText, Key key) {
        int[] k1 = key.k1;
        int[] k2 = key.k2;

        int[] resultIP = initialPermutation(plainText);

        int[] resultIPLeft = Arrays.copyOfRange(resultIP, 0, 4); // 0011
        int[] resultIPRight = Arrays.copyOfRange(resultIP, 4, 8); // 0011

        FFunction ff = new FFunction();
        int[] resultF1 = ff.fFunction(resultIPLeft, resultIPRight, k1); // 1011
        int[] resultF2 = ff.fFunction(resultIPRight, resultF1, k2); // 0011

        int[] resultF = utils.concat(resultF2, resultF1);
        int[] cipherText = finalPermutation(resultF);

        return cipherText;
    }

    public int[] initialPermutation(int[] plainText) {
        return Permutation.Permute(IP, plainText);
    }

    public int[] finalPermutation(int[] input) {
        return Permutation.Permute(RERVERSEIP, input);
    }
}
